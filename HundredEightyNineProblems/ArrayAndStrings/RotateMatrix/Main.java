package HundredEightyNineProblems.ArrayAndStrings.RotateMatrix;

import java.util.Arrays;

public class Main {
    public static class Pair{
        public int[][] matrix;
        public int[][] result;

        public Pair(int[][] matrix, int[][] result) {
            this.matrix = matrix;
            this.result = result;
        }
    }

        static int[][] m0 = {
            {1 , 2 , 3 , 4 , 5 },
            {6 , 7 , 8 , 9 , 10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25},
        };
        
        static int [][] r0 = {
            {21, 16, 11, 6, 1},
            {22, 17, 12, 7, 2},
            {23, 18, 13, 8, 3},
            {24, 19, 14, 9, 4},
            {25, 20, 15, 10, 5},
        };

        static int[][] m1 = {
            {1,  2,  3,  4 },
            {5,  6,  7,  8 },
            {9,  10, 11, 12},
            {13, 14, 15, 16}

        };
        
        static int [][] r1 = {
            {13, 9 , 5 , 1},
            {14, 10, 6 , 2},
            {15, 11, 7 , 3},
            {16, 12, 8,  4}

        };

        static int [][] m2 =  {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        static int [][] r2 =  {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};

        static int [][] m3 =  {{1}};
        static int [][] r3 =  {{1}};

        public static Pair[] testCases = {
            new Pair(m0, r0),
            new Pair(m1,r1),
            new Pair(m2,r2),
            new Pair(m3,r3)
        };

        public static void main(String[] args) {

            Main main = new Main();
            for (Pair testCase: testCases) {
                System.out.println(String.format("Doing: %s", Arrays.deepToString(testCase.matrix)));
                int[][] result = main.Solution(testCase.matrix);
                if (!Arrays.deepEquals(result,testCase.result)) {
                    System.out.println(String.format("Failed got: %s, expected: %s", Arrays.deepToString(result), Arrays.deepToString(testCase.result)));
                }
            }
        }


    public int[][] Solution(int[][] matrix) {
        int N = matrix.length;
        
        for (int row_idx=0;row_idx < N/2; row_idx++) {
            for (int val_idx=row_idx; val_idx < N - row_idx-1; val_idx ++) {

                int top = matrix[row_idx][val_idx];
                
                // top <- left
                matrix[row_idx][val_idx] = matrix[N - 1 - val_idx][row_idx];
    
                // left <- bottom
                matrix[N - 1 - val_idx][row_idx] = matrix[N - 1 - row_idx][N - 1 - val_idx];
    
    
                // botton <- right
                matrix[N - 1 - row_idx][N - 1 - val_idx] = matrix[val_idx][N - 1 - row_idx];
    
                // # right <- top (original)
                matrix[val_idx][N - 1 - row_idx] = top;

            }

        }
        return matrix;

    }
}

