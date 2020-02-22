package gov.inl;

import gov.inl.generated.Edge;
import gov.inl.generated.Gen;
import gov.inl.generated.Node;
import gov.inl.generated.SGComponents.*;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DataAccessObject {

    private String inputFilename;
    private final EntityManager em;
    private final Session session;

    public DataAccessObject(String inputFilename) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("IGCAPT");
        em = emf.createEntityManager();
        session = em.unwrap(Session.class);
        this.inputFilename = inputFilename;
    }

    public void setInputFilename(String filename) {
        inputFilename = filename;
    }

    public List<Usecase> getAllUsecases() {
        return session.createCriteria(Usecase.class).list();
    }

    public List<Node> getAllNodesFromFile() {
        File file = getFileFromResources(inputFilename);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Gen.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Gen gen = (Gen) jaxbUnmarshaller.unmarshal(file);

            return gen.getNodeList().getNodes();
        } catch (Exception e) {

        }
        return new ArrayList<>();
    }

    public List<Edge> getAllEdgesFromFile() {
        File file = getFileFromResources(inputFilename);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Gen.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Gen gen = (Gen) jaxbUnmarshaller.unmarshal(file);

            return gen.getEdgeList().getEdges();
        } catch (Exception e) {

        }
        return new ArrayList<>();
    }

    public List<Component> getComponentsFromNodes(List<Node> nodes) {
        List<Component> components = new ArrayList<>();

        for (Node node : nodes) {
            components.add(getComponentFromNode(node));
        }

        return components;
    }

    private Component getComponentFromUuid(String id) {
        Criteria criteria = session.createCriteria(Component.class);
        return (Component) criteria.add(Restrictions.eq("uuid", id)).uniqueResult();
    }

    private Component getComponentFromId(Integer id) {
        Criteria criteria = session.createCriteria(Component.class);
        return (Component) criteria.add(Restrictions.eq("id", id)).uniqueResult();
    }

    public List<Component> getComponentsForUsecase(Usecase usecase) {
        List<Integer> componentIds = getComponentIdsForUsecase(usecase);

        return getComponentsFromIds(componentIds);
    }

    private List<Integer> getComponentIdsForUsecase(Usecase usecase) {
        Criteria criteria = session.createCriteria(ComponentUsecase.class);
        List<ComponentUsecase> componentUsecases = criteria.add(Restrictions.eq("usecaseId", usecase.getId())).list();

        return getComponentIdsFromComponentUsecases(componentUsecases);
    }

    private List<Integer> getComponentIdsFromComponentUsecases(List<ComponentUsecase> componentUsecases){
        List<Integer> componentIds = new ArrayList<>();
        for (ComponentUsecase componentUsecase : componentUsecases) {
            componentIds.add(componentUsecase.getComponentId());
        }
        return componentIds;
    }

    private List<Component> getComponentsFromIds(List<Integer> componentIds) {
        List<Component> components = new ArrayList<>(componentIds.size());

        for (Integer id : componentIds) {
            Component component = getComponentFromId(id);
            components.add(component);
        }

        return components;
    }

    public int getPayloadForComponent(Component component, Usecase usecase) {
        List<Integer> fieldIdsForUsecase = getFieldIdsForUsecase(usecase);

        int totalPayload = 0;

        for (Field field : component.getFieldsById()) {
            if(fieldIdsForUsecase.contains((int) field.getId())) {
                totalPayload += field.getPayload();
            }
        }
        return totalPayload;
    }

    private List<Integer> getFieldIdsForUsecase(Usecase usecase) {
        Criteria criteria = session.createCriteria(UsecaseField.class);
        List<UsecaseField> usecaseFields = criteria.add(Restrictions.eq("usecaseId", usecase.getId())).list();

        List<Integer> fieldIdsForUsecase = new ArrayList<>();

        for (UsecaseField field :
                usecaseFields) {
            fieldIdsForUsecase.add((int) field.getFieldId());
        }

        return fieldIdsForUsecase;
    }

    public Component getComponentFromNode(Node node){
        return getComponentFromUuid(node.getType());
    }

    private File getFileFromResources(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            return file;
        } else {
            throw new IllegalArgumentException("file is not found!");
        }
    }

    private String getDeviceTypeForNode(Node node){
        Component component = getComponentFromNode(node);
        return (String) component.getName();
    }


}
