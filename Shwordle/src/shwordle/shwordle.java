package shwordle;

import java.util.ArrayList;
import java.util.Scanner;

public class shwordle {

	public static String words[] = new String[663];
	public static int rand = (int) (Math.random() * 4 + 1);
	public static boolean go = true;
	
	public static void main(String[] args) {
		
		//dfgdf
		
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
	

	public static StringBuffer match(String input) {

		StringBuffer sb = new StringBuffer();
		
		ArrayList<Character> al = new ArrayList<Character>();
		for(int k=0; k<5; k++) {
			al.add(words[rand].charAt(k));
		}
		
		for (int i=0; i<5; i++) {
			if(al.contains(input.charAt(i))) {
				if (input.charAt(i) == words[rand].charAt(i)) {
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
