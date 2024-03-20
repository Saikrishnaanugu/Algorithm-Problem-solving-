package src;
import java.util.*;
public class Task1 {
	public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int m = s.nextInt();
    	int n = s.nextInt();
    	int[][] stockvalue = new int[m][n];
    	for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
            	stockvalue[i][j] = s.nextInt();
        	}
    	}
    	findmaxprofit(m,n,stockvalue);
	}
    
	public static  void findmaxprofit(int m , int n ,int[][] stockvalue) {
    	int Curr_profit = 0;
    	int Temp_profit = 0;
    	int stock =0;
    	int buyday = 0;
    	int sellday =0 ;
    	for (int i = 0; i <= m - 1; i++) {
        	for (int j = 0; j <= n - 2; j++) {
            	for (int k = j + 1; k <= n - 1; k++) {
                	if (stockvalue[i][k] > stockvalue[i][j])
                    	Temp_profit = stockvalue[i][k] - stockvalue[i][j];
                	if (Temp_profit > Curr_profit) {
                    	Curr_profit = Temp_profit;
                    	stock = i;
                    	buyday = j;
                    	sellday = k;
                	}
            	}
        	}
    	}
    	System.out.println((stock+1)+" "+(buyday+1) +" "+(sellday+1));
	}
}