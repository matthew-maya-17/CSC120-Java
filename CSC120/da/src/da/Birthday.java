package da;
import java.util.*;
public class Birthday {

	public static void main(String[] args) {
		int nPeople, nReps;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the no. of people: ");
		nPeople = keyboard.nextInt();
		System.out.println("Enter the no. of repetitions: ");
		nReps = keyboard.nextInt();
		experiment1(nPeople,nReps);
	}
	
	public static int[] oneTrial(int nPeople) {
		int[] theCounts = new int[365];
		for(int i = 0; i <= nPeople; i++) {
			theCounts[(int)(Math.random()*365)] ++;
		}
		return theCounts;
	}
	
	public static boolean hasAHit(int[] array) {
		for(int i = 0; i <= array.length-1; i++) {
			if(array[i] >= 2) {
				return true;
			}
		}
		return false;
	}
	
	public static void experiment1(int nPeople, int nReps) {
		double hitRate = 0;
		for(int i = 0; i < nReps; i++) {
			hasAHit(oneTrial(nPeople));
			if(hasAHit(oneTrial(nPeople)) == true) {
				hitRate++;
			}
		}
		hitRate = hitRate/nReps;
		System.out.println("Probability Of Hits: " + hitRate);
	}
	
//	public static void summarize(int[] theCounts) {
//		int counter0 = 0, counter1 = 0, counter2 = 0, counter2plus = 0;
//		for(int i = 0; i <= theCounts.length - 1; i++) {
//			if(theCounts[i] == 0) {
//				counter0++;
//			}
//			else if(theCounts[i] == 1) {
//				counter1++;
//			}
//			else if(theCounts[i] == 2) {
//				counter2++;
//			}
//			else if(theCounts[i] == 1) {
//				counter2plus++;
//			}
//		}
//		//how do I create a four unit array using the different counters
//		return int[] array = new int[counter0, counter1, counter2, counter2plus]
//	}
//	
//	public static void experiment2(int nPeople, int nReps) {
//		double hitRate = 0;
//		for(int i = 0; i < nReps; i++) {
//			summarize(oneTrial(nPeople));
//		}
//			System.out.println("Average No. of 0s: " + );
//			System.out.println("Average No. of 1s: " + );
//			System.out.println("Average No. of 2s: " + );
//			System.out.println("Average No. of >=3s: " +);
//	}
	
}

