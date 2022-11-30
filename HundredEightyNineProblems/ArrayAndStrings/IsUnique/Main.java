import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static String[] trueCases = {"abc","a", "ab", "", "abcdegfs"};
    public static String[] falseCases = {"aa","aba", "abcc", "abcdefc"};
    public static void main(String[] args) {
        Main main = new Main();
        final int tCaseLen = trueCases.length;
        final int fCaseLen = falseCases.length;
        
        boolean[] brutTrueResults = new boolean[tCaseLen];
        boolean[] hashMapTrueResults = new boolean[tCaseLen];
        boolean[] sortTrueResults = new boolean[tCaseLen];


        boolean[] brutFalseResults = new boolean[fCaseLen];
        boolean[] hashMapFalseResults = new boolean[fCaseLen];
        boolean[] sortFalseResults = new boolean[tCaseLen];


        for (int i=0; i<tCaseLen; i++) {
            brutTrueResults[i] = main.BruteForce(trueCases[i]);
            hashMapTrueResults[i] = main.HashMapChars(trueCases[i]);
            sortTrueResults[i] = main.SortCheckNeighbours(trueCases[i]);
            

        }

        for (int i=0; i<fCaseLen; i++) {
            brutFalseResults[i] = main.BruteForce(falseCases[i]);
            hashMapFalseResults[i] = main.HashMapChars(falseCases[i]);
            sortFalseResults[i] = main.SortCheckNeighbours(falseCases[i]);
        }

        main.test(brutTrueResults, brutFalseResults, "brut");
        main.test(hashMapTrueResults, hashMapFalseResults, "hasmap");
        main.test(sortTrueResults, sortFalseResults, "sort");
    }

    public boolean BruteForce(String word) {
        for (int i = 0; i<word.length(); i++) {
            for (int j=i+1; j<word.length(); j++)
            {
                if (word.charAt(i) == word.charAt(j)) return false;
            }
        }
        return true;
    }

    public boolean HashMapChars(String word) {
        HashMap<Character, Boolean> exists = new HashMap<>();
        for (char c: word.toCharArray()) {
            if (exists.containsKey(c)) return false;
            exists.put(c, true);
        }
        return true;
    }

    public boolean SortCheckNeighbours(String word) {
        char[] charWord = word.toCharArray();
        Arrays.sort(charWord);
        for (int i = 0; i < charWord.length - 1; i++) {
            if (charWord[i] == charWord[i+1]) return false;
        }
        return true;
    }

    public void test(boolean[] trueRes, boolean[] falseRes, String solutionName) {
        System.out.println(String.format("Testing %s", solutionName));
        for (int i=0; i<trueRes.length; i++) {
            Boolean tres = trueRes[i];
            // System.out.println(String.format("Checking %d", i));
            if (!tres) System.out.println(String.format("Failed on True case: %s", trueCases[i]));
        }

        for (int i=0; i<falseRes.length; i++) {
            Boolean fres = falseRes[i];
            // System.out.println(String.format("Checking %d", i));
            if (fres) System.out.println(String.format("Failed on False case: %s", falseCases[i]));
        }
    }

}
