package da;
import java.util.*;
public class ThreeNumbers{
     public static void main(String []args){
        long theQuotient = 2, theDivisor = 2;
        Scanner keyboard = new Scanner(System.in);
        while(theQuotient >= 2){ 
            System.out.println("Enter a number >= 2: ");
            theQuotient = keyboard.nextLong();
            System.out.print(theQuotient + " = ");
            factoring_one(theQuotient);
            System.out.println();
            System.out.print(theQuotient + " = ");
            factoring_two(theQuotient);
            System.out.println();
        }
     }
     public static void factoring_one(long theQuotient)
     { 
        long theDivisor = 2;
        while (theQuotient > 1){
            while(theQuotient % theDivisor == 0 ){
                theQuotient = theQuotient / theDivisor;
                if(theQuotient != 1) {
                	System.out.print(theDivisor + "*");
                }
                else {
                	System.out.print(theDivisor);
                }
            }
        theDivisor++;
        }
     }
     public static void factoring_two(long theQuotient)
     { 
        long theDivisor = 2;
        int counter = 0;
        while (theQuotient > 1){
        	counter = 0;
            while(theQuotient % theDivisor == 0 ){
                theQuotient = theQuotient / theDivisor;
                counter++;
            }
        if(counter>0) {
        System.out.print(theDivisor + "^" + counter);
        	if(theQuotient != 1) {
                	System.out.print("*");
                }
        }
        theDivisor++;
        }
     }
}
//import java.util.*;
//public class ThreeNumbers {
//	public static void main(String[] args) {
//			Scanner keyboard = new Scanner(System.in);
//			for(int i = 1; i < 1000000; i++) {
//				System.out.println("----- Enter # of rounds (0 to stop ) :");
//				int rounds= keyboard.nextInt();
//				if( rounds == 0 ) {
//					break;
//				}
//				else if( rounds < 0 ) {
//					continue;
//				}
//				else {
//					oneDimensional(rounds);
//					twoDimensional(rounds);
//				}
//			}		
//		}
//	public static void oneDimensional(int r){ 
//		int xPos = 0, xMax = 0, xMin = 0, zeroCount = 0;
//		System.out.println("One dimensional random walk");
//		for(int i = 1; i <= r; i++)
//		{
//			if(Math.random() >= 0.5) {
//				xPos++;
//			}
//			else {
//				xPos--;
//			}
//			if(xPos == 0) {
//				zeroCount++;
//			}
//			if(xPos > xMax) {
//				xMax = xPos;
//			}
//			if(xPos < xMin) {
//				xMin = xPos;
//			}
//			System.out.print(xPos + " ");
//		}
//		System.out.println("\nThe Maximum is " + xMax);
//		System.out.println("The Minimum is " + xMin);
//		System.out.println("# of returns to O is " + zeroCount);
//	}
//	public static void twoDimensional(int r){ 
//		int xPos = 0, yPos = 0, xMax = 0, yMax = 0, zeroCount = 0;
//		System.out.println("\nTwo dimensional random walk" );
//		for(int i = 1; i <= r; i++)
//		{
//			double xRand = Math.random(), yRand = Math.random();
//			if(xRand >= 0.5) {
//				xPos++;
//			}
//			else if(yRand >= 0.5){
//				yPos++;
//			}
//			else if(xRand < 0.5){
//				xPos--;
//			}
//			else if(yRand < 0.5){
//				yPos--;
//			}
//			if(xPos == 0 && yPos == 0) {
//				zeroCount++;
//			}
//			if(Math.abs(xPos) + Math.abs(yPos) > xMax + yMax) {
//				xMax = xPos;
//				yMax = yPos;
//			}
//			System.out.print("(" + xPos + "," + yPos + ")");
//		}
//		System.out.println("\nThe farthest point is (" + xMax + "," + yMax + ")");
//		System.out.println("# of returns to O is " + zeroCount);
//	}
//}