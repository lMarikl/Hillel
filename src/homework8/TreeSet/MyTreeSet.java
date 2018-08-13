package homework8.TreeSet;

import java.util.Comparator;
import java.util.Iterator;

public class MyTreeSet<T extends Comparable<T>> implements Iterable<T> {
    private Node<T> root;
    private Node<T> head;
    private Node<T> tail;
    private int size;
    private Comparator<T> comparator;

    MyTreeSet() {
        head = new Node<>(null);
        tail = new Node<>(null);
        head.setNextLargest(tail);
        tail.setNextSmallest(head);
        size = 0;
    }

    void add(T element) {
        if (root == null) {
            root = new Node<>(element);
            addNewNodeToList(head, root);
            ++size;
        } else {
            if (comparator != null && addWithComparator(element, root)) {
                ++size;
            } else if (comparator == null && add(element, root)) {
                ++size;
            }
        }
    }

    private boolean add(T element, Node<T> subroot) {
        T currVal = subroot.getValue();
        if (currVal.compareTo(element) == 0) {
            return false;
        } else if (currVal.compareTo(element) > 0) {
            Node<T> leftChild = subroot.getLeftChild();
            if (leftChild == null) {
                addNewLeftChild(subroot, element);
                return true;
            } else {
                return add(element, leftChild);
            }
        } else if (currVal.compareTo(element) < 0) {
            Node<T> rightChild = subroot.getRightChild();
            if (rightChild == null) {
                addNewRightChild(subroot, element);
                return true;
            } else {
                return add(element, rightChild);
            }
        }
        return true;
    }

    private boolean addWithComparator(T element, Node<T> subroot) {

        T currVal = subroot.getValue();
        if (comparator.compare(currVal, element) == 0) {
            return false;
        } else if (comparator.compare(currVal, element) > 0) {
            Node<T> leftChild = subroot.getLeftChild();
            if (leftChild == null) {
                addNewLeftChild(subroot, element);
                return true;
            } else {
                return addWithComparator(element, leftChild);
            }
        } else if (comparator.compare(currVal, element) < 0) {
            Node<T> rightChild = subroot.getRightChild();
            if (rightChild == null) {
                addNewRightChild(subroot, element);
                return true;
            } else {
                return addWithComparator(element, rightChild);
            }
        }
        return false;
    }

    private void addNewLeftChild(Node<T> currNode, T element) {
        Node<T> leftChild = new Node<>(element);
        currNode.setLeftChild(leftChild);
        addNewNodeToList(leftChild, currNode);
    }

    private void addNewRightChild(Node<T> currNode, T element) {
        Node<T> rightChild = new Node<>(element);
        currNode.setRightChild(rightChild);
        addNewNodeToList(currNode, rightChild);
    }

    private void addNewNodeToList(Node<T> smaller, Node<T> larger) {
        if (smaller.getNextLargest() != null) {
            Node<T> tmpNode = smaller.getNextLargest();
            larger.setNextLargest(tmpNode);
            tmpNode.setNextSmallest(larger);
        } else if (larger.getNextSmallest() != null) {
            Node<T> tmpNode = larger.getNextSmallest();
            smaller.setNextSmallest(tmpNode);
            tmpNode.setNextLargest(smaller);
        }
        smaller.setNextLargest(larger);
        larger.setNextSmallest(smaller);
    }

    boolean contains(T element) {
        if (element == null) {
            throw new NullPointerException("Element can't be null.");
        }
        if (root != null && comparator == null)
            return contains(root, element);
        else if (root != null)
            return containsWithComparator(root, element);
        else
            return false;
    }

    private boolean contains(Node<T> toSearch, T element) {
        if (toSearch == null) {
            return false;
        }
        if (toSearch.getValue().compareTo(element) == 0) {
            return true;
        }
        if (toSearch.getValue().compareTo(element) < 0) {
            return contains(toSearch.getRightChild(), element);
        } else {
            return contains(toSearch.getLeftChild(), element);
        }
    }

    private boolean containsWithComparator(Node<T> toSearch, T element) {
        if (toSearch == null) {
            return false;
        }
        if (comparator.compare(toSearch.getValue(), element) == 0) {
            return true;
        }
        if (comparator.compare(toSearch.getValue(), element) < 0) {
            return containsWithComparator(toSearch.getRightChild(), element);
        } else { // > 0
            return containsWithComparator(toSearch.getLeftChild(), element);
        }
    }

    void remove(T element) {
        if (element == null) {
            throw new NullPointerException("Element can't be null.");
        }
        if (comparator != null && root != null) {
            root = removeWithComparator(element, root);
        } else if (root != null) {
            root = remove(element, root);
        }
    }

    private Node<T> remove(T element, Node<T> currNode) {
        Node<T> newSubroot = currNode;
        T currVal = currNode.getValue();
        if (currVal.compareTo(element) == 0) {
            newSubroot = removeCurrentNode(currNode);
        } else if (currVal.compareTo(element) > 0) {
            Node<T> leftChild = currNode.getLeftChild();
            if (leftChild != null) {
                currNode.setLeftChild(remove(element, leftChild));
            }
        } else if (currVal.compareTo(element) < 0) {
            Node<T> rightChild = currNode.getRightChild();
            if (rightChild != null) {
                currNode.setRightChild(remove(element, rightChild));
            }
        }
        return newSubroot;
    }

    private Node<T> removeWithComparator(T element, Node<T> currNode) {
        Node<T> newSubroot = currNode;
        T currVal = currNode.getValue();
        if (comparator.compare(currVal, element) == 0) {
            newSubroot = removeCurrentNode(currNode);
        } else if (comparator.compare(currVal, element) > 0) {
            Node<T> leftChild = currNode.getLeftChild();
            if (leftChild != null) {
                currNode.setLeftChild(removeWithComparator(element, leftChild));
            }
        } else if (comparator.compare(currVal, element) < 0) {
            Node<T> rightChild = currNode.getRightChild();
            if (rightChild != null) {
                currNode.setRightChild(removeWithComparator(element, rightChild));
            }
        }
        return newSubroot;
    }

    private Node<T> removeCurrentNode(Node<T> currNode) {
        Node<T> retVal;
        Node<T> leftChild = currNode.getLeftChild();
        Node<T> rightChild = currNode.getRightChild();
        if (leftChild != null && rightChild != null) {
            Node<T> smallestNode = removeSmallestValue(rightChild);
            currNode.setValue(smallestNode.getValue());
            if (smallestNode == rightChild) {
                currNode.setRightChild(smallestNode.getRightChild());
            }
            retVal = currNode;
        } else if (leftChild != null) {
            retVal = leftChild;
            removeFromList(currNode);
        } else if (rightChild != null) {
            retVal = rightChild;
            removeFromList(currNode);
        } else {
            retVal = null;
            removeFromList(currNode);
        }
        --size;
        return retVal;
    }

    private Node<T> removeSmallestValue(Node<T> subroot) {
        Node<T> parentNode = subroot;
        Node<T> nextNode = subroot;
        while (nextNode.getLeftChild() != null) {
            parentNode = nextNode;
            nextNode = nextNode.getLeftChild();
        }
        if (parentNode != nextNode) {
            parentNode.setLeftChild(nextNode.getRightChild());
        }
        removeFromList(nextNode);
        return nextNode;
    }

    private void removeFromList(Node<T> toRemove) {
        Node<T> smaller = toRemove.getNextSmallest();
        Node<T> larger = toRemove.getNextLargest();
        smaller.setNextLargest(larger);
        larger.setNextSmallest(smaller);
    }

    int size() {
        return size;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node<T> tmpNode = head.getNextLargest();
        while (tmpNode != tail) {
            if (builder.length() != 0) {
                builder.append(", ");
            }
            builder.append(tmpNode.toString());
            tmpNode = tmpNode.getNextLargest();
        }
        return "[" + builder.toString() + "]";
    }

    public Iterator<T> iterator() {
        return new MyTreeSetIterator();
    }

    private class MyTreeSetIterator implements Iterator<T> {
        private Node<T> currentNode;

        MyTreeSetIterator() {
            currentNode = head;
        }

        public boolean hasNext() {
            if (size == 0)
                return false;
            else
                return currentNode.getNextLargest().getValue() != null;
        }

        public T next() {
            currentNode = currentNode.getNextLargest();
            return currentNode.getValue();
        }

        public void remove() {
            Node<T> temp = currentNode;
            MyTreeSet.this.remove(currentNode.getValue());
            currentNode = temp;
        }
    }
}