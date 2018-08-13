package homework8.TreeSet;

class Node<T> {

    private T value;
    private Node<T> leftChild;
    private Node<T> rightChild;
    private Node<T> nextSmallest;
    private Node<T> nextLargest;

    Node(T value) {
        this.value = value;
    }

    T getValue() {
        return value;
    }

    void setValue(T value) {
        this.value = value;
    }

    Node<T> getLeftChild() {
        return leftChild;
    }

    void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    Node<T> getRightChild() {
        return rightChild;
    }

    void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    Node<T> getNextSmallest() {
        return nextSmallest;
    }

    void setNextSmallest(Node<T> nextSmallest) {
        this.nextSmallest = nextSmallest;
    }

    Node<T> getNextLargest() {
        return nextLargest;
    }

    void setNextLargest(Node<T> nextLargest) {
        this.nextLargest = nextLargest;
    }

    public String toString() {
        String retString = null;
        if (value != null) {
            retString = value.toString();
        }
        return retString;
    }
}