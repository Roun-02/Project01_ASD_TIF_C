/**
 * testSinglyLinkedList
 */
public class testDoublyLinkedList {

    public static void main(String[] args) {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        linkedList.addFirst(4);
        linkedList.addFirst(5);
        linkedList.addFirst(6);
        System.out.println(linkedList.get(2)); // menghasilkan nilai 4
        System.out.println(linkedList.get(12)); //Terjadi exception error -> kami menggunakan Try-catch agar program tetap berjalan
        System.out.println(linkedList.indexOf(4));// menghasilkan 2
        System.out.println(linkedList.indexOf(10));// menghasilkan -1
        linkedList.printReverse(); // Menghasilkan 1,2,3,4,5,6
        linkedList.print(); // Menghasilkan 6,5,4,3,2,1
        System.out.println(linkedList.remove(3)); // Menghasilkan True
        System.out.println(linkedList.remove(8)); // Menghasilkan False
        System.out.println(linkedList.toArray()); //Menghasilkan alamat memori dari array yang berisi 6,5,4,2,1
    }
}