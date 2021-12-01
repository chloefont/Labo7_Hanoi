package util;

/**
 * Cette Classe permet la navigation dans une pile (Stack<T>).
 * @param <T> Le type qu'un iterator contient
 */
public class Iterator<T> {
    Element<T> root;

    Iterator(Element<T> root) {
        Element<T> e = new Element<T>(null);
        e.setNext(root);
        this.root = e;
    }

    /**
     * Permet de vérifier si il y a un élément qui suit celui-ci.
     * @return vrai si un élément se trouve à la suite de celui-ci.
     */
    public boolean hasNext() {
        return root.getNext() != null;
    }

    /**
     * Permet de récupérer le contenu de l'élément qui suit celui-ci.
     * @return Un objet type T ou null si aucun élément n'est présent.
     */
    public T next() throws Exception {
        root = root.getNext();
        if (root != null)
            return root.getValue();
        else
            throw new Exception("Tried to access to a null pointer.");
    }
}
