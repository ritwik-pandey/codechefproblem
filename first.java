import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt(); // testcase 
        in.nextLine();
        while(--t >= 0){
            String s = in.nextLine(); // String input
            if(s.length() <= 10){
                System.out.println(s); // printing string as it is because length is less than equal to 10
            }else{
                int count = s.length() - 2;
                /* printing last and first letter and the counting the digits in between using string.length() inbuilt          
                function */
                System.out.println(s.charAt(0) + "" + count + "" + s.charAt(s.length() - 1)); 
            }
        }
    }
}
