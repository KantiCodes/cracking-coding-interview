package HundredEightyNineProblems.ArrayAndStrings.PalindromePermutation;
import java.util.BitSet;
import java.util.HashMap;

public class Main {
    
    public static class Pair {
        public String word;
        public boolean result;
        public Pair(String word, boolean result) {
            this.word = word;
            this.result = result;
        }
    }

    public static Pair[] cases = {
        new Pair("a", true),
        new Pair("", true),
        new Pair("aaabb", true),
        new Pair("aab! bb", true),
        new Pair("aabbcc", true),
        new Pair("daabbcc", true),
        new Pair("daabbccdde", false),
        new Pair("ab", false),
        new Pair("aabbcccd", false),
        new Pair("", true),
        new Pair("daabbcc", true),
        new Pair("avc", false),
    };


    public static void main(String[] args) {
        System.out.println();
        Main main = new Main();
        for (Pair theCase: cases){
            boolean myResultHash = main.HashMapSolution(theCase.word);
            boolean myResultBit = main.bitArrayXorSolution(theCase.word);
            boolean myResultBitSetOptimized = main.IntAsBitArraySolution(theCase.word);
            boolean expectedResult = theCase.result;
            if (myResultHash != expectedResult) {
                System.out.println(String.format("The hash case: %s, failed, expected value: %b", theCase.word, expectedResult));
            }
            if (myResultBit != expectedResult) {
                System.out.println(String.format("The bit unoptimized case: %s, failed, expected value: %b", theCase.word, expectedResult));
            }

            if (myResultBitSetOptimized != expectedResult) {
                System.out.println(String.format("The bit optimized case: %s, failed, expected value: %b", theCase.word, expectedResult));
            }


        }

    }

    public boolean HashMapSolution(String word){
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }
        HashMap<Integer,Integer> myMap = new HashMap<>();

        for (char c: word.toCharArray()) {
            int c_int = intToChar(c);
            if (c_int == -1) continue;
            int val = myMap.getOrDefault(c_int, 0);
            myMap.put(c_int, val+1);
        }
        

        boolean uneven = false;

        for (Integer c: myMap.keySet()) {
            if (myMap.get(c) %2 != 0) {
                if (uneven) return false;
                uneven = true;
            }

        }
        return true;
    }

    public boolean bitArrayXorSolution(String word){
        BitSet bitArr = new BitSet();
        for (char c: word.toCharArray()) {
            int index = intToChar(c);
            if (index == -1) continue;
            boolean result = bitArr.get(index) ^ true;
            if (result) bitArr.set(index);
            else bitArr.clear(index);
        }
        boolean seenUneven = false;
        for (int i=0;i<=122-65;i++){
            if (bitArr.get(i)) {
                if (seenUneven) return false;
                seenUneven = true;
            }
        }
        return true;
    }
    public boolean IntAsBitArraySolution(String word) {
        int bitSet = 0;
        for (char c: word.toCharArray()) {
            int cInt = intToChar(c);
            if (cInt != -1) {
                bitSet = flipBitSet(bitSet, cInt);
            }
        }
        // System.out.println(bitSet);
        if (bitSet == 0) return true;
        if (hasOneBitFlipped(bitSet)) return true;

        return false;


    }

    public int intToChar(char c) {

        int c_int = c;
        int a = 'a';
        int z = 'z';

        if (a <= c_int && z >= c_int) {
            return c_int - a;
        }

        return -1;
    }

    public int flipBitSet(int bitSet, int index) {

        int value = 1 << index;

        if ((value & bitSet) == 0) {
            bitSet = bitSet | value;
        }
        else { 
            bitSet = bitSet ^ value;
        }
        // System.out.println(1);
        // System.out.println(bitSet);
        // System.out.println(2);


        return bitSet;
    }

    public boolean hasOneBitFlipped(int value) {

        int result = value & (value - 1);
        return result == 0;
    }


}
