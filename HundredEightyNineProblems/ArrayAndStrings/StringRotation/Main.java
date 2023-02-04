package HundredEightyNineProblems.ArrayAndStrings.StringRotation;

import java.util.Arrays;
import java.util.HashSet;


public class Main {
   
    public static class TestCase {

        public String word;
        public String candidate;
        public boolean result;

        public TestCase (String word, String candidate, boolean result) {;
            this.word = word;
            this.candidate = candidate;
            this.result = result;
        }
    }

    static TestCase[] testCases = {
        new TestCase("abc", "cba", false),
        new TestCase("abc", "bca", true),
        new TestCase("waterbottle", "ewaterbottl", true),
        new TestCase("", "a", false),
        new TestCase("a", "", false),
        new TestCase("aaa", "aaaaaa", false),
        new TestCase("aaa", "aaa", true),
    };
    

    public static void main(String[] args) {

        Main main = new Main();
        for (int i = 0; i < testCases.length; i++) {
            TestCase currentCase = testCases[i];
            boolean result = main.Solution(currentCase.word, currentCase.candidate);

            if (result != currentCase.result) {
                System.out.println(String.format("Failed got:\n%s and %s\nexpected: %b", currentCase.word, currentCase.candidate, currentCase.result));
            }
            
        }

    }

    public boolean Solution(String word, String candidate) {
        if (word.length() != candidate.length()) return false;

        String yxyx = candidate + candidate;

        return yxyx.contains(word);
       

    }
}