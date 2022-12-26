package HundredEightyNineProblems.ArrayAndStrings.StringCompression;

public class Main {
    public static class Pair{
        public String word;
        public String result;

        public Pair(String word, String result) {
            this.word = word;
            this.result = result;
        }

        public static Pair[] testCases = {
            new Pair("abc", "abc"),
            new Pair("aaabc", "aaabc"),
            new Pair("aabbcc", "aabbcc"),
            new Pair("aabbbccdeeee", "a2b3c2d1e4"),
            new Pair("aaaaabbbb", "a5b4"),
            new Pair("aaaaabbbbcccdee", "a5b4c3d1e2")

        };
        public static void main(String[] args) {
            Main main = new Main();
            for (Pair testCase: testCases) {
                String result = main.Solution(testCase.word);
                if (!result.equals(testCase.result)) {
                    System.out.println(String.format("Failed for %s, got: %s, expected: %s", testCase.word, result, testCase.result));
                }
            }
        }
    }


    public String Solution(String word) {
        int count = 1;
        char lastChar = word.charAt(0);

        StringBuilder s = new StringBuilder(2*word.length());
        s.append(lastChar);

        for (char c: word.substring(1, word.length()).toCharArray()) {
            if (lastChar == c) {
                count ++;
            }
            
            else {
                s.append(count);
                s.append(c);
                lastChar = c;
                count = 1;
            }
        }
        s.append(count);
        if (s.length() >= word.length()) return word;
        return s.toString();
    }
}
