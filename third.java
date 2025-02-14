import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(--t >= 0){
            int n = in.nextInt();
            char a[][] = new char[n][4];
            
            /* Storing the values of y c s and p manually beacuse we have to write all of the ingridents invlolved in it*/
            
            
            for(int i = 0; i < n; ++i){
                a[i][0] = in.next().charAt(0);
                if(a[i][0] == 'y'){
                    a[i][1] = 'o';
                    a[i][2] = 'b'; 
                    a[i][3] = '0';
                }else if(a[i][0] == 'c'){
                    a[i][1] = 'b';
                    a[i][2] = 't';
                    a[i][3] = '0';
                }else if(a[i][0] == 'p'){
                    a[i][1] = 'o';
                    a[i][2] = 't';
                    a[i][3] = '0';
                }else if(a[i][0] == 's'){
                    a[i][1] = 'o';
                    a[i][2] = 't';
                    a[i][3] = 'b';
                }
            }
            
            /* My approach: I am creating a hashmap and storing when was the last time an ingredient was used if it was used on (i-1)th element i am not increasing the steps, just updating the element on the map. If the ith element is combination of many ingredient I am checking for every individual component last used position and updating the hashmap accordingly*/
            
            HashMap<Character, Integer> map = new HashMap<>();
            int steps = 0;
            for(int i = 0; i < n; ++i){
                if(((a[i][0] == 'y' || a[i][0] == 's') || a[i][0] == 'c') || a[i][0] == 'p'){ //checking for p,y,c,s
                    
                    for(int j = 1; j < 4; ++j){
                        if(a[i][j] == '0'){ // i have stored 0 in case of c,y,p because they have only 2 ingredient
                            break;
                        }
                        if(map.containsKey(a[i][j])){ //checking if the ingredient was used before
                            if(map.get(a[i][j]) != i - 1){
                                ++steps;
                            } 
                           
                        }else{
                             
                            ++steps;
                        }
                         map.put(a[i][j],i); //updating the map
                    }
                }
                else if(map.containsKey(a[i][0])){
                    if(map.get(a[i][0]) != i - 1){
                        ++steps;
                    }
                    map.put(a[i][0],i); //updating the map
                } else{
                    map.put(a[i][0],i); //updating the map
                    ++steps;
                }
                
            }
            System.out.println(steps); //printing final answer
        }
        
    }
}
