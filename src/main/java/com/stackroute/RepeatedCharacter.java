package com.stackroute;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Stream;

public class RepeatedCharacter {

   	//Do not print anything other than what's expected/asked in problem
    public static void main(String[] args) {
   	//Use Scanner to get input from console
    	Scanner scanner=new Scanner(System.in);
    	String input=scanner.nextLine();
    	RepeatedCharacter.findRepeatedCharacter(input);
	}

	public static Character findRepeatedCharacter(String input) {
		Character res=0;
		Map<Character,Integer> count=new HashMap<>();
		if(input!=null) {
			input.replaceAll("\\s+", "");
			for(int i=0;i<input.length();i++) {
				if(!count.containsKey(input.charAt(i))) {
					count.put(input.charAt(i), 0);
				}
				else {
					count.put(input.charAt(i), count.get(input.charAt(i))+1);
				}
			}
			Stream<Entry<Character,Integer>> sorted=count.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()));
			Stream<Entry<Character,Integer>> sortedv=count.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()));
			res=sorted.findFirst().get().getKey();
			int val=sortedv.findFirst().get().getValue();
			if(val<1) {
				System.out.println("No characters repeated");
				return 0;
			}
		}
		else{
			System.out.println("No characters repeated");
			return 0;
		}
		System.out.println(res);
		return res;
	}
}