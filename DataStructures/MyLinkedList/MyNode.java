package DataStructures.MyLinkedList;

public class MyNode {
    MyNode next = null;
    MyNode previous = null;
    int data;
    
    public MyNode(int data) {
        this.data = data;
    }

    public MyNode() {}

    // public void SetNext(MyNode node) {

    // }

    @Override
    public String toString(){
        String nextInfo = " -> null";
        if (next != null){
            nextInfo = " -> " + Integer.toString(next.data);
        }
        return "This is node: " + Integer.toString(data) + nextInfo;
    }

}
