package util;

public class Iterator<T> {
    Element<T> root = null;

    Iterator(Element<T> root) {
        Element<T> e = new Element<T>(null);
        e.setNext(root);
        this.root = e;
    }

    public boolean hasNext() {
        return root.getNext() != null;
    }

    public T next() {
        T nextVal = root.getNext().getValue();
        root = root.getNext();
        return nextVal;
    }
}
