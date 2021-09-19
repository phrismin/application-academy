package academy.kovalevskyi.algorithms.week1.day2;

import java.util.*;

public class Graph {
  private final Map<Integer, Set<Node>> setMap;

  private Graph(Map<Integer, Set<Node>> setMap) {
    this.setMap = setMap;
  }

  private static void dfs(Node node, Set<Node> set, Queue<Node> nodeQueue) {
    Set<Node> neighbours = node.getNeighbours();
    if (set.containsAll(neighbours)) {
      return;
    }
    for (Node neighbour : neighbours) {
      if (!set.contains(neighbour)) {
        nodeQueue.remove(neighbour);
        set.add(neighbour);
        dfs(neighbour, set, nodeQueue);
      }
    }
  }

  public static Graph generateGraph(Set<Node> nodes) {
    Map<Integer, Set<Node>> setMap = new HashMap<>();
    Set<Node> set = new HashSet<>();
    Queue<Node> nodeQueue = new LinkedList<>(nodes);
    int groupNumber = 0;
    while (nodeQueue.peek() != null) {
      Node temp = nodeQueue.remove();
      set.add(temp);
      dfs(temp, set, nodeQueue);
      setMap.put(groupNumber++, new HashSet<>(set));
      set = new HashSet<>();
    }
    return new Graph(setMap);
  }

  public int countComponents() {
    return setMap.size();
  }

  public int getComponentId(Node node) {
    for (Map.Entry<Integer, Set<Node>> item : setMap.entrySet()) {
      for (Node entry : item.getValue()) {
        if (entry == node) {
          return item.getKey();
        }
      }
    }
    return -1;
  }
}