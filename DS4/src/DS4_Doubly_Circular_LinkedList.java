public class DS4_Doubly_Circular_LinkedList<E> implements DS4_Doubly_Circular_LinkedList_Interface<E> {
    DS4_Doubly_Circular_LinkedList_Node<E> first;
    DS4_Doubly_Circular_LinkedList_Node<E> last;

    public DS4_Doubly_Circular_LinkedList() {
        first = null;
        last = null;
    }

    public DS4_Doubly_Circular_LinkedList(E data) {
        first = new DS4_Doubly_Circular_LinkedList_Node<>(data);
        last = first;
        last.setNext(first);
        first.setPrev(last);
    }

    @Override
    public DS4_Doubly_Circular_LinkedList_Node<E> getFirstNode() {
        return first;
    }

    @Override
    public DS4_Doubly_Circular_LinkedList_Node<E> getLastNode() {
        return last;
    }

    @Override
    public E getFirst() {
        System.out.println(toString());
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
        last.setNext(first);
        first.setPrev(last);
        return removedData;
    }

    @Override
    public E removeLast() {
        E removedData = last.getData();
        if (size() == 1) {
            first = null;
            last = null;
        } else {
            last = last.getPrev();
            last.setNext(first);
            first.setPrev(last);
        }
        return removedData;
    }

    @Override
    public void addFirst(E data) {
        if (first!=null) {
            DS4_Doubly_Circular_LinkedList_Node<E> newFirst = new DS4_Doubly_Circular_LinkedList_Node<>(data);
            newFirst.setNext(first);
            first.setPrev(newFirst);
            first = newFirst;
            last.setNext(first);
            first.setPrev(last);
//            first = new DS4_Doubly_Circular_LinkedList_Node<>(data);
//            first.setNext(oldFirst);
//            first.setPrev(last);
//            last.setNext(first);
//            if (size()<3){
//                last = oldFirst;
//            }
        } else {
            first = new DS4_Doubly_Circular_LinkedList_Node<>(data);
            last = first;
            last.setNext(first);
            first.setPrev(last);
        }
        System.out.println(this+"\nLast:        "+last+"\nLast.next:   "+ last.getNext());
    }

    @Override
    public void addLast(E data) {
        if (last!=null) {
            DS4_Doubly_Circular_LinkedList_Node<E> newLast = new DS4_Doubly_Circular_LinkedList_Node<>(data);
            last.setNext(newLast);
            newLast.setPrev(last);
            last = newLast;
            last.setNext(first);
            first.setPrev(last);
        } else {
            first = new DS4_Doubly_Circular_LinkedList_Node<>(data);
            last = first;
            last.setNext(first);
            first.setPrev(last);
        }
    }

    @Override
    public void clear() {
        first = null;
        last = null;
    }

    @Override
    public int size() {
        if (first==null)return 0;
        int size = 1;
        DS4_Doubly_Circular_LinkedList_Node<E> cur = first;
        while (cur!=last) {
            cur = cur.getNext();
            size++;
        }
        return size;
    }

    @Override
    public E get(int x) {
        DS4_Doubly_Circular_LinkedList_Node<E> oldFirst = new DS4_Doubly_Circular_LinkedList_Node<>(first.getData());
        oldFirst.setNext(first.getNext());
        DS4_Doubly_Circular_LinkedList_Node<E> index = first;
        for (int i = 0; i < x; i++) {
            index = index.getNext();
        }
        first = oldFirst;
        return index.getData();
    }

    @Override
    public void add(int x, E data) {
        DS4_Doubly_Circular_LinkedList_Node<E> node = new DS4_Doubly_Circular_LinkedList_Node<>(data);
        if (x==0) {
            addFirst(node.getData());
        }
        else if (x==size()) {
            addLast(node.getData());
        }
        else {
            node.setNext(getNode(x));
            getNode(x-1).setNext(node);
            node.setPrev(getNode(x-1));
        }
    }

    @Override
    public E remove(int x) {
        E removedData = getNode(x).getData();
        if (x>0&&x<size()-1) {
            getNode(x-1).setNext(getNode(x+1));
            getNode(x).setPrev(getNode(x-1));
        } else if (size() == 1) {
            clear();
        } else if (x==0) {
            removeFirst();
        } else {
            removeLast();
        }
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

    @Override
    public String backwardsToString() {
        if (isEmpty()) return "[]";
        String str = "[";
        for (int i = size()-1; i >=0; i--) {
            str+=getNode(i).getData()+", ";
        }
        return str.substring(0, str.length()-2)+"]";
    }

    private DS4_Doubly_Circular_LinkedList_Node<E> getNode(int x) {
        DS4_Doubly_Circular_LinkedList_Node<E> index = first;
        if (x==0) return first;
        for (int i = 0; i < x-1; i++) {
            index = index.getNext();
        }
        return index.getNext();
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        String str = "[";
        for (int i = 0; i < size(); i++) {
            str+=getNode(i).getData()+", ";
        }
        return str.substring(0, str.length()-2)+"]";

    }
}
