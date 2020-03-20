/**
 * HW 4: RamSortnSelect
 * Written for CSCI 333, Prof. Adam Whitley
 * Implements  wrapped (nondestructive) Randomized Quickselect algorithm, with partition, swap, and wrapper methods.
 * Author:		Jesse Reeve
 * Contact: 	jreeve@unca.edu
 * Created:		2/12/2020
 * Modified:	2/15/2020
 */

import java.util.Arrays;
import java.util.Random;

public class randomizedQuickselect {

	static Random rand = new Random();
	static boolean DEBUG = false;
	
	/**
	 * Implements the randomized quickselect algorithm to find the value with order statistic i 
	 * (the i'th smallest element of A[]).
	 * Note that A[] must NOT have duplicate values for this algorithm to work correctly.
	 * @param A array to be searched
	 * @param p lower bound of the current subproblem
	 * @param r upper bound of the current subproblem
	 * @param i the target order statistic
	 * @return the value of the i'th order statistic
	 */
	private static int randomizedQuickselect(int[] A, int p, int r, int i) {
		if (p==r) {//base case: problem size 1
			return A[p];
		}//if
		int z = rand.nextInt(r-p)+p;
		swap(A,z,r);
		int q = partition(A,p,r);
		int k = q-p+1;
		if (i == k) {//base case:  we have fortunately found our answer
			return A[q];
		}//if
		else if (i < k){//look in the left bucket
			return randomizedQuickselect(A,p,q-1,i);
		}
		else return randomizedQuickselect(A,q+1,r,i-k);
	}//randomizedQuickselect

	/**
	 * A wrapper method for randomizedQuickselect that prevents it from changing the input array.
	 * @param A array to be searched
	 * @param p lower bound of the current subproblem
	 * @param r upper bound of the current subproblem
	 * @param i the target order statistic
	 * @return the value of the i'th order statistic
	 */
	static int randomizedQuickselectWrapper(int[] A, int p, int r, int i) {
		int[] temp = new int[A.length];
		temp = Arrays.copyOf(A, A.length);
		int orderStatistic = randomizedQuickselect(temp, p, r, i);
		return orderStatistic;
	}
	
	/**
	 * Implements the partition phase of the quicksort algorithm.
	 * 
	 * @param A int[] array to be sorted
	 * @param p first index in the range to be sorted
	 * @param r final index in the range to be sorted
	 * @return
	 */
	static int partition(int[]A, int p, int r) {
		int pivot = A[r];
		int i = p-1;
		for (int j=p; j<r;j++) {
			if (A[j] <= pivot) {
				i++;
				swap(A,i,j);
			}//if
		}//for
		swap(A,i+1,r);
		if (DEBUG) System.out.printf("Partition index is %d.\n", i+1);
		return (i+1);
	}//partition


	/**
	 * Swaps the values of two indices of an array.
	 * 
	 * @param A			the target int[] array
	 * @param index1	index of the first value
	 * @param index2	index of the second value
	 */
	static void swap(int[] A, int index1, int index2) {
//		if (DEBUG) System.out.printf("Now swapping A[%d] (%d) and A[%d] (%d)\n",index1, A[index1],index2,A[index2]);
		int temp = A[index1];
		A[index1] = A[index2];
		A[index2] = temp;
	}//swap
}
