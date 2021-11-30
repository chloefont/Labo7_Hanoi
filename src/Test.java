import hanoi.Hanoi;
import util.*;

import java.util.Arrays;

public class Test {
    static private String passed(boolean isPassed) {
        if (isPassed)
                return "ok";
        else
            return "not passed";
    }

    // Stack
    static public void popVoidStack() {
        Stack<Integer> stack = new Stack<>();
        Integer val = stack.pop();

        System.out.println("Pop void stack should be null : " + passed(val == null));
        System.out.println("If pop void stack, size should remain 0 : " + passed(stack.getSize() == 0));
    }

    static public void popReturnLastValue() {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(2);
        Integer val = stack.pop();

        System.out.println("Pop return last value : " + passed(val == 2));
    }

    static public void checkSize() {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(4);

        stack.pop();
        System.out.println("Get size returns correct value : " + passed(stack.getSize() == 1));
    }

    static public void toArrayOfVoidStack() {
        Stack<Integer> stack = new Stack<>();
        Object[] array = stack.toArray();

        System.out.println("Array with void stack should be void : " + passed(array.length == stack.getSize()));
    }

    static public void toArrayOfFullStack() {
        Stack<Integer> stack = new Stack<>();

        Integer[] firstArray = {2, 4, 5};

        for (int i = firstArray.length - 1; i >= 0; i--)
            stack.push(firstArray[i]);

        Object[] array = stack.toArray();

        System.out.println("Array with full stack : " + passed(Arrays.equals(firstArray, array)));
    }


    // Hanoi
    static public void hanoiSolvesRight() {
        boolean errorCatched = false;
        try {
            Hanoi hanoi = new Hanoi(3, null);
            hanoi.solve();
            errorCatched = (hanoi.toString().equals("One:   [ ]\n" +
                                                    "Two:   [ ]\n" +
                                                    "Three: [ <1> <2> <3> ]"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Hanoi solved right: " + passed(errorCatched));
        }
    }

    static public void hanoiWithNegativeNumberDisks() {
        boolean errorCatched = false;
        try {
            Hanoi hanoi = new Hanoi(-2);
        } catch (Exception e) {
            errorCatched = (e.getMessage().equals("numberDisk should be greater than 0"));
        } finally {
            System.out.println("Hanoi with negative number of disks raises exception : " + passed(errorCatched));
        }
    }

    // Iterator

    public static void main(String[] args) {
        popVoidStack();
        popReturnLastValue();
        checkSize();
        toArrayOfVoidStack();
        toArrayOfFullStack();

        hanoiSolvesRight();
        hanoiWithNegativeNumberDisks();
    }
}
