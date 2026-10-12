/**
 * testSinglyLinkedList
 */
public class testSinglyLinkedList {

    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        // linkedList.addFirst(1);
        // linkedList.addFirst(2);
        // linkedList.addFirst(3);
        // linkedList.addFirst(4);
        // linkedList.addFirst(5);
        // linkedList.addFirst(6);

        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);  
        linkedList.addLast(5);
        linkedList.addLast(6);
        System.out.println(linkedList.get(2)); // menghasilkan nilai 3
        System.out.println(linkedList.get(12)); //Terjadi exception error
        System.out.println(linkedList.indexOf(4));// menghasilkan 5
        System.out.println(linkedList.indexOf(10));// menghasilkan -1
        linkedList.printReverse(); // Menghasilkan 6,5,4,3,2,1
        linkedList.print(); // Menghasilkan 1,2,3,4,5,6
        System.out.println(linkedList.remove(3)); // Menghasilkan True
        System.out.println(linkedList.remove(8)); // Menghasilkan False
        System.out.println(linkedList.toArray()); //Menghasilkan [6,5,4,3,2,1]
    }
}