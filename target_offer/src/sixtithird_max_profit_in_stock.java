public class sixtithird_max_profit_in_stock {
    public static void main(String[] args) {
        int[] prices = new int[]{9,11,8,5,7,12,16,14};
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            int current = getProfit(prices, i);
            if (max < current) {
                max = current;
            }
        }
        System.out.println(max);
    }
    public static int getProfit(int[] price, int index) {
        // recursive, max profit lasts in index
        if (price == null || price.length == 0 || index < 1 || index >= price.length) {
            return 0;
        }
        if (index == 1) {
            return price[1] - price[0];
        }

        // if index - 1 could be sell
        int pre = getProfit(price, index - 1);

        int current = pre + price[index] - price[index - 1];
        // if pre profit is smaller than current
        if (current < (price[index] - price[index - 1])) {
            return price[index] - price[index - 1];
        } else {
            return current;
        }
        // sell in current price
//        return pre + price[index] - price[index - 1];
    }
}
