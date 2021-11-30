package util;

public class Iterator<T> {
    Element<T> root = null;

    public Iterator(Element<T> root) {
        Element<T> e = new Element<T>(null);
        e.setNext(root);
        this.root = e;
    }

    public boolean hasNext() {
        return root.getNext() != null;
    }

    public T next() {
        root = root.getNext();
        if (root != null)
            return root.getValue();
        else
            return null;
    }
}
