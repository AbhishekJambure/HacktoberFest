//Merge sort on Single Array

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

//Merge Sort Code

class Solution {

	public static void merge(int[] array, int l, int m, int r) {
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		// Create temp arrays 
		int L[] = new int[n1];
		int R[] = new int[n2];

		//Copy data to temp arrays
		for (int i = 0; i < n1; ++i)
			L[i] = array[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = array[m + 1 + j];

		// Merge the temp arrays 

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarry array
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				array[k] = L[i];
				i++;
			}
			else {
				array[k] = R[j];
				j++;
			}
			k++;
		}

		// Copy remaining elements of L[] if any 
		while (i < n1) {
			array[k] = L[i];
			i++;
			k++;
		}

		// Copy remaining elements of R[] if any 
		while (j < n2) {
			array[k] = R[j];
			j++;
			k++;
		}
	}

	public static void sort(int[] array, int l, int r) {
		if(l < r) {
			//Find middle of l and r
			int m = (l+r)/2;
			
			//Sort right and left
			sort(array, l, m);
			sort(array, m+1, r);
			
			//Merging array
			merge(array, l, m, r);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Integer> inputs = new ArrayList<Integer>();
		System.out.println("Note : To end input give -1 as input");
		while(scanner.hasNextInt()) {
			int num = scanner.nextInt();
			if(num == -1) {
				break;
			}
			inputs.add(num);
		}
		int array[] = new int[inputs.size()];
		Iterator<Integer> iterator = inputs.iterator();
		for(int i=0; i<inputs.size(); i++) {
			array[i] = iterator.next();
		}
		System.out.println("Original Array :- ");
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+"\t");
		}

		sort(array, 0, array.length-1);

		System.out.println("\nSorted Array using Merge Sort :- ");
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+"\t");
		}

		scanner.close();
	}
}
