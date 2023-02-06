package DataStructures.MyLinkedList;

public class MyLinkedList1 {
    public static class Node {
        Node previous, next;
        int data;
        public Node (int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return String.format("Node: %d",this.data);
        }
    
    }
    Node head, tail = null;

    public void addNode(Node node) {
        // If empty list
        if (head == null) {
            head = tail = node;
        }
        else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
    }
    // private void SetPrevious(MyLinkedList1 p) {
    //     this.previous = p;
    //     // If p isn't a node
    //     if (p == null) {
    //         System.out.println("Previous is null");
    //         return;
    //     }
    //     // If this is the head then we need a new head
    //     if (head == this) { 
    //         System.out.println("updating head");
    //         head = p;
    //     }
    //     // If the p doesn't have next we set it
    //     if (p.next != this) {
    //         p.SetNext(this);
    //     }
    // }

    // @Override
    // public String toString() {
    //     if (head == null) return "Empty List";

    //     int headId, tailId, nextId, previousId;
    //     headId = tailId = nextId = previousId = -1;
    //     if (head != null) headId = head.data;
    //     if (tail != null) tailId = tail.data;
    //     if (this.next != null) nextId = next.data;
    //     if (previous != null) previousId = previous.data;
    //     return String.format(
    //         "LinkedNode: %d <- %d -> %d     Head: %d, Tail: %d",
    //         previousId, this.data, nextId, headId, tailId
    //     );
    // }
    
    public void printList(boolean backwards) {
        Node curr;
        String msg = "";
        if (backwards) {
            curr = this.tail;
            while (curr != null) {
                System.out.println(curr.data);
                msg += String.format("%d <- ", curr.data);
                curr = curr.previous;
            }
        }
        else {
            curr = this.head;
            while (curr != null) {
                msg += String.format("%d -> ", curr.data);
                curr = curr.next;
            }
        }


        System.out.println(msg);
    }
    

    public static void main(String[] args) {
        MyLinkedList1 ll = new MyLinkedList1();
        ll.addNode(new Node(0));
        ll.addNode(new Node(1));
        ll.addNode(new Node(2));
        ll.addNode(new Node(3));
        ll.addNode(new Node(4));
        // ll.SetNext(new MyLinkedList1(1));
        // ll.next.SetNext(new MyLinkedList1(2));
        ll.printList(false);
        ll.printList(true);
        System.out.println(ll.head);
        System.out.println(ll.tail);
        // LinkedNode currentNode = ll.head;
        // int i = 5;
        // while (i>= 0) {
        //     currentNode.SetNext(new LinkedNode(6-i));
        //     currentNode = currentNode.next;
        //     i--;
        // }
        
        // currentNode = ll.head;
        // while (currentNode != null) {
        //     System.out.println(currentNode);
        //     currentNode = currentNode.next;
        // }
    }
}

