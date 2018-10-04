import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
            
        //delcare empty array of size a.length 
        int[] shiftedArray = new int[a.length];
        //use loop
        for(int i = a.length -1; i >= 0; i--){
            
            //this works fine for first values but point is reached were we will check
            //if negative and then use absolute value and subtract that from length -1 and 
            //place there?
            //or will it be d - i in that case technically d + i where i would be negative?
            //what about 0 case
            if(i - d >= 0){
                 shiftedArray[i - d] = a[i];
            }else{
                
                shiftedArray[a.length + (i -d)] = a[i];
            }
        }
        //a.length-1 last element of a add to new array in position shifted
        //by amount of d compared to its previous array's position
        //form there move down each position in array doing the same
        return shiftedArray;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

