package com.stackroute;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class RepeatedCharacter {

   	//Do not print anything other than what's expected/asked in problem
    public static void main(String[] args) {
   	//Use Scanner to get input from console
    	Scanner scanner=new Scanner(System.in);
    	String input=scanner.nextLine();
    	Character result=RepeatedCharacter.findRepeatedCharacter(input);
        System.out.println(result);
    	scanner.close();
	}

	public static Character findRepeatedCharacter(String input) {
		HashMap<Character, Integer> charCount=new HashMap<>();
        if(input==null||input.isEmpty()) {
                        return '0';
        }
        char[] charArray=input.toCharArray();
       
        for (char c : charArray) {
                        if(charCount.containsKey(c)) {
                                        charCount.put(c, charCount.get(c)+1);
                        }
                        else {
                                        charCount.put(c, 1);
                        }
        }
       
        int maxCount=0;
        char maxChar = 0;
        for (Map.Entry<Character, Integer> countCheck : charCount.entrySet()) {
                        if(countCheck.getValue()>maxCount) {
                                        maxCount=countCheck.getValue();
                                        maxChar=countCheck.getKey();
                        }
                        else if(countCheck.getValue()==maxCount) {
                                        if(countCheck.getKey()<maxChar) {
                                                        maxCount=countCheck.getValue();
                                                        maxChar=countCheck.getKey();
                                        }
                        }
        }
        if(maxCount==1) {
                        return '0';
        }
        return maxChar;
	}
}