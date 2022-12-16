package HundredEightyNineProblems.ArrayAndStrings.URLify;

import java.util.Arrays;

public class Main {
   
    public static class Triplet {
        public String word;
        public int unchangedLength;
        public int secretRealStringLength;

        public Triplet (String word, int unchangedLength, int secretRealStringLength) {
            this.word = word;
            this.unchangedLength = unchangedLength;
            this.secretRealStringLength = secretRealStringLength;
        }
    }

    public static Triplet[] cases = {
        // Some of these spaces at the end are redundant.

        // The last character index is 'c' and is on the index number 4
        // That means that the unchangedLength is  equal to: index + 1 = 4 + 1
        // We have two spaces so the realStringLenght (after substitution with %20) is:
        //      unchangedLength + number of spaces * 2:
        //          5 + 2 * 2 = 9
        new Triplet("a b c            ", 5, 9),
        // Last character 'b', index: 3
        // We have 2 spaces
        //          4 + 4 = 8
        new Triplet("a  b          ", 4, 8),
        // Last character 'e', index 10
        // We have 1 space
        //      11 + 2 + = 13, which also happens to be the original string length here as there is no training spaces
        new Triplet("hello there  ", 11, 13),
        
        new Triplet("Mr John Smith    ", 13, 17),
        new Triplet("Mr John Smith                         ", 13, 17),
        new Triplet("asd", 3, 3)

    };

    public static String[] expectedResults = {
        "a%20b%20c",
        "a%20%20b",
        "hello%20there",
        "Mr%20John%20Smith",
        "Mr%20John%20Smith",
        "asde"
    };

    public static char[][] results = new char[cases.length][100];

    public static void main(String[] args) {
        Main main = new Main();
        final int tCaseLen = cases.length;
        for (int i = 0; i < tCaseLen; i++) {
            // In order to change a space to %20 we need to allocate 3 extra spaces but one is already there - the space itself
            Triplet currentCase = cases[i];
            char [] word = main.Solution(currentCase.word.toCharArray(), currentCase.unchangedLength);
            results[i] = Arrays.copyOfRange(word, 0, currentCase.secretRealStringLength);
        }

        main.Test(results, expectedResults);

    }

    public char[] Solution(char[] word, int unchangedLength) {
        int lastCharacterIndex = unchangedLength - 1;

        int spacesNumber = 0;
        // We count only until the "end" of the string excluding trailing spaces
        for (int j=0; j< unchangedLength; j++) {
            if (word[j] == ' ') {
                spacesNumber++;
            }
        }

        int realStringLength = unchangedLength + spacesNumber * 2;
        int currentPosition = realStringLength - 1;
        System.out.println(String.format("Real string length: %d", realStringLength));
        for (int j=lastCharacterIndex; j>=0; j--) {
            System.out.println(word);
            if (word[j] == ' ') {
                word[currentPosition] = '0';
                word[currentPosition-1] = '2';
                word[currentPosition-2] = '%';
                currentPosition -= 3;
            }
            else {
                word[currentPosition] = word[j];
                currentPosition --;
            }
        }
        return word;
    }
    public void Test(char[][] results, String[] expectedResults) {
        for (int i=0; i<results.length; i++) {
            char[] myResult = results[i];
            char[] expectedResult = expectedResults[i].toCharArray();
            if (!Arrays.equals(myResult, expectedResult)) {
                System.out.println(String.format("Failed for: %s, expected: %s", Arrays.toString(myResult), Arrays.toString(expectedResult)));
            }
            else {
                System.out.println(String.format("good case: %s", Arrays.toString(myResult)));
            } 
        }
    }
}