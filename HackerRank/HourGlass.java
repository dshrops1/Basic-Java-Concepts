/*
* Author: Dustin Shropshire
* 
* Problem : Given a 2D array 6x6 calculate all hourglass sums and return largest one 
*  Eg:  [x][x][x]
*          [x]
*		[x][x][x]
*
* Steps and considerations:
*
*	1)Calculate Array Summation size(how many hourglass's for the 2d array)
* 	2)Get all hour glass sums pushing onto sums array
*   3)Sort array
*	4)Return last index of sums
*
*   Calculation of each hourglass:
*		[[E-1][A-1]][[E-1][A]][[E-1][A+1]]
*					  [E[A]]
*		[[E+1][A-1]][[E+1][A]][[E+1][A+1]]
*
*
*	Start: [1][1]
*	loop through columns ending -1 row length
* 	loop through rows ending -1 column length
*
*	out loop increases => I < Arr.length -1
* 	Inner loop increases=>  J < Arr.length -1
*/
import java.util.*;

public class HourGlass{

	public static void main(String[] args){

		final int[][] arrToGive = new int[][]{ 
								 {-9, -9, -9, 1, 1, 1},
								 {0, -9, 0, 4, 3, 2},
								 {-9, -9, -9, 1, 2, 3},
								 {0, 0, 8, 6, 6, 0},
								 {0, 0, 0, 0, -2, 0, 0},
								 {0, 0, 1, 2, 4, 0}
								};

		
		System.out.println(largestSummation(arrToGive));
		  

								
	}

	//will return the largest hourglass sum
	private static int largestSummation(int[][] arr){

		//declare a local array for how many hour glass sums we will have using numberOfHourGlasses
		int[] hourGlassSums = new int[numberOfHourGlasses(arr)];
		
		int arrayPush = 0;
		
		for(int i = 1; i < arr.length -1; i++){

			for(int j = 1; j < arr.length -1; j++){


				//add sumation and push to hourGlassSums
				//based of algorithm stated above
				int sum = arr[i][j] + arr[i-1][j-1] + arr[i-1][j] + arr[i-1][j+1] + arr[i+1][j-1] + arr[i+1][j] + arr[i+1][j+1];
				hourGlassSums[arrayPush++] = sum;
			}
		}

		//sort the hourglass's array and return last index.

		Arrays.sort(hourGlassSums);


		return hourGlassSums[hourGlassSums.length-1];

		

	}

	//will return the number of possible hour glasses(called in largestSummation)
	private static int numberOfHourGlasses(int[][] arr){

				
			return ((arr.length - 2) * (arr.length -2));

	}
}

