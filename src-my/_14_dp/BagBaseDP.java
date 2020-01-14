package _14_dp;

//01-bag 备忘录
public class BagBaseDP {

    static final int CAPACITY = 8;

    boolean[][] memo = new boolean[CAPACITY][CAPACITY+1];

    int maxWeight = Integer.MIN_VALUE;

    public void bag(int[] items, int i, int w) {
        if (w >= CAPACITY || i == items.length) {
            maxWeight = Math.max(maxWeight, w);
            return;
        }
        if (memo[i][w] == true) return;
        memo[i][w] = true;

        bag(items, i + 1, w); //不放当前物品
        if (w + items[i] <= CAPACITY) {
            bag(items, i + 1, w + items[i]); //放当前物品
        }
    }


    public static void main(String[] args) {
        var bean = new BagBaseDP();
        var weights = new int[]{3, 2, 1, 1, 4};
        bean.bag(weights, 0, 0);
        System.out.println("--------maxWeight---------");
        System.out.println(bean.maxWeight);
    }

}
