#include<stdio.h>
#include<string.h>
#include<ctype.h>

//Function to check wheather it is anagram or not
int isAnagram(char st1[50], char st2[50]) {
	int result = 1;
	//Calculating string lengths
	int n1 = strlen(st1);
	int n2 = strlen(st2);
	
	//If string lengths are not equal then it is not anagram
	if(n1 != n2) {
		result = -1;
	}
	//Else condition that the strings might be anagram
	else {
		int flag = 0;
		for(int i=0; i<n1; i++) {
			char p = st1[i];
			for(int j=0; j<n2; j++) {
				char q = st2[j];
				if(p == q && (p != '\0' && q != '\0')) {
					flag = 1;
					break;
				} 
			}
			if(flag == 1) {
				result = 1;
				flag = 0;
			}
			else {
				result = -1;
				break;
			}
		}
	}
	return result;
}
int main() {
	//Declared strings to use
	char str1[50], str2[50];
	
	//Input String 1
	printf("Input String1 : ");
	fgets(str1, 50, stdin);
	//To lowercase the string 1
	for(int i = 0; str1[i]!='\0'; i++){
		str1[i] = tolower(str1[i]);
	}
	printf("String1 is %s", str1);
	
	//Input String 2
	printf("Input String2 : ");
	fgets(str2, 50, stdin);
	//To lowercase the string 2
	for(int i = 0; str2[i]!='\0'; i++){
		str2[i] = tolower(str2[i]);
	}
	printf("String2 is %s", str2);
	
	//To check whether it is anagram or not
	if(isAnagram(str1, str2) > 0) {
		printf("It is Anagram.\n");
	}
	else {
		printf("It is not Anagram.\n");
	}
	return 0;
}
