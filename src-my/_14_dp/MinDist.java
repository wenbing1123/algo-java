package _14_dp;

import static _00_utils.Utils.max;
import static _00_utils.Utils.min;

//矩阵最短长度，包括文莱斯距离（表示两个字符串的差异大小），最长公共子序列（表示两个字符串相似程度）
public class MinDist {

    public int minDist(int[][] weights) {
        int m = weights.length, n = weights[0].length;
        int[][] table = new int[m][n];

        int sum=0;
        for(int i=0; i<m; i++) {
            table[i][0] = sum;
            sum += weights[i][0];
        }
        sum=0;
        for(int i=0; i<n ;i++) {
            table[0][i]=sum;
            sum += weights[0][i];
        }

        for(int i=1; i<m; i++) {
            for (int j=1;j<n;j++) {
                table[i][j] = weights[i][j] + Math.min(table[i-1][j], table[i][j-1]);
            }
        }

        return table[m-1][n-1];
    }

    // 返回最小差异
    public int lwst(String s, String t) {
        int m=s.length(), n=t.length();
        int[][] table = new int[m][n];
        for (int j=0; j<n;j++) { //第一行所有列
            if (s.charAt(0) == t.charAt(j)) table[0][j] = j;
            else if(j != 0) table[0][j] = table[0][j] + 1;
            else table[0][j] = 1;
        }
        for (int i=0; i<m; i++) { //第一列所有行
            if (s.charAt(i) == t.charAt(0)) table[i][0] = i;
            else if (i != 0) table[i][0] = table[i-1][0]+1;
            else table[i][0] = 1;
        }
        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    table[i][j] = min(table[i-1][j]+1, table[i][j-1]+1, table[i-1][j-1]);
                } else {
                    table[i][j] = min(table[i-1][j]+1, table[i][j-1]+1, table[i-1][j-1]+1);
                }
            }
        }
        return table[m-1][n-1];
    }

    // 返回最大相似
    public int lcs(String s, String t) {
        int m=s.length(), n=t.length();
        int[][] table = new int[m][n];
        for (int j=0; j<n;j++) { //第一行所有列
            if (s.charAt(0) == t.charAt(j)) table[0][j] = 1;
            else if(j != 0) table[0][j] = table[0][j];
            else table[0][j] = 0;
        }
        for (int i=0; i<m; i++) { //第一列所有行
            if (s.charAt(i) == t.charAt(0)) table[i][0] = 1;
            else if (i != 0) table[i][0] = table[i-1][0];
            else table[i][0] = 0;
        }
        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    table[i][j] = max(table[i-1][j], table[i][j-1], table[i-1][j-1]+1);
                } else {
                    table[i][j] = max(table[i-1][j], table[i][j-1], table[i-1][j-1]);
                }
            }
        }
        return table[m-1][n-1];
    }



    public static void main(String[] args) {
        var bean = new MinDist();

        int[][] weights = new int[][] {new int[]{1, 3, 5, 9}, new int[]{2, 1, 3, 4}, new int[]{5, 2, 6, 7}, new int[]{6, 8, 4, 3}};
        System.out.println(bean.minDist(weights));

        String s = "mitcmu";
        String t = "mtacnu";
        System.out.println(bean.lwst(s, t));
        System.out.println(bean.lcs(s, t));

        s = "kitten";
        t = "sitting";
        System.out.println(bean.lwst(s, t));
        System.out.println(bean.lcs(s, t));

        s = "flaw";
        t = "lawn";
        System.out.println(bean.lwst(s, t));
        System.out.println(bean.lcs(s, t));
    }
}
