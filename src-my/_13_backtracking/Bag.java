package _13_backtracking;

//01-bag
public class Bag {

    static final int CAPACITY = 8;

    static class Tuple {
        int weight;
        int value;

        Tuple(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    private int maxValue = Integer.MIN_VALUE;

    public int getMaxValue() {
        return maxValue;
    }

    public void bag(Tuple[] items, int i, int w, int v) {
        if (w >= CAPACITY || i == items.length) {
            maxValue = Math.max(maxValue, v);
            return;
        }

        bag(items, i + 1, w, v); //不放当前物品
        if (w + items[i].weight <= CAPACITY) {
            bag(items, i + 1, w + items[i].weight, v + items[i].value); //放当前物品
        }
    }

    public static void main(String[] args) {
        var bean = new Bag();

        var items = new Tuple[]{new Tuple(3, 5), new Tuple(2, 2), new Tuple(1, 4), new Tuple(1, 2), new Tuple(4, 10)};
        bean.bag(items, 0, 0, 0);
        System.out.println("--------maxValue---------");
        System.out.println(bean.getMaxValue());
    }
}
