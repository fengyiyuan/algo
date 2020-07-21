package com.feng.bst;


import com.feng.algo.Queue;

public class BST<K extends Comparable<K>, V> extends ST<K, V> {

    private Node root;

    public BST(K key, V val) {
        this.root = new Node(key, val);
    }

    public BST() {

    }

    class Node {
        K key;
        V val;

        Node left;
        Node right;

        int N;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
            this.N = 1;
        }
    }


    @Override
    public void put(K key, V val) {
        this.root = put(root, key, val);
    }

    private Node put(Node node, K key, V val) {
        if (node == null) {
            return new Node(key, val);
        }

        int ret = key.compareTo(node.key);

        if (ret > 0) {
            node.right = put(node.right, key, val);
        } else if (ret < 0) {
            node.left = put(node.left, key, val);
        } else {
            node.val = val;
        }
        node.N = size(node.left) + size(node.right) + 1;
        return node;


    }

    @Override
    public V get(K key) {
        if (isEmpty()) {
            return null;
        }

        Node node = get(root, key);
        if (node == null) {
            return null;
        }
        return node.val;
    }

    private Node get(Node node, K key) {

        if (node == null) {
            return null;
        }

        int ret = key.compareTo(node.key);

        if (ret > 0) {
            return get(node.right, key);
        } else if (ret < 0) {
            return get(node.left, key);
        } else {
            return node;
        }

    }

    @Override
    public void delete(K key) {

        root = delete(root, key);

    }

    private Node delete(Node node, K key) {

        if (node == null) {
            return null;
        }

        int ret = key.compareTo(node.key);

        if (ret > 0) {
            node.right = delete(node.right, key);
        } else if (ret < 0) {
            node.left = delete(node.left, key);
        } else {

            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }

            Node t = node;
            node = getMax(t.left);
            node.left = deleteMax(t.left);
            node.right = t.right;


        }
        node.N = size(node.left) + 1 + size(node.right);

        return node;

    }

    @Override
    public boolean contains(K key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public K min() {

        if (isEmpty()) {
            return null;
        }

        return getMin(root).key;
    }

    private Node getMin(Node node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) {
            return node;
        }
        return getMin(node.left);
    }

    @Override
    public K max() {
        if (isEmpty()) {
            return null;
        }
        return getMax(root).key;
    }

    private Node getMax(Node node) {
        if (node.right == null) {
            return node;
        }
        return getMax(node.right);
    }

    @Override
    public K floor(K key) {

        if (isEmpty()) {
            return null;
        }

        return getFloor(root, key).key;
    }

    private Node getFloor(Node node, K key) {
        if (node == null) {
            return null;
        }

        int ret = key.compareTo(node.key);

        if (ret == 0) {
            return node;
        }

        if (ret < 0) {
            return getFloor(node.left, key);
        }

        Node tmp = getFloor(node.right, key);

        if (tmp != null) {
            return tmp;
        }
        return node;



    }



    @Override
    public K ceiling(K key) {
        if (isEmpty()) {
            return null;
        }
        return getCeiling(root, key).key;
    }

    private Node getCeiling(Node node, K key) {

        if (node == null) {
            return null;
        }

        int ret = key.compareTo(node.key);

        if (ret == 0) {
            return node;
        }

        if (ret > 0) {
            return getCeiling(node.right, key);
        }

        Node tmp = getCeiling(node.left, key);

        if (tmp != null) {
            return tmp;
        }
        return node;


    }

    @Override
    public int rank(K key) {
        return rank(root, key);
    }

    public int rank(Node node, K key) {

        if (node == null) {
            return 0;
        }

        int ret = key.compareTo(node.key);

        if (ret < 0) {
            return rank(node.left, key);
        } else if (ret > 0) {
            return size(node.left) + 1 + rank(node.right, key);
        } else  {
            return size(node.left);
        }
    }

    @Override
    public K select(int n) {

        if (isEmpty()) {
            return null;
        }

        return select(root, n).key;
    }

    public Node select(Node node, int n) {

        if (node == null) {
            return null;
        }

        int size = size(node.left);

        if (size > n) {
            return select(node.left, n);
        } else if (size < n) {
            return select(node.right, n - size - 1);
        }
        return node;

    }

    @Override
    public void deleteMin() {

        if (isEmpty()) {
            return;
        }

        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node == null) {
            return null;
        }

        if (node.left == null) {
            return node.right;
        }

        node.left = deleteMin(node.left);
        node.N = size(node.left) + 1 + size(node.right);

        return node;
    }

    @Override
    public void deleteMax() {
        root = deleteMax(root);
    }

    private Node deleteMax(Node node) {

        if (node == null) {
            return null;
        }

        if (node.right == null) {
            return node.left;
        }

        node.right = deleteMax(node.right);

        node.N = size(node.left) + 1 + size(node.right);

        return node;

    }

    @Override
    public int size() {
        return size(root);
    }

    @Override
    public int size(K lo, K hi) {

        if (hi.compareTo(lo) < 0) {
            return 0;
        }

        if (contains(hi)) {
            return rank(hi) - rank(lo) + 1;
        }
        return rank(hi) - rank(lo);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.N;
    }

    @Override
    public Iterable<K> keys() {
        return null;
    }

    @Override
    public Iterable<K> keys(K lo, K hi) {
        Queue<K> queue = new Queue<K>();

        keys(root, queue, lo, hi);

        return queue;
    }

    private void keys(Node node, Queue<K> queue, K lo, K hi){
        if (node == null) {
            return;
        }

        int loRet = lo.compareTo(node.key);
        int hiRet = hi.compareTo(node.key);

        if (loRet < 0) {
            keys(node.left, queue, lo, hi);
        }
        if (loRet <= 0 && hiRet >= 0) {
            queue.enqueue(node.key);
        }
        if (hiRet > 0) {
            keys(node.right, queue, lo, hi);
        }
    }
}
