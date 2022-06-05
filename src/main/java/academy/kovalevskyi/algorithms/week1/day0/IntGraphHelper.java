package academy.kovalevskyi.algorithms.week1.day0;

public class IntGraphHelper {
    public static GraphBinaryNode<Integer> createNode(Integer value) {
        return new GraphBinaryNode<>(null, null, value);
    }

    public static GraphBinaryNode<Integer> addNode(GraphBinaryNode<Integer> root, Integer value) {
        if (root == null) {
            return createNode(value);
        }

        GraphBinaryNode<Integer> left = root.left();
        GraphBinaryNode<Integer> right = root.right();

        if (root.value() > value) {
            left = addNode(left, value);
        } else {
            right = addNode(right, value);
        }

        return new GraphBinaryNode<>(left, right, root.value());
    }

    public static boolean contains(GraphBinaryNode<Integer> root, Integer value) {
        if (root == null) {
            return false;
        }

        if (root.value() == value) {
            return true;
        }

        return contains(root.left(), value) || contains(root.right(), value);
    }
}
