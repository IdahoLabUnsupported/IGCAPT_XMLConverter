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


    public Node getCellRelay() throws NotFoundException {
        Short relayId = getEndpointForNode(startNode);

        return getNodeWithId(relayId);
    }

    private Node getParentNode(Node node) throws NotFoundException {
        Edge edge = getEdgeWithSourceId(node.getId());
        return getNodeWithId(edge.getTarget());
    }

    private Edge getEdgeWithSourceId(Short id) throws NotFoundException {
        for (Edge edge : edges) {
            if (edge.getSource() == id) {
                return edge;
            }
        }

        throw new NotFoundException(String.format("Couldn't find edge with source %d", id));
    }

    private Node getNodeWithId(Short id) throws NotFoundException {
        for (Node node : nodes) {
            if (node.getId() == id) {
                return node;
            }
        }

        throw new NotFoundException(String.format("Couldn't find node with source %d", id));
    }

    private Short getEndpointForNode(Node node) {
        EndPoints endPoints = node.getEndPoints();
        List<Short> endPoint = endPoints.getEndPoint();

        if(endPoint != null && endPoint.size() > 0) {
            return endPoint.get(0);
        }

        Node currentNode;
        Node parentNode = node;

        while(true) {
            currentNode = parentNode;
            try {
                parentNode = getParentNode(currentNode);
            } catch (NotFoundException e) {
                break;
            }
        }
        return currentNode.getId();

    }
}
