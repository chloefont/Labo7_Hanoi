package util;

import java.util.EmptyStackException;

/**
 * Une pile LIFO (Last In First Out).
 * @param <T> est le type des éléments qu'il contient.
 */
public class Stack<T> {
    private int size = 0;
    private Element<T> root = null;

    /**
     * Permet d'ajouter un élément dans la pile.
     * @param obj l'élément à ajouter.
     */
    public void push(T obj) {
        Element<T> tmp = root;
        root = new Element<T>(obj);
        root.setNext(tmp);
        size++;
    }

    /**
     * Permet de retirer le dernier élément ajouté.
     * @return l'élément ajouté en dernier ou null si la pile est vide.
     */
    public T pop() throws EmptyStackException {
        T val;
        if(root != null){
            val = root.getValue();
            root = root.getNext();
            size--;
        } else {
            throw new EmptyStackException();
        }

        return val;
    }

    /**
     * Permet d'avoir une représentation de la stack et de ses éléments en String.
     * @return
     */
    @Override
    public String toString() {
        String result = "";

        try {
            if (root != null) {
                result += "[ ";
                Iterator<T> it = getIterator();
                T value;
                while (it.hasNext()) {
                    value = it.next();
                    result += "<" + value + "> ";
                }
                result += "]";
            } else {
                result = "[ ]";
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    /**
     * Permet de convertir la stack en tableau. Attention les éléments contenu dans le tableau sont des "Object".
     * @return un tableau de "Object".
     */
    public Object[] toArray() {
        Object[] array = new Object[size];

        try {

            if (root != null) {
                Iterator<T> element = getIterator();
                for (int i = 0; i < size; i++) {
                    array[i] = element.next();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return array;
    }

    public int getSize() {
        return size;
    }

    /**
     * Permet d'avoir un itérateur sur la pile.
     * @return Un itérateur sur le premier élément de la pile.
     */
    public Iterator<T> getIterator() {
        return new Iterator<T>(root);
    }
}
