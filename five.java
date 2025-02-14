import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(--t >= 0){
            int l = in.nextInt();
            int b = in.nextInt();
            int h = in.nextInt();
            LinkedList<Integer> list = new LinkedList<>();
            System.out.println(solve(l,b,h,list));
            double totalScrap= 0;
            for(int i = 0; i < list.size(); ++i){
                int length = list.get(i);
                double pi = (double)355/(double)113;
                double scrap = (Math.pow(length,3)*(6-pi))/6;
                totalScrap += scrap;
                
            }
            System.out.println((int)totalScrap);
        }
    }
    
    public static int solve(int l, int b, int h,LinkedList<Integer> list){
        if(l == b && b == h){
            list.add(b);
            return 1;
            
        }
        
        
        if((l != b && b != h) && l != h){
            //System.out.println(l + " " + b + " " + h);
            int max = max(l,b,h);
            int min = min(l,b,h);
            int med = med(l,b,h);
            return solve(min,min,min,list) + solve(max-min,min,min,list) + solve(med-min,max,min,list);
        }
        else if((l == b || b == h) || h == l){
            int temp = 0;
            int temp2 = 0;
            if(l == b){
                temp = l;
                temp2 = h;
            }else if(b == h){
                temp = b;
                temp2 = l;
            }else if(h == l){
                temp = h;
                temp2 = b;
            }
            
            if(temp > temp2){
                return solve(temp2,temp2,temp2,list) + solve(temp2,temp2,temp-temp2,list) + solve(temp2,temp,temp-temp2,list);
            }else{
                return solve(temp,temp,temp,list) + solve(temp,temp,temp2-temp,list);
            }
        }
        return 0;
    }
    
    public static int max(int l, int b, int h){
        if(l > b && l > h){
            return l;
        }else if (b > l && b > h){
            return b;
        }    
        return h;
    }
    
    public static int min(int l, int b, int h){
        if(l < b && l < h){
            return l;
        }else if (b < l && b < h){
            return b;
        }    
        return h;
    }
    
    public static int med(int l, int b, int h){
        if(l > b && l > h){
            if(b > h){
                return b;
            }else{
                return h;
            }
        }else if(b > l && b > h){
            if(l > h){
                return l;
            }else{
                return h;
            }
        }else{
            if(l > b){
                return l;
            }else{
                return b;
            }
        }
        
    }
    
}
