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
        if (!contains(value)) return -1;
        DS5_BinarySearchTree_Node<E> cur = getRoot();
        int depth = 0;
        if (root!=null && root.getData().equals(value)) {
            return depth;
        }
        while (cur!=null) {
            depth++;
            if (cur.getLeft()!=null && cur.getLeft().getData().equals(value)) {
                return depth;
            }
            else if (cur.getRight()!=null && cur.getRight().getData().equals(value)) {
                return depth;
            }
            else cur = value.compareTo(cur.getData())<0 ? cur.getLeft() : cur.getRight();
        }
        return -999999;
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
        if (root==null) return 0;
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
            else if (cur.getRight()!=null && cur.getRight().getData().equals(data)) {
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
            root = removeProcess(cur);
            return true;
        }
        while (cur!=null) {
            if (cur.getLeft()!=null && cur.getLeft().getData().equals(data)) {
                cur.setLeft(removeProcess(cur.getLeft()));
                return true;
            }
            else if (cur.getRight()!=null && cur.getRight().getData().equals(data)) {
                cur.setRight(removeProcess(cur.getRight()));
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

    private int children(DS5_BinarySearchTree_Node<E> node) {
        if (node.getLeft()!=null&&node.getRight()!=null)
            return 2;
        if (node.getLeft()==null&&node.getRight()==null)
            return 0;
        return 1;
    }

    private DS5_BinarySearchTree_Node<E> removeProcess(DS5_BinarySearchTree_Node<E> cur) {
        switch (children(cur)) {
            case 0 : {
                return null;
            }
            case 1 : {
                return cur.getLeft()!=null ? cur.getLeft() : cur.getRight();
            }
            case 2: {
                DS5_BinarySearchTree_Node<E> minRight = cur.getRight();
                while (minRight.getLeft()!=null&&minRight.getLeft().getLeft()!=null)
                    minRight = minRight.getLeft();
                if (minRight.getLeft()!=null) {
                    cur.setData(minRight.getLeft().getData());
                    minRight.setLeft(minRight.getLeft().getRight());
                } else {
                    cur.setData(minRight.getData());
                    cur.setRight(minRight.getRight());
                }
                return cur;

            }
            default: return null;
        }
    }
}
