public class DS4_LinkedList<E> implements DS4_LinkedList_Interface<E> {
    DS4_LinkedList_Node<E> first;
    DS4_LinkedList_Node<E> last;

    public DS4_LinkedList() {
        first = null;
        last = null;
    }

    public DS4_LinkedList(E data) {
        first = new DS4_LinkedList_Node<>(data);
        last = first;
    }

    @Override
    public DS4_LinkedList_Node getFirstNode() {
        return first;
    }

    @Override
    public DS4_LinkedList_Node getLastNode() {
        return last;
    }

    @Override
    public E getFirst() {
        return first.getData();
    }

    @Override
    public E getLast() {
        return last.getData();
    }

    @Override
    public E removeFirst() {
        E removedData = first.getData();
        first = first.getNext();
        return removedData;
    }

    @Override
    public E removeLast() {
        E removedData = last.getData();
        DS4_LinkedList_Node<E> oldFirst = new DS4_LinkedList_Node<>(first.getData());
        oldFirst.setNext(first.getNext());
        DS4_LinkedList_Node<E> last = first;
        for (int i = 0; i < size()-2; i++) {
            last = last.getNext();
        }
        first = oldFirst;
        return removedData;
    }

    @Override
    public void addFirst(E data) {
        DS4_LinkedList_Node<E> oldFirst = new DS4_LinkedList_Node<>(first.getData());
        oldFirst.setNext(first.getNext());
        first = new DS4_LinkedList_Node<>(data);
        first.setNext(oldFirst);
    }

    @Override
    public void addLast(E data) {
        DS4_LinkedList_Node<E> newLast = new DS4_LinkedList_Node<>(data);
        last.setNext(newLast);
        last = newLast;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
    }

    @Override
    public int size() {
        if (first==null)return 0;
        DS4_LinkedList_Node<E> oldFirst = new DS4_LinkedList_Node<>(first.getData());
        oldFirst.setNext(first.getNext());
        int size = 1;
        while (first.getNext()!=null) {
            first = first.getNext();
            size++;
        }
        first = oldFirst;
        return size;
    }

    @Override
    public E get(int x) {
        DS4_LinkedList_Node<E> oldFirst = new DS4_LinkedList_Node<>(first.getData());
        oldFirst.setNext(first.getNext());
        DS4_LinkedList_Node<E> index = first;
        for (int i = 0; i < x; i++) {
            index = index.getNext();
        }
        first = oldFirst;
        return index.getData();
    }

    @Override
    public void add(int x, E data) {
        DS4_LinkedList_Node<E> node = new DS4_LinkedList_Node<>(data);
        node.setNext(getNode(x));
        getNode(x-1).setNext(node);
    }

    @Override
    public E remove(int x) {
        E removedData = getNode(x).getData();
        getNode(x-1).setNext(getNode(x+1));
        return removedData;
    }

    @Override
    public E set(int x, E data) {
        E removedData = getNode(x).getData();
        getNode(x).setData(data);
        return removedData;
    }

    @Override
    public boolean isEmpty() {
        return first==null;
    }

    private DS4_LinkedList_Node<E> getNode(int x) {
        DS4_LinkedList_Node<E> oldFirst = new DS4_LinkedList_Node<>(first.getData());
        oldFirst.setNext(first.getNext());
        DS4_LinkedList_Node<E> index = first;
        for (int i = 0; i < x; i++) {
            index = index.getNext();
        }
        first = oldFirst;
        return index;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        String str = "[";
        for (int i = 0; i < size()-1; i++) {
            str+=getNode(i)+", ";
        }
        return str.substring(0, str.length()-1)+"]";

    }
}
