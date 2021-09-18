package academy.kovalevskyi.algorithms.week1.day2;

import java.util.*;

public class Graph {
  private final HashMap<Integer, Set<Node>> setHashMap;

  private Graph(HashMap<Integer, Set<Node>> setHashMap) {
    this.setHashMap = setHashMap;
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
    HashMap<Integer, Set<Node>> map = new HashMap<>();
    Set<Node> set = new HashSet<>();
    Queue<Node> nodeQueue = new LinkedList<>(nodes);
    int groupNumber = 0;
    while (nodeQueue.peek() != null) {
      Node temp = nodeQueue.remove();
      set.add(temp);
      dfs(temp, set, nodeQueue);
      map.put(groupNumber++, new HashSet<>(set));
      set = new HashSet<>();
    }
    return new Graph(map);
  }

  public int countComponents() {
    return setHashMap.size();
  }

  public int getComponentId(Node node) {
    for (Map.Entry<Integer, Set<Node>> item : setHashMap.entrySet()) {
      for (Node entry : item.getValue()) {
        if (entry == node) {
          return item.getKey();
        }
      }
    }
    return -1;
  }
}