// input - filled in sudoku, 2-d array of ints
// rules: 9x9 grid, 1. every row 1-9 only once, 2. every col 1-9 only once, 3. 9 subgroups 1-9 only once
//
// method signature:
// boolean checkSudoku(int[][] sudoku)
//
// algorithm: checks the 3 rules: 3x nested for-loops
//   1. Check each column
//   2. Check each row
//   3. Check each subgroup (3x3)

public class JavaSudokuChecker {
    private static int [] [] sudoku = new int[] [] {
            {8,4,5,6,3,2,1,7,9},
            {7,3,2,9,1,8,6,5,4},
            {1,9,6,7,4,5,3,2,8},
            {6,8,3,5,7,4,9,1,2},
            {4,5,7,2,9,1,8,3,6},
            {2,1,9,8,6,3,5,4,7},
            {3,6,1,4,2,9,7,8,5},
            {5,7,4,1,8,6,2,9,3},
            {9,2,8,3,5,7,4,6,1}
    };

    private static boolean checkSudoku(int[][] sudoku) {
        // Check each row
        for (int j=0; j<9; j++) {
            boolean[] seenRowNum = new boolean[9];
            for (int i=0; i<9; i++) {
                seenRowNum[sudoku[i][j]-1] = true;
            }
            for (int x=0; x<9; x++) {
                if (!seenRowNum[x]) {
                    return false;
                }
            }
        }

        // Check each column
        for (int i=0; i<9; i++) {
            boolean[] seenColNum = new boolean[9];
            for (int j=0; j<9; j++) {
                seenColNum[sudoku[i][j]-1] = true;
            }
            for (int y=0; y<9; y++) {
                if (!seenColNum[y]) {
                    return false;
                }
            }
        }

        // Check each subgroup
        for (int iOffset=0; iOffset<3; iOffset++) {
            for (int jOffset=0; jOffset<3; jOffset++) {
                boolean[] seenSubgroupNum = new boolean[9];
                for (int i=0; i<3; i++) {
                    for (int j=0; j<3; j++) {
                        seenSubgroupNum[sudoku[i + (iOffset * 3)][j + (jOffset * 3)] - 1] = true;
                    }
                }
                for (int z=0; z<9; z++) {
                    if (!seenSubgroupNum[z]) {
                        return false;
                    }
                }
            }
        }
//        for (int subgroup=0; subgroup<9; subgroup++) {
//            boolean[] seenSubgroupNum = new boolean[9];
//            for (int i=(subgroup/3 * 3); i<((subgroup/3 * 3) + 3); i++) {
//                for (int j=((subgroup % 3) * 3); j<(((subgroup % 3) * 3) + 3); j++) {
//                    seenSubgroupNum[sudoku[i][j]-1] = true;
//                    System.out.print("i, j = " + i + ", " + j + "  ");
//                }
//                System.out.println();
//            }
//            for (int z=0; z<9; z++) {
//                if (!seenSubgroupNum[z]) {
//                    return false;
//                }
//            }
//        }
        return true;
    }

    public static void main(String args[]) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        System.out.println("This is the JavaSudokuChecker!");

        boolean result = checkSudoku(sudoku);
        System.out.println("Result = " + result);
    }
}
