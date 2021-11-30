package util;

/**
 * Un élément est contenu par la Stack.
 * @param <T> Le type qu'un élément contient.
 */
public class Element<T>{
    private T value;
    private Element<T> next;

    public Element(T value) {
        this.value = value;
    }

    /**
     * Permet de récupérer l'élément suivant celui-ci.
     * @return
     */
    public Element<T> getNext() {
        return next;
    }

    /**
     * Permet de récupérer la valeur contenue.
     * @return
     */
    public T getValue() {
        return value;
    }

    /**
     * Permet d'indiquer l'élément qui celui-ci.
     * @param next
     */
    public void setNext(Element<T> next) {
        this.next = next;
    }
}
