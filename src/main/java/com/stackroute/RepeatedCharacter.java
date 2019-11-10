package com.stackroute;

import java.util.Scanner;

public class RepeatedCharacter {

   	//Do not print anything other than what's expected/asked in problem
    public static void main(String[] args) {
   	//Use Scanner to get input from console
    	Scanner s=new Scanner(System.in);
    	String input=s.nextLine();
    	RepeatedCharacter.findRepeatedCharacter(input);
	}

	public static Character findRepeatedCharacter(String input) {
		String input1=input.replaceAll("\\s+", "");
		//String input1=input.replaceAll("\\s+", "");
		char res=0;
		int[] counter=new int[26];
		char max=0;
		int maxNo=-1;
		if (input1!=null) {
			for(int i=0;i<input1.length();i++) {
				counter[input1.charAt(i)-'a'] = counter[input1.charAt(i)-'a']+1;
			}
			for(int i=25;i>=0;i--) {
				if(counter[i]>=maxNo) {
					maxNo=counter[i];
					max=(char) ('a'+i);
					res=max;
				}
			}
			System.out.println(res);
		}
		else{
			res=0;
			System.out.println("No characters repeated");
		}
		
		return res;
	}
}