package HundredEightyNineProblems.ArrayAndStrings.PalindromePermutation;
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
        new Pair("aabbb", true),
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
        Main main = new Main();
        for (Pair theCase: cases){
            boolean myResult = main.HashMapSolution(theCase.word);
            boolean expectedResult = theCase.result;
            if (myResult != expectedResult) {
                System.out.println(String.format("The case: %s, failed, expected value: %b", theCase.word, expectedResult));
            }
        }
    }

    public boolean HashMapSolution(String word){
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }
        HashMap<Character,Integer> myMap = new HashMap<>();

        for (char c: word.toCharArray()) {
            int val = myMap.getOrDefault(c, 0);
            myMap.put(c, val+1);
        }

        boolean uneven = false;

        for (char c: myMap.keySet()) {
            if (myMap.get(c) %2 != 0) {
                if (uneven) return false;
                uneven = true;
            }

        }
        return true;
    }

}
