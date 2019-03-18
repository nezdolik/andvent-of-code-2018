package cci.dimes;

import java.util.Arrays;

public class CoinsNWays {

  public int change(int amount, int[] coins) {
    if (amount == 0){
      return 1;
    }
    if (coins.length == 0){
      return 0;
    }
    Arrays.sort(coins);
    int[] memo = new int[amount+1];
    Arrays.fill(memo, -1);
    memo[0] = 1;
    return nWays(amount, coins, 0, memo);
  }

  public int nWays(int amount, int[] coins, int idx, int[] memo) {
    if (amount < 0 || idx >= coins.length){
      return 0;
    }
    if (memo[amount] != -1){
      return memo[amount];
    }
    int n = 0;
    for (int i = idx; i < coins.length; ++i){
      n += nWays(amount - coins[i], coins, i, memo);
    }
    memo[amount] = n;
    return n;
  }

  public static void main(String[] args) {
    /**
     * 3
     * [1,2]
     */
    CoinsNWays coinsNWays = new CoinsNWays();
    int[] coins = {1,2};
    System.out.println(coinsNWays.change(3, coins));
  }
}
