package DataStructures.Heap;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class MinHeap {

    static int[] vals = new int[10];
    // public MaxHeap() {};
    public static void main(String[] args) {
        MinHeap h1 = new MinHeap();
        vals[0] = 0;
        vals[1] = 1;
        vals[2] = 2;

        System.out.println(Arrays.toString(h1.vals));
        h1.swap(1, 2);
    }

    private int indexOfParent(int index) {return (index - 1) / 2;}
    private int indexOfLeftChild(int index) {return index*2 + 1;}
    private int indexOfRightChild(int index) {return index*2 + 1;}

    private int valOfIndex(int index) {return vals[index];}

    private void swap(int index1, int index2) {
        int tmp1 = vals[index1];
        vals[index1] = vals[index2];
        vals[index2] = tmp1;
        
        System.out.println("After swapping");
        System.out.println(Arrays.toString(this.vals));


    }

}