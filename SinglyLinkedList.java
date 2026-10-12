/**
 * SinglyLinkedList
 */
public class SinglyLinkedList implements LinkedList {

    public Node head, tail;
    private int size = 0;

    public SinglyLinkedList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void addFirst(Object inputData) {
        Node baru = new Node(inputData);
        if (isEmpty()) {
            head = baru;
            tail = baru;
            size++;
        } else {
            baru.pointer = head;
            head = baru;
            size++;
        }
    }

    public void addLast(Object inputData) {
        Node baru = new Node(inputData);
        if (isEmpty()) {
            head = baru;
            tail = baru;
            size++;
        } else {
            tail.pointer = baru;
            tail = baru;
            size++;
        }
    }

    public void addAfter(int index, Object inputData) {
        Node baru = new Node(inputData);
        Node C = head;
        for (int i = 0; i < index; i++) {
            C = C.pointer;
        }
        baru.pointer = C.pointer;
        C.pointer = baru;
    }

    public void deleteFirst() {
        if (isEmpty()) {
            System.err.println("Linked list kosong");
        } else if (size == 1) {// else if(head==tail)
            head = null;
            tail = null;
            size--;
        } else {
            head = head.pointer;
            size--;
        }
    }

    public void deleteLast() {
        if (isEmpty()) {
            System.err.println("Linked list kosong");
        } else if (size == 1) {// else if(head==tail)
            head = null;
            tail = null;
            size--;
        } else {
            Node temp = head;
            for (int i = 1; i < size; i++) {
                temp = temp.pointer;
            }
            tail = temp;
            tail.pointer = null;
            size--;
        }
    }

    public void deleteAfter(int index) {
        if (isEmpty()) {
            System.err.println("Linked list kosong");
        } else if (size == 1) {// else if(head==tail)
            head = null;
            tail = null;
            size--;
        } else {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.pointer;
            }
            temp.pointer = temp.pointer.pointer;
            size--;
        }
    }

    public void print() {
        Node currentNode = head;
        for (int i = 0; i < size; i++) {
            System.out.print(currentNode.data + ", ");
            currentNode = currentNode.pointer;
        }
        System.out.println();
    }

    @Override
    public Object get(int index) {
        try {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index tidak valid! Index yang diminta: " + index + ", sedangkan jumlah data: " + size + ". Index yang valid adalah 0 sampai " + (size - 1) + ".");
            }
            Node currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.pointer;
            }
            return currentNode.data;

        } catch (IndexOutOfBoundsException e) {
            return "Error: " + e.getMessage();
        }
    }

    @Override
    public int indexOf(Object targetData) {
        Node currentNode = head;
        int index = 0;

        while (currentNode != null && !currentNode.data.equals(targetData)) {
            currentNode = currentNode.pointer;
            index++;
        }
        if (currentNode == null) {
            return -1;
        } else {
            return index;
        }
    }

    @Override
    public void printReverse() {
        Object[] save = toArray();
        for (int i = size - 1; i >= 0; i--) {
            System.out.print(save[i] + ", ");
        }
        System.out.println();
    }

    @Override
    public boolean remove(Object targetData) {
        if (isEmpty())
            return false;

        if (head.data.equals(targetData)) {
            deleteFirst();
            return true;
        }

        Node temp = head;
        while (temp.pointer != null) {
            if (temp.pointer.data.equals(targetData)) {
                if (temp.pointer == tail)
                    tail = temp;
                temp.pointer = temp.pointer.pointer;
                size--;
                return true;
            }
            temp = temp.pointer;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] arrObjects = new Object[size];
        Node currentNode = head;
        for (int i = 0; i < size; i++) {
            arrObjects[i] = currentNode.data;
            currentNode = currentNode.pointer;
        }
        return arrObjects;
    }
}