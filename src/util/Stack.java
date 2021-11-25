package util;

import java.lang.reflect.Array;

public class Stack<T> {
    private int size = 0;
    private Element<T> root = null;

    public void push(T obj) {
        Element<T> tmp = root;
        root = new Element<T>(obj);
        root.setNext(tmp);
        size++;
    }

    public T pop() {
        T val = null;
        if(root != null){
            val = root.getValue();
            root = root.getNext();
            size--;
        }

        return val;
    }

    @Override
    public String toString() {
        String result = "";
        if (root != null) {
            result += "[ <" + root.getValue() + "> ";
            Element<T> element = root;
            while (element.getNext() != null) {
                element = element.getNext();
                result += "<" + element.getValue() + "> ";
            }
            result += "]";
        }else{
            result = "[ ]";
        }

        return result;
    }

    public Object[] toArray() {
        Object[] array = new Object[size];
        if (root != null) {
            Element<T> element = root;
            for (int i = 0; i < size; i++) {
                array[i] = element.getValue();
                element = element.getNext();
            }
        }
        return array;
    }

    public int getSize() {
        return size;
    }

    public Iterator<T> getIterator() {
        return new Iterator<T>(root);
    }
}
