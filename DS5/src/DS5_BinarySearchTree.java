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
        if (isEmpty()) return "[]";
        String raw = printTree(root, 0);
        String[] list = raw.split(" +");
        String processed = "[";
        for (int i = 0; i < list.length; i++) {
            if (!list[i].isEmpty())
                processed += list[i] + ", ";
        }
        return processed.substring(0, processed.length()-2)+"]";
        //[1, 2,
    }

    @Override
    public String inOrder() {
        if (isEmpty()) return "[]";
        String raw = printTree(root, 1);
        String[] list = raw.split(" +");
        String processed = "[";
        for (int i = 0; i < list.length; i++) {
            if (!list[i].isEmpty())
                processed += list[i] + ", ";
        }
        return processed.substring(0, processed.length()-2)+"]";
        //[1, 2,
    }

    @Override
    public String postOrder() {
        if (isEmpty()) return "[]";
        String raw = printTree(root, 2);
        String[] list = raw.split(" +");
        String processed = "[";
        for (int i = 0; i < list.length; i++) {
            if (!list[i].isEmpty())
                processed += list[i] + ", ";

        }
        return processed.substring(0, processed.length()-2)+"]";
        //[1, 2,
    }

    @Override
    public E minValue() {
        DS5_BinarySearchTree_Node<E> cur = root;
        while (cur.getLeft()!=null)
            cur = cur.getLeft();
        return cur.getData();
    }

    @Override
    public E maxValue() {
        DS5_BinarySearchTree_Node<E> cur = root;
        while (cur.getRight()!=null)
            cur = cur.getRight();
        return cur.getData();
    }

    @Override
    public int nodeDepth(E value) {
        return 0;
    }

    @Override
    public int height() {
        return maxDepth()+1;
    }

    @Override
    public int maxDepth() {
        if (isEmpty()) return -1;
        return ancestors(root, 0);
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public int size() {
        if (isEmpty()) return 0;
        String raw = printTree(root, 0);
        String[] list = raw.split(" +");
        int size = 0;
        for (int i = 0; i < list.length; i++) {
            if (!list[i].isEmpty())
                size++;
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return root==null;
    }

    @Override
    public boolean contains(E data) {
        DS5_BinarySearchTree_Node<E> cur = getRoot();
        if (root!=null && root.getData().equals(data)) {
            return true;
        }
        while (cur!=null) {
            if (cur.getLeft()!=null && cur.getLeft().getData().equals(data)) {
                return true;
            }
            else if (cur.getLeft()!=null && cur.getRight().getData().equals(data)) {
                return true;
            }
            else cur = data.compareTo(cur.getData())<0 ? cur.getLeft() : cur.getRight();
        }
        return false;
    }

    @Override
    public boolean insert(E data) {
        if (root==null) {
            root = new DS5_BinarySearchTree_Node<>(data);
            return true;
        }
        DS5_BinarySearchTree_Node<E> cur = getRoot();
        boolean inserted = false;
        while (!inserted) {
            if (data.compareTo(cur.getData())==0) return false;
            else if (data.compareTo(cur.getData())<0) {
                if (cur.getLeft()==null) {
                    cur.setLeft(new DS5_BinarySearchTree_Node<>(data));
                    inserted = true;
                } else cur = cur.getLeft();
            }
            else {
                if (cur.getRight()==null) {
                    cur.setRight(new DS5_BinarySearchTree_Node<>(data));
                    inserted = true;
                } else cur = cur.getRight();
            }
        }
        return true;
    }

    @Override
    public boolean remove(E data) {
        DS5_BinarySearchTree_Node<E> cur = getRoot();
        if (root!=null && root.getData().equals(data)) {
            root = null;
            return true;
        }
        while (cur!=null) {
            if (cur.getLeft()!=null && cur.getLeft().getData().equals(data)) {
                cur.setLeft(null);
                return true;
            }
            else if (cur.getLeft()!=null && cur.getRight().getData().equals(data)) {
                cur.setRight(null);
                return true;
            }
            else cur = data.compareTo(cur.getData())<0 ? cur.getLeft() : cur.getRight();
        }
        return false;
    }

    private String printTree(DS5_BinarySearchTree_Node<E> node, int order) {
        if (node==null) return " ";
        return switch (order) {
            case 0 -> node.getData().toString()
                    + " " + printTree(node.getLeft(), 0)
                    + " " + printTree(node.getRight(), 0);
            case 1 -> printTree(node.getLeft(), 1)
                    + " " + node.getData().toString()
                    + " " + printTree(node.getRight(), 1);
            case 2 -> printTree(node.getLeft(), 2)
                    + " " + printTree(node.getRight(), 2)
                    + " " + node.getData().toString();
            default -> "This should not happen";
        };
    }
    private int ancestors(DS5_BinarySearchTree_Node<E> node, int curAncestors) {
        if (node==null) return curAncestors-1;
        if (node.getLeft()==null&&node.getRight()==null)
            return curAncestors;
        return Math.max(ancestors(node.getLeft(), curAncestors+1), ancestors(node.getRight(), curAncestors+1));
    }
}
