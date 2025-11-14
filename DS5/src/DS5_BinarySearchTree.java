public class DS5_BinarySearchTree<E extends Comparable<E>> implements DS5_BinarySearchTree_Interface<E> {
    private DS5_BinarySearchTree_Node<E> root;

    public DS5_BinarySearchTree() {
        root = null;
    }

    public DS5_BinarySearchTree(E data) {
        root = new DS5_BinarySearchTree_Node<>(data);
    }

    @Override
    public DS5_BinarySearchTree_Node<E> getRoot() {
        return root;
    }

    @Override
    public String preOrder() {
        return "";
    }

    @Override
    public String inOrder() {
        return "";
    }

    @Override
    public String postOrder() {
        return "";
    }

    @Override
    public E minValue() {
        return null;
    }

    @Override
    public E maxValue() {
        return null;
    }

    @Override
    public int nodeDepth(E value) {
        return 0;
    }

    @Override
    public int height() {
        return 0;
    }

    @Override
    public int maxDepth() {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(E data) {
        return false;
    }

    @Override
    public boolean insert(E data) {
        if (root==null) {
            root = new DS5_BinarySearchTree_Node<>(data);
            return true;
        }
        DS5_BinarySearchTree_Node<E> cur = getRoot();
        while (cur.getLeft()!=null && cur.getRight()!=null) {
            if (data.compareTo(cur.getData())<0)
                cur = cur.getLeft();
            else cur = cur.getRight();
        }
    }

    @Override
    public boolean remove(E data) {
        return false;
    }
}
