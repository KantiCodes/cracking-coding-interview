package DataStructures.MyLinkedList;

public class MyLinkedList extends MyNode {
    MyLinkedList head;
    MyLinkedList tail;
    
    public MyLinkedList(int data) {
        super(data);
        head = this;
    }

    public MyLinkedList() {
        super();
    }

    public void SetNext(MyLinkedList node) {
        this.next = node;
        // Update the tail if current node is the tail
        if (this == tail) {
            tail = node;
        }

        // If the node is not null and it's previous is not the current node
        // Update the previous reference of the node
        if (node != null && node.previous != this) {
            node.previous = this;
        }

    }

    public void SetPrevious(MyNode node) {
        previous = node;
        if (node != null) {
            node.next = this;
            // If we are updating the previous of the head we need to update the head as well
            if (this == head) {
                head = node;
            }
        }
    }

    public void DeleteNode() {
        // Case deleting head
        MyNode tmpNext = this.next;
        MyNode tmpPrevious = this.previous;
        if (head == this) {
            head = this.next;
        }
        this.next.SetPrevious(tmpPrevious);

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
