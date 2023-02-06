package DataStructures.MyLinkedList;

public class MyLinkedList extends MyNode {
    MyNode head;
    public MyLinkedList(int data) {
        super(data);
        head = this;
    }

    public void addNode(MyNode node) {
        MyNode currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = node;
    }

    public void DeleteNode(int d) {
        if (this.data == d) {
            this.head = head.next;
            return;
        }
        MyNode currentNode = this;
        while (currentNode.next.data != d) {
            currentNode = currentNode.next;
        }
        currentNode.next = currentNode.next.next;
        return;
    }

    @Override
    public String toString(){
        String arrow = " ->: ";
        String result = "";
        MyNode currentNode = head;
        while (currentNode != null) {
            result += Integer.toString(currentNode.data) + arrow;
            currentNode = currentNode.next;
        }
        return result;
    }
}
