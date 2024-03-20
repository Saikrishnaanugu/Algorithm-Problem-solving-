
package src;
import java.util.*;
import java.lang.*;
import java.io.*;

import java.util.Scanner;
public class Task5
{
    public static void main (String[] args)
    {
        Scanner myObj = new Scanner(System.in);
        int K_Tran = myObj.nextInt();
        int m =  myObj.nextInt();
        int n =  myObj.nextInt();

        int[][] price = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                price[i][j] = myObj.nextInt();
            }
        }


        int[][] Dp_pro = new int[K_Tran+1][n];
        for (int r = 0; r <= K_Tran; r++) Dp_pro[r][0] = 0;
        for (int s = 0; s < n; s++) Dp_pro[0][s] = 0;
        int Highest_pro;
        for (int t = 1; t <= K_Tran; t++){
            for (int s = 1; s < n; s++){Highest_pro = 0;
                for (int u = 0; u < s; u++){
                    for(int r=0;r<price.length;r++){
                        if((price[r][s] - price[r][u] + Dp_pro[t - 1][u]) > Highest_pro){
                            Highest_pro = Dp_pro[t - 1][u] + price[r][s] - price[r][u];
                        }
                        if(Highest_pro > Dp_pro[t][s - 1])
                            Dp_pro[t][s] = Highest_pro;
                        else
                            Dp_pro[t][s] = Dp_pro[t][s - 1];
                    }
                }
            }
        }
        int r=n-1;
        int t=0;
        boolean temp= false;
        while(t<K_Tran && t>=0 && r>0){
            while(Dp_pro[K_Tran][r]==Dp_pro[K_Tran][r-1]) r--;
            int qqq = r;
            int[] ar1 = new int[m];
            int[] ar2 = new int[m];
            for(int x=0; x<m; x++) ar1[x] = Dp_pro[K_Tran][r]-price[x][r];
            for(int y=0; y<m; y++) ar2[y]=Dp_pro[K_Tran-1][r-1]-price[y][r-1];
            for (int z = 0; z < m; z++) {
                if (ar1[z] == ar2[z]) {
                    int b = r-1;
                    System.out.print("\n" + z+" "+b);
                    temp=true;
                    break;
                }
            }

            int u=r-1;
            while(temp==false){
                u--;
                for(int y=0; y<m; y++) ar2[y]=Dp_pro[K_Tran-1][u]-price[y][u];
                for (int z = 0; z < m; z++) {
                    if (ar1[z] == ar2[z]) {
                        temp=true;
                        System.out.print("\n" + z+" " + (u));
                    }
                }
            }System.out.print(" "+r);
            t++;
            r--;
        }
    }
}