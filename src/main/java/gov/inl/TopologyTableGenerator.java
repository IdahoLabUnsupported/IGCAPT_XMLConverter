package gov.inl;

import gov.inl.generated.Edge;
import gov.inl.generated.Node;
import gov.inl.generated.SGComponents.Component;
import javassist.NotFoundException;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class TopologyTableGenerator implements TableGenerator {

    private final List<Component> components; // Not unique.
    private final List<Node> nodes;
    private final List<Edge> edges;
    private DataAccessObject dao;
    private Hashtable<Node, Integer> localCounts;
    private final List<Component> uniqueComponents;

    public TopologyTableGenerator(DataAccessObject dao) {
        this.dao = dao;

        nodes = dao.getAllNodesFromFile();
        edges = dao.getAllEdgesFromFile();
        components = dao.getComponentsFromNodes(nodes);
        localCounts = new Hashtable<>();
        uniqueComponents = new ArrayList<>();
    }

    @Override
    public List<String> generate() {
        
        List<String> lines = new ArrayList<>();
        
        // Write out component types list
        int i=0;
        for (Component comp : components)
        {
            if (!uniqueComponents.contains(comp))
            {
                uniqueComponents.add(comp);
                
                String line = comp.getName() + "," + Integer.toString(i);
                lines.add(line);
                i++;
            }
        }
        
        lines.add("");
        
        // Write out node connectivity
        for (Node node : nodes) {
            String line = getLineForNode(node);
            lines.add(line);
        }
        return lines;
    }

    public String getLineForNode(Node node) {
        Component component = dao.getComponentFromNode(node);
        Node cellRelay = getCellRelayForNode(node);

        int deviceType = (uniqueComponents.contains(component)) ? uniqueComponents.indexOf(component) : -1;

        int cellRelayId = (cellRelay != null)?cellRelay.getId():-1;

        int rawSourceId;
        int rawDestinationId;
        int localSourceId;
        int localDestinationId = 0;
        
        localSourceId = nodes.indexOf(node);
        rawSourceId = node.getId();
        Node parentNode = getParentForNode(node);
        localDestinationId = (parentNode !=null)?nodes.indexOf(parentNode):localSourceId;
        rawDestinationId = (parentNode != null)?parentNode.getId():rawSourceId;

         return String.format("%d,%d,%d,%d,%d,%d", deviceType, cellRelayId, rawSourceId, rawDestinationId, localSourceId, localDestinationId);
    }

    private Node getCellRelayForNode(Node node) {
        NodeTracer tracer = new NodeTracer(node, nodes, edges, dao);
        return tracer.getCellRelay();
    }

    private Node getParentForNode(Node node) {
        NodeTracer tracer = new NodeTracer(node, nodes, edges, dao);
        return  tracer.getParentNode(node);
    }

    private Edge getEdgeWithSourceId(Short id) {
        
        Edge returnval = null;
        
        for (Edge edge : edges) {
            if (edge.getSource() == id) {
                returnval = edge;
                break;
            }
        }

        return returnval;
    }

}
