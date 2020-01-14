package _13_backtracking;

import java.util.Arrays;

public class EightQueens {

    private static final int BOARD_SIZE = 8;

    private int solutionCount = 0;
    private int[] queenList = new int[BOARD_SIZE];

    public void eightQueens(int row) {
        if (row == BOARD_SIZE) {
            solutionCount++;
            System.out.println(Arrays.toString(queenList));
        } else {
            for (int i = 0; i < BOARD_SIZE; i++) {
                if (isValidPos(row, i)) {
                    queenList[row] = i;
                    eightQueens(row+1);
                }
            }
        }
    }

    private boolean isValidPos(int currRow, int currCol) {
        int i=0;
        while (i<currRow) {
            if (queenList[i] == currCol) return false;
            if (currRow-i == Math.abs(currCol-queenList[i])) return false;
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        var bean = new EightQueens();

        bean.eightQueens(0);

        System.out.println("\n--- solution count ---");
        System.out.println(bean.solutionCount);
    }
}
