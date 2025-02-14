import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; ++i){
            a[i] = in.nextInt();
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i = 1; i < n; ++i){
            for(int j = 0; j < i; ++j){
                
            
            if(a[j] > a[i]){
                // System.out.println(i + " " + j);
                map.put(i,Math.max(map.getOrDefault(j,1)+1,map.getOrDefault(i,1)));
            }
            
            }
        }
        
        
        int max = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(max == -1){
                max = entry.getValue();
            }
            else if(entry.getValue() > max){
                max = entry.getValue();
            }
        }
        System.out.println(max);
        
    }
}
