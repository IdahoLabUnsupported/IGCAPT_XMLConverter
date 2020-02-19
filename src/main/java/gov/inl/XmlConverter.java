package gov.inl;

import gov.inl.generated.Gen;
import gov.inl.generated.Node;
import gov.inl.generated.SGComponents.Component;
import gov.inl.generated.SGComponents.Field;
import gov.inl.generated.SGComponents.Usecase;
import gov.inl.generated.SGComponents.UsecaseField;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class XmlConverter {
    Session session;
    String inputFilename;

    public XmlConverter() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("IGCAPT");
        EntityManager entityManager = emf.createEntityManager();
        session = entityManager.unwrap(Session.class);
        inputFilename = "50meter(xsd).xml";
    }

    public List<String> getCommunicationTable() {
        List<String> lines = new ArrayList<>();

        List<Usecase> usecases = session.createCriteria(Usecase.class).list();
        List<Node> nodes = getAllNodesFromFile();
        List<Component> components = getComponentsFromNodes(nodes);
        Dictionary<Usecase, List<Component>> componentsByUsecase = new Hashtable<>();


        for (Usecase usecase : usecases) {
            Hashtable<Component, Integer> componentCountById = new Hashtable<>();



            List<Component> validComponents = getComponentsForUsecase(usecase);
            for (Component component : components) {
                if(validComponents.contains(component)) {
                    componentCountById.put(component, componentCountById.getOrDefault(component.getUuid(), 0) + 1);
                }
            }

            for (Component component : componentCountById.keySet()) {
                lines.add(String.format("%s,%s,%s", usecase.getName(), getPayloadForComponent(component, usecase), componentCountById.get(component)));
            }
        }

        return lines;
    }

    private List<Node> getAllNodesFromFile(){
        XmlConverter converter = new XmlConverter();
        File file = converter.getFileFromResources(inputFilename);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Gen.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Gen gen = (Gen) jaxbUnmarshaller.unmarshal(file);

            return gen.getNodeList().getNodes();
        } catch (Exception e) {

        }
        return new ArrayList<>();
    }

    private List<Component> getComponentsFromNodes(List<Node> nodes) {
        List<Component> components = new ArrayList<>();

        for (Node node : nodes) {
            components.add(getComponentFromNode(node));
        }

        return components;
    }

    private Component getComponentFromId(String id) {
        Criteria criteria = session.createCriteria(Component.class);
        return (Component) criteria.add(Restrictions.eq("uuid", id)).uniqueResult();
    }

    private List<Component> getComponentsForUsecase(Usecase usecase) {
        Criteria criteria = session.createCriteria(Component.class);
        return criteria.add(Restrictions.eq("usecaseId", usecase.getId())).list();
    }

    private int getPayloadForComponent(Component component, Usecase usecase) {
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











    private Component getComponentFromNode(Node node){
        return getComponentFromId(node.getType());
    }

    private File getFileFromResources(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile());
        }
    }



    private String getDeviceTypeForNode(Node node){
        Component component = getComponentFromNode(node);
        return (String) component.getName();
    }

    public static void main(String[] args) {
        XmlConverter converter = new XmlConverter();

        converter.getCommunicationTable();



//        File file = converter.getFileFromResources("50meter(xsd).xml");
//
//        try {
//            JAXBContext jaxbContext = JAXBContext.newInstance(Gen.class);
//
//            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//            Gen gen = (Gen) jaxbUnmarshaller.unmarshal(file);
//
//            for (Node node : gen.getNodeList().getNodes()) {
//                String deviceType = converter.getDeviceTypeForNode(node);
//                int cellRelayId;
//                int sourceId = node.getId();
//
//
//
//
//
//
//
//            }
//
//            System.out.println("num nodes: " + gen.getNodeList().getNodes().size());
//            System.out.println("num edges: " + gen.getEdgeList().getEdges().size());
//
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
    }
}
