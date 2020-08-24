package de.dhbwka.java.exercise.collections;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class BinaryTree<T extends Comparable<T>> {
    private T value;
    private BinaryTree<T> left;
    private BinaryTree<T> right;

    public BinaryTree() {
    }

    /**
     * Checks if actual node is null
     * @return <code>true</code> if actual node is null, <code>false</code> if not
     */
    public boolean isEmpty() {
        return this.value == null;
    }

    /**
     * adds new value to BinaryTree at right position (no duplicates allowed)
     * @param newValue value that shall be added
     * @return <code>true</code> if value was added, <code>false</code> if not (because it was already in the tree)
     */
    public boolean add(T newValue) {
        if (this.isEmpty()) {
            this.value = newValue;
            this.setLeft(null);
            this.setRight(null);
            return true;
        } else if (newValue.compareTo(this.value) < 0) {
            return this.getLeft().add(newValue);
        } else if (newValue.compareTo(this.value) > 0) {
            return this.getRight().add(newValue);
        } else return false;
    }

    /**
     * returns ascending sorted list with tree's values
     * @return all values of the BinaryTree in an ascending srted list
     */
    public List<T> traverse() {
        List<T> list = new LinkedList<>();
        this.doTraverse(list);
        return list;
    }

    /**
     * add tree's values recursive to given list, ascending sorted
     * @param list list to which values shall be added
     */
    public void doTraverse(List<T> list) {
        //left side of a node first -> smaller
        if (this.left != null) {
            this.left.doTraverse(list);
        }
        //add node
        if (this.value != null) {
            list.add(this.value);
        }
        //right side of a node last -> bigger
        if (this.right != null){
            this.right.doTraverse(list);
        }
    }

    /**
     * returns node's left child and creates new node before, if child would be empty (<code>this.left==null)</code>
     * @return node's left child
     */
    public BinaryTree<T> getLeft() {
        if (this.left == null){
            this.left = new BinaryTree<>();
        }
        return this.left;
    }

    /**
     * set node's left child
     * @param left node that shall be added as left child
     */
    public void setLeft(BinaryTree<T> left) {
        this.left = left;
    }

    /**
     * returns node's right child and creates new node before, if child would be empty (<code>this.right==null)</code>
     * @return node's right child
     */
    public BinaryTree<T> getRight() {
        if(this.right == null){
            this.right = new BinaryTree<>();
        }
        return this.right;
    }

    /**
     * set node's right child
     * @param right node that shall be added as right child
     */
    public void setRight(BinaryTree<T> right) {
        this.right = right;
    }

    /**
     * get node's value
     * @return node's value
     */
    public T getValue() {
        return this.value;
    }

    /**
     * set node's value
     * @param value value that shall be set for node
     */
    public void setValue(T value) {
        this.value = value;
    }

}

class BinaryTreeTest {
    public static void main(String[] args) {
        Random rnd = new Random();
        BinaryTree<Integer> tree = new BinaryTree<>();
        for (int i = 0; i < 10; i++) {
            Integer newInt = rnd.nextInt(20);
            System.out.print(newInt);
            System.out.println(" " + tree.add(newInt));
        }
        System.out.println("------------");
        for (Integer t : tree.traverse()) {
            System.out.println(t.toString());
        }
    }
}