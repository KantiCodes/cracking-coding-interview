package HundredEightyNineProblems.ArrayAndStrings.ZeroMatrix;

import java.util.Arrays;
import java.util.HashSet;


public class Main {
   
    public static class TestCase {

        public int[][] arr;
        public int[][] result;

        public TestCase (int[][] arr, int[][] result) {;
            this.arr = arr;
            this.result = result;
        }
    }

    static int [][][] data1 = {
        {
            {1,2,3},
            {0,2,1}
        },
        {
            {0,2,3},
            {0,0,0}
        }
    };

    static int [][][] data2 = {
        {
            {1,0,1}
        },
        {
            {0,0,0}
        }
    };


    static int [][][] data3 = {
        {
            {1,2,1},
            {3,0,5},
            {5,6,1}
        },
        {
            {1,0,1},
            {0,0,0},
            {5,0,1}

        }
    };
    static int [][][] data4 = {
        {
            {1,2,0},
            {3,9,5},
            {5,6,9}
        },
        {
            {0,0,0},
            {3,9,0},
            {5,6,0}
        },
    };

    static int [][][] data5 = {
        {
        },
        {
        },
    };
    
    static int[][][][] dataCases = {data1, data2, data3, data4};

    public static void main(String[] args) {
        TestCase[] testCases = new TestCase[dataCases.length];

        for (int i = 0; i < dataCases.length; i++) {
            int [][][] data = dataCases[i];
            testCases[i] = new TestCase(data[0], data[1]);
        }

        Main main = new Main();
        for (int i = 0; i < testCases.length; i++) {
            TestCase currentCase = testCases[i];
            int [][] result = main.Solution(currentCase.arr);

            if (!Arrays.deepEquals(result, currentCase.result)) {
                System.out.println(String.format("Failed got: %s, expected: %s", Arrays.deepToString(result), Arrays.deepToString(currentCase.result)));
            }
            
        }

    }

    public int [][] Solution(int [][] arr) {
        HashSet<Integer> cols = new HashSet<Integer>();
        HashSet<Integer> rows = new HashSet<Integer>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    cols.add(i);
                    rows.add(j);
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (cols.contains(i) || rows.contains(j)) {
                    arr[i][j] = 0;
                }
            }
        }

        return arr;

    }
}