package src;
import java.util.*;

import java.lang.*;
import java.io.*;
public class Task3A{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] dp_priceofstock = new int[m][n];
        for (int r = 0; r < m; r++){
            for (int s = 0; s < n; s++){
                dp_priceofstock[r][s] = sc.nextInt();
            }
        }
        task3a(m,n,dp_priceofstock);
    }
    public static void task3a(int m, int n, int[][] Ar1){
        int ins = -1;
        int[] dp_stock = new int[3];
        dp_stock[0]=dp_stock[1]=dp_stock[2]=-1;
        int mp = -1;

        int[][] Dp_Mem= new int[m][n];

        for (int r = 0; r < m; ++r){
            int[] DP_MEM1 = new int[n];
            Arrays.fill(DP_MEM1,-1);
            DP_MEM1[0] = 0;
            int st = Fun1(n-1, DP_MEM1, Ar1[r] );
            Dp_Mem[r] = DP_MEM1;
        }
        mp = getDays(Dp_Mem, -1, -1, -1, dp_stock);
        System.out.println((dp_stock[0]+1)+" " +(dp_stock[1]+1)+" "+(dp_stock[2]+1));
    }
    public static int Fun1(int n, int[] ar2, int[] sp){
        if(ar2[n] == -1){
            if(0 > Fun1(n-1, ar2, sp) + sp[n] - sp[n-1])
                ar2[n] = 0;
            else
                ar2[n] = Fun1(n-1, ar2, sp) + sp[n] - sp[n-1];
        }
        return ar2[n];
    }
    public static int getDays(int[][] m1, int sbd, int ssd, int si,int[] s1){
        int tempMax = -1;
        int firstidx = -1;
        for(int q=0; q < m1.length; q++){
            for (int w=0; w < m1[q].length; w++){
                if(m1[q][w] == 0) firstidx = w;
                if(m1[q][w] > tempMax){
                    si = q;
                    tempMax = m1[q][w];
                    ssd = w;
                    sbd = firstidx;
                    s1[0] = q;
                    s1[1] = firstidx;
                    s1[2] = w;
                }
            }
        }
        return tempMax;
    }
}
