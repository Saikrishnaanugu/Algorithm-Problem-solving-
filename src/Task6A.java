package src;
import java.util.*;

import java.util.Scanner;
public class Task6A {
    public static void main(String []args)
    {



        Scanner myObj = new Scanner(System.in);
        int k = myObj.nextInt();
        int m =  myObj.nextInt();
        int n =  myObj.nextInt();

        int[][] price = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                price[i][j] = myObj.nextInt();
            }
        }





        int[][] dpP = new int[k+1][n];;
        int selling =0;
        for (int a = 0; a <= k; a++) dpP[a][0] = 0;
        for (int a = 0; a < n; a++) dpP[0][a] = 0;
        int [] arr1 = new int[m];
        Arrays.fill(arr1, -1);
        Deque<Integer> dsa = new LinkedList<>();
        Deque<Integer> din = new LinkedList<>();
        for(int r=1;r<=k;r++) {
            for(int s=1;s<n;s++) {int b=-1;
                if(r>s) continue;
                for(int t=0;t<m;t++) {
                    if(arr1[t]<dpP[r-1][s-1]-price[t][s-1]) arr1[t] = dpP[r-1][s-1]-price[t][s-1];
                    if(b< price[t][s]+arr1[t]) b = price[t][s]+arr1[t];
                }
                if(dpP[r][s-1]>  b) dpP[r][s] = dpP[r][s-1];
                else dpP[r][s] = b;

            }
        }
        for(int y = 0; y <= k; y++){
            for(int u = 0; u< n ;u++){
                System.out.print( dpP[y][u]);
            }
            System.out.print("\n");
        }
        System.out.println(dpP[k][n - 1]);


        int t = dpP.length - 1; int y = dpP[0].length - 1;
        while(true && t!=0 && y!=0) {
            if (dpP[t][y] == dpP[t][y-1]) y = y - 1;
            else {
                dsa.addFirst(y);
                int highestD[] = new int[price.length];
                for (int u = 0; u < price.length; u++) highestD[u] = dpP[t][y] - price[u][y];
                boolean temp = false;
                for (int c = y-1; c >= 0; c--) {
                    for (int p = 0; p < price.length; p++) {
                        for(int u = 0; u< price.length; u++) {
                            if ((dpP[t-1][c] - price[p][c] == highestD[u]) && ((dpP[t-1][c] + price[p][y]- price[p][c])==dpP[t][y])) {
                                t = t - 1;
                                y = c;
                                dsa.addFirst(y);
                                din.addFirst(u);
                                temp = true;
                                break;
                            }
                        }
                        if( temp == true) break;
                    }
                    if( temp == true) break;
                }
            }
        }
        while(!dsa.isEmpty()) {
            int st_ind = din.pollFirst();
            System.out.println((st_ind)+ " "+(dsa.pollFirst())+" "+(dsa.pollFirst()));
        }
    }
}