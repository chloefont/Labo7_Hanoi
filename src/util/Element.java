package util;

/**
 * Un élément est contenu par la Stack.
 * @param <T> Le type qu'un élément contient.
 */
class Element<T>{
    private T value;
    private Element<T> next;

    /**
     * Constructeur de la classe Element.
     * @param value valeur de 'élément.
     */
    Element(T value) {
        this.value = value;
    }

    /**
     * Permet de récupérer l'élément suivant celui-ci.
     * @return l'élément suivant.
     */
    Element<T> getNext() {
        return next;
    }

    T getValue() {
        return value;
    }

    /**
     * Permet de renseigner l'élément qui suit celui-ci.
     * @param next l'élément à mettre à la suite.
     */
    void setNext(Element<T> next) {
        this.next = next;
    }
}
