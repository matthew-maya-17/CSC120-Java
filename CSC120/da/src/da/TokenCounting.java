package da;
import java.util.*;
public class TokenCounting {
	public static void main(String[] args) {
		double xxxx = 2;
		Scanner keyboard = new Scanner (System.in);
		int Greatercount = 0, lessCount = 0;
		while(keyboard.hasNextDouble() || userInput != xxxx) {
			System.out.print(">");
			double userInput = keyboard.nextDouble();
			if(userInput > xxxx) {
				Greatercount++;
			}
			else if(userInput < xxxx) {
				lessCount++;
			}
		}
		System.out.printf("The results are : %04d", Greatercount, lessCount );
	}
}
