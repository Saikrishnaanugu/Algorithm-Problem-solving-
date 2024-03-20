package src;
import java.util.*;


public class Task3B {
            public static void main(String[] args) {
            Scanner s = new Scanner(System.in);
            int m = s.nextInt();
            int n = s.nextInt();
            int[][] stockvalue  = new int[m][n];
            for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                        stockvalue [i][j] = s.nextInt();
            }
            }
            functionProfit(m, n, stockvalue);
            }
            public static void functionProfit(int m, int n, int[][] stockvalue) {
            int a = 0;
            int stock =0;
            int buyday = 0;
            int sellday =0 ;
            for (int i = 0; i < m; i++) {
            int max_Profit = 0;
            int[] OPT = new int[n];
            int smallest = stockvalue [i][0];
            for (int d = 1; d < n; d++) {
                        OPT[d] = Math.max(OPT[d - 1], stockvalue [i][d] - smallest);
                        if( OPT[d - 1]> stockvalue [i][d] - smallest ) buyday = d;
                        smallest = Math.min(smallest, stockvalue[i][d]);
                        sellday = d;
            }
            max_Profit = OPT[OPT.length - 1];
            if(a<max_Profit){
                        a = max_Profit;
                        stock = i;
            }
            }
            System.out.println((stock+1)+" "+(buyday+1)+" "+(sellday+1));
            }
}
 
