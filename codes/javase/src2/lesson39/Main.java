package lesson39;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        // TAPŞIRIQ 1
        Queue<String> queue = new LinkedList<>();
        queue.add("Element1");
        queue.add("Element2");
        queue.add("Element3");

        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue.poll());

        // TAPŞIRIQ 2
        Stack<String> stack = new Stack<>();
        stack.push("E1");
        stack.push("E2");
        stack.push("E3");

        System.out.println(stack.peek());
    }
}



