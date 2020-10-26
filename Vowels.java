//Count the vowels

import java.util.Scanner;

class Solution {

	public static boolean isVowel(char ch) {
		return ch == 'A' || ch == 'E' ||
				ch == 'I' || ch == 'O' ||
				ch == 'U' || ch == 'a' || 
				ch == 'e' || ch == 'i' || 
				ch == 'o' || ch == 'u' ? true : false;
	}
	public static int countVowels(String string) {
		int count = 0;
		for(int i=0; i<string.length(); i++) {
			char ch = string.charAt(i);
			if(isVowel(ch)) {
				count++;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		System.out.println("Given String :- "+input);
		System.out.println("No. of vowels in string :- "+countVowels(input));
		scanner.close();
	}

}
