//Find join of two sequences S1 and S2

import java.util.Scanner;

class Solution {
	
	//Function to give next term of sequence
	public static int getDigitSum(int x) {
		int sum = 0;
		while(x > 0) {
			sum += x%10;
			x /= 10;
		}
		return sum;
	}
	
	public static int findJoin(int s1, int s2) {
		int counter = 0;
		while(s1 != s2) {
			if(s1 < s2) {
				if(s1 == 0) {
					//If s1 is 0
					return -1;
				}
				//If s1 < s2, get next term of s1 sequence
				s1 += getDigitSum(s1);
			}
			else if(s1 > s2) {
				if(s2 == 0) {
					//If s2 is 0
					return -2;
				}
				//If s2 < s1, get next term of s2 sequence
				s2 += getDigitSum(s2);
			}
			counter++;
			if(counter == 100) {
				//If there is no join then this will reach till max 100 loops
				return 0;
			}
		}
		return s1;
	}
	
	public static void main(String[] args) {
		Scanner scanner =  new Scanner(System.in);
		
		//Taking input
		System.out.println("Enter S1 : ");
		int s1 = scanner.nextInt();
		System.out.println("Enter S2 : ");
		int s2 = scanner.nextInt();
		
		//Finding join
		System.out.println("Note : \nIf there is no join then it will show 0."
				+ "\nIf S1 is 0 it will show -1."
				+ "\nIf S2 is 0 it will show -2.");
		int joint = findJoin(s1, s2);
		System.out.println("Joint of given two sequences : "+joint);
		
		scanner.close();
	}
}
