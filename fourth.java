import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(--t >= 0){
            int row = in.nextInt();
            int col = in.nextInt();
            int a[][] = new int[row][col];
            int ans[][] = new int[col][row];
            for(int i = 0; i < row; ++i){
                for(int j = 0; j < col; ++j){
                    a[i][j] = in.nextInt();
                }
            }
            
            int c = in.nextInt();
            
            //When mirror is at 0 and 2 the same algorithm is used as it gives the same result
            
            if(c == 0 || c == 2){
                int i = col - 1;
                for(int m = 0; m < col; ++m){
                    int j = row - 1;
                    
                    for(int k = 0; k < row; ++k){
                       // System.out.println(k + " " + m);
                        ans[i][j] = a[k][m]; 
                        
                        --j;
                        
                    }
                    --i;
                }
            }
            
            //When mirror is at 1 and 3 the same algorithm is used as it gives the same result
            
            if(c == 1 || c == 3){
                int i = col - 1;
                for(int m = col - 1; m >= 0; --m){
                    int j = row - 1;
                    
                    for(int k = row - 1; k >= 0; --k){
                       // System.out.println(k + " " + m);
                        ans[i][j] = a[k][m]; 
                        
                        --j;
                        
                    }
                    --i;
                }
            }
            for(int i = 0; i < col; ++i){
                for(int j = 0; j < row; ++j){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
