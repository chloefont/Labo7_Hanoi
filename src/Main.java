import utils.stack.Iterator;
import utils.stack.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(3);
        stack.push(1);
        stack.push(5);
        stack.push(4);
        Integer[] tab = stack.toArray(Integer.class);
        Iterator i = stack.getIterator();

        for (int j = 0; j < 4; j++) {
            System.out.println(i.next());
        }
        System.out.println(stack.toString());
    }
}
