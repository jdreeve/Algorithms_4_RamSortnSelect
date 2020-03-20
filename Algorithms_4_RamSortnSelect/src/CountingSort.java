/**
 * HW 4: RamSortnSelect
 * Written for CSCI 333, Prof. Adam Whitley
 * Implements counting sort algorithm, with findMax method to find the highest value in the array.
 * Author:		Jesse Reeve
 * Contact: 	jreeve@unca.edu
 * Created:		2/12/2020
 * Modified:	2/15/2020
 */

import java.util.Arrays;

public class CountingSort {

	/**
	 * Implements the counting sort algorithm to sort an array of integers in linear time.
	 * @param A the array of integers to be sorted
	 * @param B will contain the sorted integers from A
	 * @param k the largest value in A
	 */
	static void countingSort(int[] A, int[] B, int k) {
		int[] C = new int[k+1];//Java default initializes array values to 0...
		Arrays.fill(C, 0);//but just in case
		for (int i=0; i <= A.length-1; i++) {
			C[A[i]]++;
		}//for
		for (int i=1; i <= k; i++) {
			C[i] = C[i] + C[i-1];
		}//for
		for (int i=A.length-1; i >= 0; i--) {
			B[C[A[i]]-1] = A[i];
			C[A[i]]--;
		}//for
	}//countingSort
	
	/**
	 * Returns the highest value in an array of integers.
	 * @param A array to be searched
	 * @return
	 */
	static int findMax(int[] A) {
		int max = A[0];
		for (int i = 1; i < A.length; i++) {
			if (A[i] > max) {
				max = A[i];
			}//if
		}//for
		return max;
	}
}
