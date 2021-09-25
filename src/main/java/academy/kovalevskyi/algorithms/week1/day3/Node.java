package academy.kovalevskyi.algorithms.week1.day3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Node {
  public List<Node> shortestPath = new LinkedList<>();
  public Map<Node, Integer> connections = new HashMap<>();
  public Integer distance = Integer.MAX_VALUE;
}
