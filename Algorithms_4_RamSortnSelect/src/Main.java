/**
 * HW 4: RamSortnSelect
 * Written for CSCI 333, Prof. Adam Whitley
 * Tests Counting Sort and wrapped (nondestructive) Randomized Quickselect algorithms.
 * Author:		Jesse Reeve
 * Contact: 	jreeve@unca.edu
 * Created:		2/12/2020
 * Modified:	2/15/2020
 */

import java.util.Arrays;
import java.util.Random;


public class Main {

//************************************************//
	//***** Global variables and objects *****//
		
	static final int TEST_ARRAYS_NUM = 5;
	static final int TEST_ARRAYS_SIZE = 10;
	static final int TEST_ARRAYS_RANGE = 100;
	static Random rand = new Random();
			
//************************************************//
	
	public static void main(String[] args) {

		int[][] testArrays = new int[TEST_ARRAYS_NUM][TEST_ARRAYS_SIZE];
		System.out.printf("Welcome to Jesse Reeve's algorithm tester!\n");
		System.out.printf("The main method has static variables for number of test arrays, test array size, and range of values in test arrays.\n");
		System.out.printf("Happy grading!\n\n");
		System.out.printf("Creating %d arrays of %d integers each, range 0 to %d:\n",TEST_ARRAYS_NUM, TEST_ARRAYS_SIZE,TEST_ARRAYS_RANGE);
		for (int i=0; i<TEST_ARRAYS_NUM; i++) {
			for (int j=0; j<TEST_ARRAYS_SIZE; j++) {
				testArrays[i][j]=rand.nextInt(TEST_ARRAYS_RANGE);
			}//for
			System.out.printf("%s", Arrays.toString(testArrays[i]));
			System.out.println();
			System.out.println();
		}//for
		/*
			for (int i=0; i<TEST_ARRAYS_NUM; i++) {
				System.out.printf("Calling countingSort on test array %d.\n",i);
				System.out.printf("Array contents:\n%s\n", Arrays.toString(testArrays[i]));
				int max = CountingSort.findMax(testArrays[i]);
				System.out.printf("Maximum value: %d\n", max);
				int[] outputArray = new int[testArrays[i].length];
				CountingSort.countingSort(testArrays[i],outputArray,max);
				System.out.printf("Sorted array:\n%s\n", Arrays.toString(outputArray));
				System.out.println();
			}//for
*/
			for (int i=0; i<TEST_ARRAYS_NUM; i++) {
				System.out.printf("Calling randomizedQuickselect on test array %d.\n",i);
				System.out.printf("Array contents:\n%s\n", Arrays.toString(testArrays[i]));
				int orderStatistic = rand.nextInt(TEST_ARRAYS_SIZE-1) + 1;
				System.out.printf("Randomly choosing order statistic %d of %d\n", orderStatistic, TEST_ARRAYS_SIZE);
				int orderStatisticValue = randomizedQuickselect.randomizedQuickselectWrapper(testArrays[i],0,testArrays[i].length-1, orderStatistic);
				System.out.printf("Order statistic: %s\n", orderStatisticValue);
				System.out.printf("Array contents (should be unchanged):\n%s\n", Arrays.toString(testArrays[i]));
				System.out.printf("Calling countingSort on test array %d.\n",i);
				int max = CountingSort.findMax(testArrays[i]);
				System.out.printf("Maximum value: %d\n", max);
				int[] outputArray = new int[testArrays[i].length];
				CountingSort.countingSort(testArrays[i],outputArray,max);
				System.out.printf("Sorted array:\n%s\n", Arrays.toString(outputArray));
				if (outputArray[orderStatistic-1] == orderStatisticValue) 
					System.out.printf("Order statistic %d (value %d) is correctly located at index %d of %d (zero-indexed).\n", orderStatistic, orderStatisticValue, orderStatistic-1, outputArray.length-1);
				else 
					System.out.printf("ERROR: order statistic %d (value %d) not found in index %d of %d (zero-indexed).\n", orderStatistic, orderStatisticValue, orderStatistic-1, outputArray.length-1);
				System.out.println();
			}//for
		
	}//main
}
