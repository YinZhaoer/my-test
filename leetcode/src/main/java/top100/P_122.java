package top100;

/**
 * 股票i买卖进阶版
 */
public class P_122 {

    public static void main(String[] args) {

    }

    public static int maxProfit(int[] prices) {
        int i=0;
        int sum=0;
        while (i<prices.length-1){
            int cur=prices[i];
            int next=prices[i+1];
            if(next-cur>0){
                sum+=next-cur;
            }
            i++;
        }
        return sum;
    }
}
