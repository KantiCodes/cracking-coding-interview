package DataStructures.MyLinkedList;

public class MyNode {
    MyNode next = null;
    int data;

    @Override
    public String toString(){
        String nextInfo = " -> null";
        if (next != null){
            nextInfo = " -> " + Integer.toString(next.data);
        }
        return "This is node: " + Integer.toString(data) + nextInfo;
    }

    public MyNode(int data) {
        this.data = data;
    }
}
