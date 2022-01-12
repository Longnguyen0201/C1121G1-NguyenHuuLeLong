package ss10_ArrayList_LinkedList.thuc_hanh.SimpleLinkedList;

public class TestMyLinkedList {
    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        MyLinkedList myLinkedList = new MyLinkedList(10);
        myLinkedList.addFirst(11);
        myLinkedList.addFirst(12);
        myLinkedList.addFirst(13);

        MyLinkedList.add(4,9);
        MyLinkedList.add(4,9);

        MyLinkedList.printList();
    }
}
