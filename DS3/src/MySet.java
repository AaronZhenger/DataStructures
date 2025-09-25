import java.util.ArrayList;
import java.util.Iterator;

public class MySet<E> implements SetInterface<E> {
    ArrayList<E> set = new ArrayList<>();

    @Override
    public boolean add(E o) {
        for (E i : set) {
            if (i.equals(o)) {
                return false;
            }
        }
        return set.add(o);
    }

    @Override
    public void clear() {
        set.clear();
    }

    @Override
    public boolean contains(E o) {
        return set.contains(o);
    }

    @Override
    public boolean isEmpty() {
        return set.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        return set.iterator();
    }

    @Override
    public boolean remove(E o) {
        for (E i : set) {
            if (i.equals(o)) {
                set.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return set.size();
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        String string = "";
        for (E x : set)
            string+=x.toString()+", ";
        return "["+ string.substring(0, string.length()-2)+"]";
    }
}
