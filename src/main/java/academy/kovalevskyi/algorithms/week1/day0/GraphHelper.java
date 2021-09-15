package academy.kovalevskyi.algorithms.week1.day0;

public class GraphHelper {
  public static boolean equals(GraphBinaryNode<?> left, GraphBinaryNode<?> right) {
    return left == right || left.value() == right.value();
  }

  public static <T> GraphBinaryNode<T> invertGraph(GraphBinaryNode<T> root) {
    if (root == null) {
      return null;
    }

    GraphBinaryNode<T> left = invertGraph(root.left());
    GraphBinaryNode<T> right = invertGraph(root.right());

    return new GraphBinaryNode(right, left, root.value());
  }
}
