import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        //allowed bribes per person = 2
        //bubble sort keeping track of position changes
        int temp;
        //can be used to count total sorts
        int timesSorted = 0;
        
        //to count if a entity has jumped to many times we will call another function
        // and pass both arrays and check distances , maybe?
        
        //to check if one has jumped to many times in the que we will have a seperate array
        // we will just incrememte that element every time it shifts 
        int[] jumps = new int[q.length];
        //fill them with zeros to start so we can just ++ value
        Arrays.fill(jumps, 0, jumps.length,0);
        
        while(!sorted(q)){
            
            for(int i = 0; i < q.length -1; i++){
                
                if(q[i] > q[i + 1]){
                    jumps[q[i] - 1]++;
                    timesSorted++;
                    temp = q[i +1];
                    q[i + 1] = q[i];
                    q[i] = temp;
                }
            }
        }
        
        boolean des = false;
        for(int i = 0; i < jumps.length ; i++){
            
            
                if(jumps[i] >= 3) des = true;
                ///otherwise return timesSorted 
            
        }
        
        //test case 1 with number 5 fails look through code and figure out why
        if(des){
            System.out.println("Too chaotic");
        }else{
            System.out.println(timesSorted);
        }
        
    }
    
    static boolean sorted(int[] arr){
        
        for(int i = 0; i < arr.length - 1; i++){
        
        if(arr[i] < arr[i + 1]){
            
            continue;    
        }else{
            
            return false;    
        }    
    }

    return true;
        
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
