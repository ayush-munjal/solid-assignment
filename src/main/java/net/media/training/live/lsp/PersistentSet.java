package net.media.training.live.lsp;

/**
 * Created by IntelliJ IDEA.
 * User: goyalamit
 * Date: Jul 11, 2011
 * Time: 12:56:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class PersistentSet<T> extends Set<T> {
    public void add(T element) {
        PersistentObject persistentObject = new PersistentObject(element);
        super.add((T) persistentObject);
    }

    public boolean isMember(T element) {
        for (Object o : innerSet) {
            if (o.equals(element))
                return true;
        }
        return false;
    }
}