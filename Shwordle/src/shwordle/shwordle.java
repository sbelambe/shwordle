package shwordle;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Wordle game
 * @author shivani
 *
 */
public class shwordle {

	public static String words[] = new String[1];
	public static int rand = (int) (Math.random() *663 + 1);
	public static boolean go = true;
	
	public static void main(String[] args) throws IOException {
		
		/**
		 * Printing a random word from file
		 */
		String line = Files.readAllLines(Paths.get("/Users/shivani/git/shwordle/Shwordle/src/shwordle/5letterwords")).get(rand-1);
		words[0] = line;
		System.out.println(rand);
		
		/**
		 * Taking in word generated by player and using match method to print results
		 */
		Scanner scan = new Scanner(System.in);
		int num = 1;
		while(go && num<7) {
			System.out.print("Enter your word: ");
			String inputWord = scan.nextLine();
			if(inputWord.length() < 6) {
				System.out.println(match(inputWord));
				num++;
			}
			else {
				System.out.println("Try again");
			}
		}
	}
	
	/**
	 * The match method compares inputed word to randomly chosen word in list
	 * @param input of user
	 * @return results of comparison to correct word
	 */
	public static StringBuffer match(String input) {

		StringBuffer sb = new StringBuffer();
		
		ArrayList<Character> al = new ArrayList<Character>();
		for(int k=0; k<5; k++) {
			al.add(words[0].charAt(k));
		}
		
		for (int i=0; i<5; i++) {
			if(al.contains(input.charAt(i))) {
				if (input.charAt(i) == words[0].charAt(i)) {
					 sb.append("y");
				}
				else {
					sb.append("*");
				}
			}
			else {
				sb.append("n");
			}
		}
		
		if("yyyyy".contentEquals(sb)) {
			go = false;
		}
		
		return sb;
	}

}
