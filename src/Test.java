import hanoi.Hanoi;
import util.*;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Cette classe contient les différents test implémenter pour la Classe Hanoi, Stack et Iterator.
 */
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
        boolean errorCatched = false;

        try {
            Integer val = stack.pop();
        } catch (EmptyStackException e) {
            errorCatched = true;
        } finally {
            System.out.println("St - Pop void stack should be null : " + passed(errorCatched));
            System.out.println("St - If pop void stack, size should remain 0 : " + passed(stack.getSize() == 0));
        }
    }

    static public void popReturnLastValue() {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(2);
        Integer val = stack.pop();

        System.out.println("St - Pop return last value : " + passed(val == 2));
    }

    static public void checkSize() {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(4);

        stack.pop();
        System.out.println("St - Get size returns correct value : " + passed(stack.getSize() == 1));
    }

    static public void toArrayOfVoidStack() {
        Stack<Integer> stack = new Stack<>();
        Object[] array = stack.toArray();

        System.out.println("St - Array with void stack should be void : " + passed(array.length == stack.getSize()));
    }

    static public void toArrayOfFullStack() {
        Stack<Integer> stack = new Stack<>();

        Integer[] firstArray = {2, 4, 5};

        for (int i = firstArray.length - 1; i >= 0; i--)
            stack.push(firstArray[i]);

        Object[] array = stack.toArray();

        System.out.println("St - Array with full stack : " + passed(Arrays.equals(firstArray, array)));
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
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Ha - Hanoi solved right: " + passed(errorCatched));
        }
    }

    static public void hanoiWithNegativeNumberDisks() {
        boolean errorCatched = false;
        try {
            Hanoi hanoi = new Hanoi(-2);
        } catch (IllegalArgumentException e) {
            errorCatched = true;
        } finally {
            System.out.println("Ha - Hanoi with negative number of disks raises exception : " + passed(errorCatched));
        }
    }

    static public void statusHanoi() {
        int[][] expectedResult = {{1, 2, 3}, {}, {}};
        boolean testPassed = true;

        try {
            Hanoi hanoi = new Hanoi(3);
            int[][] towers = hanoi.status();

            for (int i = 0; i < expectedResult.length; i++)
                testPassed = Arrays.equals(towers[i], expectedResult[i]);

        } catch (IllegalArgumentException e) {
            testPassed = false;
        } finally {
            System.out.println("Ha - Status should return corrects values : " + passed(testPassed));
        }
    }

    // Iterator stack

    static public void testIteratorsStack(){
        boolean testOK = false;
        Stack<String> stack = new Stack<>();

        stack.push("el 2");
        stack.push("el 1");
        Iterator<String> it = stack.getIterator();

        System.out.println("It - Should have next : " + passed(it.hasNext()));

        try {
            testOK = it.next().equals("el 1");
        } catch (Exception e) {
        } finally {
            System.out.println("It - Should equals 'el 1' : " + passed(testOK));
            testOK = false;
        }

        System.out.println("It - Should have next : " + passed(it.hasNext()));

        try {
            testOK = it.next().equals("el 2");
        } catch (Exception e) {
        } finally {
            System.out.println("It - Should equals 'el 2' : " + passed(testOK));
            testOK = false;
        }

        try {
            it.next();
        } catch (Exception e) {
            testOK = true;
        } finally {
            System.out.println("It - Next should raise an exception : " + passed(testOK));
        }


    }

    public static void main(String[] args) {
        popVoidStack();
        popReturnLastValue();
        checkSize();
        toArrayOfVoidStack();
        toArrayOfFullStack();
        System.out.println();

        hanoiSolvesRight();
        hanoiWithNegativeNumberDisks();
        statusHanoi();
        System.out.println();

        testIteratorsStack();
    }
}
