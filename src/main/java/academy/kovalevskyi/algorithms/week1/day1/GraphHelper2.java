package academy.kovalevskyi.algorithms.week1.day1;

import academy.kovalevskyi.algorithms.week1.day0.GraphBinaryNode;

import java.util.LinkedList;
import java.util.Queue;

public class GraphHelper2 {
    public static boolean includesDepthFirstSearch(GraphBinaryNode<?> root, Object value) {
        if (root == null) {
            return false;
        }

        return root.value().equals(value) ||
                includesDepthFirstSearch(root.left(), value) ||
                includesDepthFirstSearch(root.right(), value);
    }

    public static boolean includesBreathFirstSearch(GraphBinaryNode<?> root, Object value) {
        if (root == null) {
            return false;
        }

        GraphBinaryNode<?> temp;
        Queue<Object> objects = new LinkedList<>();
        objects.offer(root);

        while (objects.peek() != null) {
            temp = (GraphBinaryNode<?>) objects.poll();
            if (temp.value().equals(value)) {
                return true;
            }
            objects.offer(temp.left());
            objects.offer(temp.right());
        }

        return false;
    }
}