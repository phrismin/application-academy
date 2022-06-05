package academy.kovalevskyi.algorithms.week1.day3;

import java.util.*;

public class NetworkPathFinder {
    public static int shortestPath(Node start, Node end) {
        Set<Node> passedNodes = new HashSet<>();
        Set<Node> unPassedNodes = new HashSet<>();
        start.distance = 0;
        unPassedNodes.add(start);

        while (!unPassedNodes.isEmpty()) {
            Node currentNode = getLowestDistanceNode(unPassedNodes);
            unPassedNodes.remove(currentNode);

            for (Map.Entry<Node, Integer> neighbor : currentNode.connections.entrySet()) {
                Node nodeNeighbor = neighbor.getKey();
                int distanceNeighbor = neighbor.getValue();

                if (!passedNodes.contains(nodeNeighbor)) {
                    calculateMinimumDistance(nodeNeighbor, distanceNeighbor, currentNode);
                    unPassedNodes.add(nodeNeighbor);
                }

                passedNodes.add(currentNode);
            }
        }
        int sum = 0;
        for (Node node : end.shortestPath) {
            sum += node.distance;
        }
        return sum;
    }

    private static void calculateMinimumDistance(Node nodeNeighbor, int distanceNeighbor, Node sourceNode) {
        int sourceDistance = sourceNode.distance;
        if (sourceDistance + distanceNeighbor < nodeNeighbor.distance) {
            nodeNeighbor.distance = sourceDistance + distanceNeighbor;
            List<Node> shortestPath = new LinkedList<>(sourceNode.shortestPath);
            shortestPath.add(sourceNode);
            nodeNeighbor.shortestPath = new LinkedList<>(shortestPath);
        }
    }

    private static Node getLowestDistanceNode(Set<Node> unPassedNodes) {
        Node lowestDistanceNode = null;
        int maxDistance = Integer.MAX_VALUE;
        for (Node node : unPassedNodes) {
            int nodeDistance = node.distance;
            if (nodeDistance < maxDistance) {
                maxDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }
}
