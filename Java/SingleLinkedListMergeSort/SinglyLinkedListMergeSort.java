package SingleLinkedListMergeSort;
import java.util.ArrayList;
import java.util.List;

class SinglyLinkedList {
    public Node head = null;
    public Node tail = null;

    class Node {
        int data;
        Node nextNode;

        Node(int data) {
            this.data = data;
            this.nextNode = null;
        }

    }

    public void unshift(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else if (head.nextNode == null) {
            tail = head;
            head = newNode;
            head.nextNode = tail;
        } else {
            Node buffer = head;
            head = newNode;
            head.nextNode = buffer;
        }
    }

    public void append(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else if (head.nextNode == null) {
            tail = newNode;
            head.nextNode = tail;
        } else {
            Node buffer = tail;
            tail = newNode;
            buffer.nextNode = tail;
        }
    }

    public String display() {
        List<String> arr = new ArrayList<String>();
        String res = "";
        Node current = head;

        while (current != null) {
            if (arr.isEmpty())
                arr.add("[Head data: " + current.data + "] -> ");
            else {
                if (current.nextNode == null)
                    arr.add("[Tail data: " + current.data + "]");
                else
                    arr.add("[Node data: " + current.data + "] -> ");
            }

            current = current.nextNode;
        }

        for (String i : arr) {
            res += i;
        }
        return res;
    }

    public boolean isEmpty() {
        return (head == null && tail == null);
    }

    public int size() {
        int counter = 0;
        Node current = head;

        while (current != null) {
            counter++;
            current = current.nextNode;
        }
        return counter;
    }

    public int search(int key) {
        Node currentNode = head;
        int count = 0;

        while (currentNode != null) {
            if (currentNode.data == key)
                return count;
            else {
                currentNode = currentNode.nextNode;
                count++;
            }
        }

        return -1;
    }

    public void insert(int index, int data) {
        Node currentNode = head;
        Node newNode = new Node(data);

        for (int i = 0; i < index - 1; i++)
            if (currentNode.nextNode != null)
                currentNode = currentNode.nextNode;

        Node buffer = currentNode.nextNode;
        currentNode.nextNode = newNode;
        newNode.nextNode = buffer;
    }

    public void removeByIndex(int index) {
        Node prevNode = head;
        Node currentNode = prevNode.nextNode;

        for (int i = 0; i < index - 1; i++)
            if (currentNode.nextNode != null) {
                prevNode = currentNode;
                currentNode = currentNode.nextNode;
            }

        prevNode.nextNode = currentNode.nextNode;
    }

    public void removeByKey(int key) {
        Node prevNode = head;
        Node currentNode = prevNode.nextNode;
        boolean check = false;

        while (currentNode.nextNode != null) {
            if (currentNode.data == key) {
                check = true;
                break;
            }
            prevNode = currentNode;
            currentNode = currentNode.nextNode;
        }

        if (check)
            prevNode.nextNode = currentNode.nextNode;
    }
}

public class SinglyLinkedListMergeSort {
    public static void main(String[] args) {
        SinglyLinkedList sList = new SinglyLinkedList();

        sList.unshift(11);
        sList.unshift(13);
        sList.unshift(14);
        sList.insert(2, 12);
        sList.insert(2, 12);
        sList.insert(7, 7);
        sList.unshift(1001);
        sList.unshift(10);
        sList.append(8);
        sList.insert(6, 9);

        String result = sList.display();
        int sListSize = sList.size();
        System.out.println(
                (!sList.isEmpty() ? "The SinglyLinkedList is not Empty.\n"
                        : "The SinglyLinkedList is Empty.\n") +
                        "It has " + sListSize +
                        " variables.\n" + result);
        System.out.println(sList.search(12));
        System.out.println();

        sList.removeByKey(1001);
        // sList.removeByIndex(3);
        System.out.println(sList.display());

        SinglyLinkedList sortedList = mergeSortSinglyLinkedList(sList);
        System.out.println(sortedList.display());
    }

    public static SinglyLinkedList mergeSortSinglyLinkedList(SinglyLinkedList sList) {
        if (sList.size() <= 1)
            return sList;

        List spliList = splitSinglyLinkedList(sList);
        SinglyLinkedList leftHalf = (SinglyLinkedList) spliList.get(0), rightHalf = (SinglyLinkedList) spliList.get(1);
        SinglyLinkedList leftLinkedList = mergeSortSinglyLinkedList(leftHalf);
        SinglyLinkedList rightLinkedList = mergeSortSinglyLinkedList(rightHalf);

        return mergeSinglyLinkedList(leftLinkedList, rightLinkedList);
    }

    public static List<SinglyLinkedList> splitSinglyLinkedList(SinglyLinkedList sList) {
        int sListSize = sList.size();
        SinglyLinkedList.Node curreNode = sList.head;

        SinglyLinkedList left = new SinglyLinkedList();
        SinglyLinkedList right = new SinglyLinkedList();

        List<SinglyLinkedList> sListArr = new ArrayList<SinglyLinkedList>();
        int midpoint = Math.floorDiv(sListSize, 2);

        for (int i = 1; i < sListSize + 1; i++) {
            if (i <= midpoint)
                left.append(curreNode.data);
            if (i > midpoint)
                right.append(curreNode.data);

            curreNode = curreNode.nextNode;
        }

        sListArr.add(left);
        sListArr.add(right);

        return sListArr;
    }

    public static SinglyLinkedList mergeSinglyLinkedList(SinglyLinkedList leftSinglyLinkedList, SinglyLinkedList rightSinglyLinkedList) {
        SinglyLinkedList newSinglyLinkedList = new SinglyLinkedList();
        int leftCounter = 0, rightCounter = 0;
        SinglyLinkedList.Node leftNode = leftSinglyLinkedList.head, rightNode = rightSinglyLinkedList.head;

        while (leftCounter < leftSinglyLinkedList.size() && rightCounter < rightSinglyLinkedList.size()) {
            if (leftNode.data < rightNode.data) {
                newSinglyLinkedList.append(leftNode.data);
                leftNode = leftNode.nextNode;
                leftCounter++;
            } else {
                newSinglyLinkedList.append(rightNode.data);
                rightNode = rightNode.nextNode;
                rightCounter++;
            }
        }

        while (leftCounter < leftSinglyLinkedList.size()) {
            newSinglyLinkedList.append(leftNode.data);
            leftNode = leftNode.nextNode;
            leftCounter++;
        }

        while (rightCounter < rightSinglyLinkedList.size()) {
            newSinglyLinkedList.append(rightNode.data);
            rightNode = rightNode.nextNode;
            rightCounter++;
        }

        return newSinglyLinkedList;
    }
}