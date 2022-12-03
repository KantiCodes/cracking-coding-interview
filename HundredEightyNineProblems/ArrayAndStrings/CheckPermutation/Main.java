import java.util.HashMap;

public class Main {
    public static class Pair {
        private String l;
        private String r;
        public Pair(String l, String r){
            this.l = l;
            this.r = r;
        }
        public String getL(){ return l; }
        public String getR(){ return r; }
        public String toString() { return (this.l + this.r); }
    }   

    public static Pair[] trueCases = {
        new Pair("", ""),
        new Pair(" ", " "),
        new Pair("  ", "  "),
        new Pair("abc", "bca"),
        new Pair("abc", "bca"),
        new Pair("aaa", "aaa"),
        new Pair("bbaaaabb", "babababa"),
    };

    public static Pair[] falseCases = {
        new Pair("", "  "),
        new Pair("a", "aa"),
        new Pair("b", "a"),
        new Pair("abc", "bcca"),
        new Pair("cccc", "ccc"),
        new Pair("abcdef", "abcdefabcdef"),
        new Pair("", "  "),   
    };


    public static void main(String[] args) {
        Main main = new Main();
        final int tCaseLen = trueCases.length;
        final int fCaseLen = falseCases.length;
        
        boolean[] hashMapTrueResults = new boolean[tCaseLen];
        boolean[] hashMapFalseResults = new boolean[fCaseLen];


        for (int i=0; i<tCaseLen; i++) {
            // brutTrueResults[i] = main.BruteForce(trueCases[i]);
            hashMapTrueResults[i] = main.HashMapChars(trueCases[i]);

        }

        for (int i=0; i<fCaseLen; i++) {
            // brutFalseResults[i] = main.BruteForce(falseCases[i]);
            hashMapFalseResults[i] = main.HashMapChars(falseCases[i]);
        }

        // main.test(brutTrueResults, brutFalseResults, "brut");
        main.test(hashMapTrueResults, hashMapFalseResults, "hasmap");
    }

    public boolean HashMapChars(Pair p) {
        String word1 = p.getL();
        String word2 = p.getR();
        if (word1.length() != word2.length()) return false;
        System.out.println(String.format("Working on words: %s and %s", word1, word2));
        HashMap<Character, Integer> exists1 = new HashMap<>();
        HashMap<Character, Integer> exists2 = new HashMap<>();

        for (char c: word1.toCharArray()) {
            exists1.put(
                c,
                exists1.getOrDefault(c, 0) + 1
            );
        }
        for (char c: word2.toCharArray()) {
            exists2.put(
                c,
                exists2.getOrDefault(c, 0) + 1
            );
        }
        System.out.println(exists1.toString());
        System.out.println(exists2.toString());
        System.out.println(exists1.equals(exists2));
        return exists1.equals(exists2);
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
