package gov.inl;

import gov.inl.generated.Node;
import gov.inl.generated.SGComponents.Component;
import gov.inl.generated.SGComponents.Usecase;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class CommunicationTableGenerator implements TableGenerator {
    private DataAccessObject dao;
    private List<Component> components;
    private List<Component> uniqueComponents;

    public CommunicationTableGenerator(DataAccessObject dao) {
        this.dao = dao;

        List<Node> nodes = dao.getAllNodesFromFile();
        components = dao.getComponentsFromNodes(nodes);
        uniqueComponents = new ArrayList<>();
        
        for (Component comp : components)
        {
            if (!uniqueComponents.contains(comp))
            {
                uniqueComponents.add(comp);
            }
        }

    }

    @Override
    public List<String> generate() {
        List<String> lines = new ArrayList<>();

        List<Usecase> usecases = dao.getAllUsecases();

        for (Usecase usecase : usecases) {
            lines.addAll(getRowsForUsecase(usecase));
        }

        return lines;
    }

    private List<String> getRowsForUsecase(Usecase usecase) {
        List<String> lines = new ArrayList<>();

        Hashtable<Component, Integer> componentCount = getComponentCountForUsecase(usecase);

        for (Component component : componentCount.keySet()) {
            lines.add(String.format("%s,%s,%s,%s", usecase.getName(), dao.getPayloadForComponent(component, usecase),
                    componentCount.get(component), uniqueComponents.indexOf(component)));
        }

        return lines;
    }

    private Hashtable<Component, Integer> getComponentCountForUsecase(Usecase usecase) {
        Hashtable<Component, Integer> componentCount = new Hashtable<>();

        List<Component> validComponents = dao.getComponentsForUsecase(usecase);
        for (Component component : components) {
            if(validComponents.contains(component)) {
                componentCount.put(component, componentCount.getOrDefault(component, 0) + 1);
            }
        }

        return componentCount;
    }
}
