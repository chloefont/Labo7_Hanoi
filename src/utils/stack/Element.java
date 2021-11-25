package utils.stack;

public class Element<T>{
    private T value;
    private Element<T> next;

    public Element(T value) {
        this.value = value;
    }

    public Element<T> getNext() {
        return next;
    }

    public T getValue() {
        return value;
    }

    public void setNext(Element<T> next) {
        this.next = next;
    }
}
