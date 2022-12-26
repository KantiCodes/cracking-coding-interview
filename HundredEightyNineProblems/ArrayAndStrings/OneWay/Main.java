package HundredEightyNineProblems.ArrayAndStrings.OneWay;

import javax.naming.spi.DirStateFactory.Result;

public class Main {
    
    public static class Triplet {
        public String word1;
        public String word2;
        public boolean result;
        public Triplet (String word1, String word2, boolean result) {
            this.word1 = word1;
            this.word2 = word2;
            this.result = result;
        }
    }

    public static Triplet[] testCases = {

        new Triplet("", "a", true),
        new Triplet("", "", true),
        new Triplet("a", "", true),
        new Triplet("abc", "abcd", true),
        new Triplet("abc", "abd", true),
        new Triplet("pale", "bale", true),
        new Triplet("pale", "balee", false),
        new Triplet("abc", "abda", false),
        new Triplet("a", "aaaaaaaaaaa", false),
    };

    public static void main(String[] args) {
        Main main = new Main();

        for (Triplet testCase: testCases) {
            String word1 = testCase.word1;
            String word2 = testCase.word2;
            boolean expectedResult = testCase.result;
            boolean result = main.Solution(word1, word2);

            if (result != expectedResult) {
                System.out.println(String.format("Case failed for words: %s and %s, the expected value was: %b", word1, word2, expectedResult));
            }
        }
    }

    public boolean Solution(String word1, String word2) {
        if (Math.abs((word1.length() - word2.length())) > 1) return false;
        
        String longWord = (word1.length() >= word2.length()) ? word1 : word2;
        String shortWord = (word1.length() >= word2.length()) ? word2 : word1;
        if (longWord.length() == shortWord.length()) return IsOneReplaced(word1, word2);

        return IsOneInsertDelete(shortWord, longWord);
    }
    // Same length strings
    public boolean IsOneReplaced(String word1, String word2) {
        boolean seen = false;
        for (int i=0;i<word1.length();i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                if (seen) return false;
                seen = true;
            }
        }
        return true;
    }

    public boolean IsOneInsertDelete(String shortWord, String longWord) {
        int i = 0;
        int j = 0;
        while (i < shortWord.length()) {
            char cShort = shortWord.charAt(i);
            char cLong = longWord.charAt(j);
            if (cShort != cLong) {
                if (i != j) {
                    return false;
                }
                j++;
            }
            else {
                j++;
                i++;
            }
        }

        return true;
    }
}
