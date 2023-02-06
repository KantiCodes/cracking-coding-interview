package DataStructures.LinkedList;



public class Main {
    public static class Node {
        Node next = null;
        int data;

        @Override
        public String toString(){
            String nextInfo = " -> null";
            if (next != null){
                nextInfo = " -> " + Integer.toString(next.data);
            }
            return "This is node: " + Integer.toString(data) + nextInfo;
        }

        public Node(int data) {
            this.data = data;
        }
    }

    public static class LinkedList extends Node {
        Node head;
        public LinkedList(int data) {
            super(data);
            head = this;
        }
        public void addNode(Node node) {
            Node currNode = head;
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
            Node currentNode = this;
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
            Node currentNode = head;
            while (currentNode != null) {
                result += Integer.toString(currentNode.data) + arrow;
                currentNode = currentNode.next;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        LinkedList myLinkedList = new LinkedList(1);
        myLinkedList.addNode(new Node(2));
        myLinkedList.addNode(new Node(3));
        myLinkedList.addNode(new Node(4));
        myLinkedList.addNode(new Node(5));
        System.out.println(myLinkedList);

        myLinkedList.DeleteNode(4);
        System.out.println(myLinkedList);

        myLinkedList.DeleteNode(1);
        System.out.println(myLinkedList);




    }
}
