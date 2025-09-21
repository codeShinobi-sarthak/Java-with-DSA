package dynamicPrograming.buy_and_sell_stock_problems;

public class BestTimeToBuySellStockIII {
    // Method 1: Dynamic Programming with States
    // Time: O(n), Space: O(1)
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        // State variables - tracking best profit at each state
        int firstBuy = -prices[0];   // Max profit after first buy
        int firstSell = 0;            // Max profit after first sell
        int secondBuy = -prices[0];   // Max profit after second buy
        int secondSell = 0;           // Max profit after second sell

        for (int i = 1; i < prices.length; i++) {
            // Working backwards from final state
            secondSell = Math.max(secondSell, secondBuy + prices[i]);
            secondBuy = Math.max(secondBuy, firstSell - prices[i]);
            firstSell = Math.max(firstSell, firstBuy + prices[i]);
            firstBuy = Math.max(firstBuy, -prices[i]);
        }

        return secondSell;
    }

    // Method 2: Divide and Conquer Approach (More Intuitive)
    // Time: O(n), Space: O(n)
    public int maxProfitDivideConquer(int[] prices) {
        int n = prices.length;
        if (n <= 1) return 0;

        // leftProfit[i] = max profit from day 0 to i (first transaction)
        int[] leftProfit = new int[n];
        int minPrice = prices[0];

        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            leftProfit[i] = Math.max(leftProfit[i - 1], prices[i] - minPrice);
        }

        // rightProfit[i] = max profit from day i to n-1 (second transaction)
        int[] rightProfit = new int[n];
        int maxPrice = prices[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            rightProfit[i] = Math.max(rightProfit[i + 1], maxPrice - prices[i]);
        }

        // Find the day to split for maximum total profit
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, leftProfit[i] + rightProfit[i]);
        }

        return maxProfit;
    }

    // Method 3: Generalized for K transactions (when K=2)
    // Time: O(n*k), Space: O(k)
    public int maxProfitGeneralized(int[] prices, int k) {
        if (prices.length == 0) return 0;
        k = 2; // For this problem

        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];

        // Initialize buy states
        for (int i = 0; i <= k; i++) {
            buy[i] = -prices[0];
        }

        for (int price : prices) {
            for (int j = k; j > 0; j--) {
                sell[j] = Math.max(sell[j], buy[j] + price);
                buy[j] = Math.max(buy[j], sell[j - 1] - price);
            }
        }

        return sell[k];
    }

    public static void main(String[] args) {
        BestTimeToBuySellStockIII solution = new BestTimeToBuySellStockIII();

        // Test Case 1: [3,3,5,0,0,3,1,4]
        int[] prices1 = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println("Test 1: " + solution.maxProfit(prices1)); // 6
        // Buy at 0, sell at 3 (+3), buy at 1, sell at 4 (+3) = 6

        // Test Case 2: [1,2,3,4,5]
        int[] prices2 = {1, 2, 3, 4, 5};
        System.out.println("Test 2: " + solution.maxProfit(prices2)); // 4
        // Buy at 1, sell at 5 = 4 (only one transaction needed)

        // Test Case 3: [7,6,4,3,1]
        int[] prices3 = {7, 6, 4, 3, 1};
        System.out.println("Test 3: " + solution.maxProfit(prices3)); // 0
        // No profit possible

        // Visualizing the state transitions
        demonstrateStateTransitions();
    }

    private static void demonstrateStateTransitions() {
        System.out.println("\n=== State Transition Visualization ===");
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};

        int firstBuy = -prices[0];
        int firstSell = 0;
        int secondBuy = -prices[0];
        int secondSell = 0;

        System.out.println("Initial: firstBuy=" + firstBuy + ", firstSell=" + firstSell +
                ", secondBuy=" + secondBuy + ", secondSell=" + secondSell);

        for (int i = 1; i < prices.length; i++) {
            int prevFirstBuy = firstBuy;
            int prevFirstSell = firstSell;
            int prevSecondBuy = secondBuy;

            secondSell = Math.max(secondSell, secondBuy + prices[i]);
            secondBuy = Math.max(secondBuy, firstSell - prices[i]);
            firstSell = Math.max(firstSell, firstBuy + prices[i]);
            firstBuy = Math.max(firstBuy, -prices[i]);

            System.out.println("Day " + i + " (price=" + prices[i] + "):");
            System.out.println("  firstBuy: " + prevFirstBuy + " -> " + firstBuy);
            System.out.println("  firstSell: " + prevFirstSell + " -> " + firstSell);
            System.out.println("  secondBuy: " + prevSecondBuy + " -> " + secondBuy);
            System.out.println("  secondSell: " + secondSell);
        }
    }
}

