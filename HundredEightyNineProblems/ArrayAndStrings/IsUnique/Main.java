public class Main {
    public static String[] trueCases = {"abc","a", "ab", "", "abcdegfs"};
    public static String[] falseCases = {"aa","aba", "abcc", "abcdefc"};
    public static void main(String[] args) {
        Main bf = new Main();
        final int tCaseLen = trueCases.length;
        final int fCaseLen = falseCases.length;
        
        boolean[] brutTrueResults = new boolean[tCaseLen];
        boolean[] brutFalseResults = new boolean[fCaseLen];

        for (int i=0; i<tCaseLen; i++) {
            brutTrueResults[i] = bf.isUniqueBruteForce(trueCases[i]);
        }

        for (int i=0; i<fCaseLen; i++) {
            brutFalseResults[i] = bf.isUniqueBruteForce(falseCases[i]);
        }

        bf.test(brutTrueResults, brutFalseResults);
    }

    public boolean isUniqueBruteForce(String word) {
        // for (char ch: "xyz".toCharArray()) {
        // }
        for (int i = 0; i<word.length(); i++) {
            for (int j=i+1; j<word.length(); j++)
            {
                if (word.charAt(i) == word.charAt(j)) return false;
            }
        }
        return true;
    }

    public void test(boolean[] trueRes, boolean[] falseRes) {
        for (int i=0; i<trueRes.length; i++) {
            Boolean tres = trueRes[i];
            System.out.println(String.format("Checking %d", i));
            if (!tres) System.out.println(String.format("Failed on True case: %d", i));
        }

        for (int i=0; i<falseRes.length; i++) {
            Boolean fres = falseRes[i];
            System.out.println(String.format("Checking %d", i));
            if (fres) System.out.println(String.format("Failed on False case: %d", i));
        }
    }

}
