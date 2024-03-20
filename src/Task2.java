
package src;
import java.util.Scanner;
public class Task2{
	public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int m = s.nextInt();
    	int n = s.nextInt();
    	int[][] stockvalue  = new int[m][n];
    	for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
            	stockvalue[i][j] = s.nextInt();
        	}
    	}
    	Max_profit(m, n, stockvalue);
	}

	public static void Max_profit(int m, int n, int[][] stockvalue) {
    	int a = 0;
    	int stock =0;
    	int buyday = 0;
    	int sellday =0 ;
    	for (int i = 0; i < m ; i++) {
        	int MaxProfit = 0;
        	int MinPriceTillDate = stockvalue[i][0];
        	for (int j = 1; j < n ; j++) {
            	if (stockvalue[i][j] < MinPriceTillDate) {
                	MinPriceTillDate = stockvalue[i][j];
                	buyday = j;
            	}
            	int CurrentProfit = stockvalue[i][j] - MinPriceTillDate;
            	if (MaxProfit < CurrentProfit) {
                	MaxProfit = CurrentProfit;
                	sellday = j;
            	}
        	}
        	if (a < MaxProfit) {
            	a = MaxProfit;
            	stock = i;
        	}
    	}
    	System.out.println((stock+1)+" "+(buyday+1)+" "+(sellday+1));
	}
}
