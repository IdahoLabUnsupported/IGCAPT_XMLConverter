package gov.inl;

import gov.inl.generated.Edge;
import gov.inl.generated.EndPoints;
import gov.inl.generated.Node;
import gov.inl.generated.SGComponents.Component;
import javassist.NotFoundException;

import java.util.List;
import java.util.Objects;

public class NodeTracer {
    private final Component component;
    private Node startNode;
    private List<Node> nodes;
    private List<Edge> edges;
    private DataAccessObject dao;

    public NodeTracer(Node startNode, List<Node> nodes, List<Edge> edges, DataAccessObject dao) {
        this.startNode = startNode;

        this.nodes = nodes;
        this.edges = edges;
        this.dao = dao;

        this.component = dao.getComponentFromNode(startNode);
    }


    public Node getCellRelay() {
        int relayId = getRelayForNode(startNode);
        Node returnval = null;
        
        if (relayId > -1) {
            returnval = getNodeWithId(relayId);
        }

        return returnval;
    }

    public Node getParentNode(Node node) {
        
        Node returnval = null;
        Edge edge = getEdgeWithSourceId(node.getId());
        
        if (edge!=null){
            returnval = getNodeWithId(edge.getTarget());
        }
        
        return returnval;
    }

    private Edge getEdgeWithSourceId(int id) {
        
        Edge returnval = null;
        
        for (Edge edge : edges) {
            if (edge.getSource() == id) {
                returnval = edge;
                break;
            }
        }

        return returnval;
    }

    private Node getNodeWithId(int id) {
        
        Node returnval = null;
        
        for (Node node : nodes) {
            if (node.getId() == id) {
                returnval = node;
                break;
            }
        }

        return returnval;
    }
    
    private int getRelayForNode(Node node) {
 
        Node currentNode;
        Node parentNode = node;
        Component comp;
        int relayId = -1;

        while(true) {
            currentNode = parentNode;
            comp = dao.getComponentFromNode(currentNode);
            if (comp.getName().equals("Cell Relay")) {
                 relayId = currentNode.getId();
                 break;
             }

             parentNode = getParentNode(currentNode);

             if (parentNode == null)
             {
                 break;
             }
        }
        return relayId;

    }
}
