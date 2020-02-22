package gov.inl;

import gov.inl.generated.Edge;
import gov.inl.generated.Node;
import gov.inl.generated.SGComponents.Component;
import javassist.NotFoundException;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class TopologyTableGenerator implements TableGenerator {

    private final List<Component> components;
    private final List<Node> nodes;
    private final List<Edge> edges;
    private DataAccessObject dao;
    private Hashtable<Node, Integer> localCounts;

    public TopologyTableGenerator(DataAccessObject dao) {
        this.dao = dao;

        nodes = dao.getAllNodesFromFile();
        edges = dao.getAllEdgesFromFile();
        components = dao.getComponentsFromNodes(nodes);
        localCounts = new Hashtable<>();
    }

    @Override
    public List<String> generate() {
        List<String> lines = new ArrayList<>();
        for (Node node : nodes) {
            try {
                String line = getLineForNode(node);
                lines.add(line);
            } catch (NotFoundException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }

        return lines;
    }

    public String getLineForNode(Node node) throws NotFoundException {
        Component component = dao.getComponentFromNode(node);
        Node cellRelay = getCellRelayForNode(node);


        String deviceType = component == null ? "Unknown Device Type" : component.getName();;

        Short cellRelayId = cellRelay.getId();
        Short rawSourceId = node.getId();

        Short rawDestinationId;

        try {
            Edge edge = getEdgeWithSourceId(node.getId());
            rawDestinationId = edge.getTarget();
        } catch (NotFoundException e) {
            rawDestinationId = node.getId();

        }
        int localSourceId;
        Short localDestinationId = 0;

         if (node == cellRelay){
             localSourceId = 0;
         } else {
             Integer count = localCounts.getOrDefault(cellRelay, 0);
             localSourceId = count + 1;
             localCounts.put(cellRelay, count + 1);
         }

         return String.format("%s,%d,%d,%d,%d,%d", deviceType, cellRelayId, rawSourceId, rawDestinationId, localSourceId, localDestinationId);
    }

    private Node getCellRelayForNode(Node node) throws NotFoundException {
        NodeTracer tracer = new NodeTracer(node, nodes, edges, dao);
        return tracer.getCellRelay();
    }

    private Edge getEdgeWithSourceId(Short id) throws NotFoundException {
        for (Edge edge : edges) {
            if (edge.getSource() == id) {
                return edge;
            }
        }

        throw new NotFoundException(String.format("Couldn't find edge with source %d", id));
    }

}
