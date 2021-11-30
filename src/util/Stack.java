package util;

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
    public T pop() {
        T val = null;
        if(root != null){
            val = root.getValue();
            root = root.getNext();
            size--;
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

        if (root != null) {
            result += "[ ";
            Iterator<T> element = getIterator();
            T value;
            while ((value = element.next()) != null) {
                result += "<" + value + "> ";
            }
            result += "]";
        } else {
            result = "[ ]";
        }

        return result;
    }

    /**
     * Permet de convertir la stack en tableau. Attention les éléments contenu dans le tableau sont des "Object".
     * @return un tableau de "Object".
     */
    public Object[] toArray() {
        Object[] array = new Object[size];
        if (root != null) {
            Iterator<T> element = getIterator();
            for (int i = 0; i < size; i++) {
                array[i] = element.next();
            }
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
