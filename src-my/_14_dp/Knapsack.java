package _14_dp;

import java.util.Arrays;

public class Knapsack {

    static final int CAPACITY = 8;

    public int knapsack(int[] weights) {
        boolean[][] statusTable = new boolean[weights.length][CAPACITY + 1];
        statusTable[0][0] = true;
        statusTable[0][weights[0]] = true;
        for (int i = 1; i < weights.length; i++) {
            // 不放的情况
            for (int j = 0; j <= CAPACITY; j++) {
                if (statusTable[i - 1][j] == true) statusTable[i][j] = true;
            }
            // 放的情况
            for (int j = 0; j <= CAPACITY - weights[i]; j++) {
                if (statusTable[i - 1][j] == true) statusTable[i][j + weights[i]] = true;
            }
        }

        for (int i = CAPACITY; i >= 0; i--) {
            if (statusTable[weights.length - 1][i] == true) return i;
        }

        return -1;
    }

    public int knapsack1(int[] weights) {
        boolean[] statusTable = new boolean[CAPACITY + 1];
        statusTable[0] = true;
        statusTable[weights[0]] = true;

        for (int i = 1; i < weights.length; i++) {
            // 放的情况
            for (int j = 0; j <= CAPACITY - weights[i]; j++) {
                if (statusTable[j] == true) statusTable[j + weights[i]] = true;
            }
        }

        for (int i = CAPACITY; i >= 0; i--) {
            if (statusTable[i] == true) return i;
        }

        return -1;
    }

    public int knapsack2(int[] weights, int[] values) {
        int[][] statusTable = new int[weights.length][CAPACITY + 1];
        for (int i = 0; i < statusTable.length; i++) {
            Arrays.fill(statusTable[i], -1);
        }

        statusTable[0][0] = 0;
        statusTable[0][weights[0]] = values[0];

        for (int i = 1; i < weights.length; i++) {
            // 不放的情况
            for (int j = 0; j <= CAPACITY; j++) {
                if (statusTable[i - 1][j] > -1) statusTable[i][j] = statusTable[i - 1][j];
            }

            // 放的情况
            for (int j = 0; j <= CAPACITY - weights[i]; j++) {
                if (statusTable[i - 1][j] > -1) {
                    int v = statusTable[i - 1][j] + values[i];
                    if (v > statusTable[i][j + weights[i]]) {
                        statusTable[i][j + weights[i]] = v;
                    }
                }
            }
        }

        int maxValue = -1;
        for (int i = 0; i <= CAPACITY; i++) {
            maxValue = Math.max(maxValue, statusTable[weights.length - 1][i]);
        }

        for (int i = 0; i < weights.length; i++) {
            System.out.println(Arrays.toString(statusTable[i]));
        }

        return maxValue;
    }

    public static void main(String[] args) {
        var bean = new Knapsack();
        var weights = new int[]{3, 2, 1, 1, 4};
        var values = new int[]{5, 2, 4, 2, 10};

        System.out.println("--------knapsack maxWeight---------");
        System.out.println(bean.knapsack(weights));

        System.out.println("--------knapsack1 maxWeight---------");
        System.out.println(bean.knapsack1(weights));

        System.out.println("--------knapsack2 maxValue---------");
        System.out.println(bean.knapsack2(weights, values));
    }
}
