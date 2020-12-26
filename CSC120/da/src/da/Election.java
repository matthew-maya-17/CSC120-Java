package da;
import java.util.*;
public class Election {
	
	public static void main(String[] args) {
		String[] names = new String[0];
		int[]  counts = new int[0];
		Scanner keyboard = new Scanner(System.in);
		System.out.println("###########################################\n" + 
				"# Enter the votes, one vote per line.     #\n" + 
				"# End with either CTRL-D or an empty line.#\n" + 
				"###########################################\n" + 
				"");
		//CTRL D or SPACE are not working
		while ( keyboard.hasNext() ) {
			String name;
			name = keyboard.nextLine();
			if(name.equals(".")) {
				break;
			}
			find(names,name); //IDK if this belongs or i can take it out
			if(find(names,name) >= 0) {
				counts[find(names, name)]++;
			}
			else {
				names = addName( names, name );
				counts = addNewCount( counts );
			}
		}
		findWinner(names, counts);
	}
	
	public static int find( String[] names, String name ) {
		for(int i = 0; i < names.length; i++) {
			if( names[i].equals(name)) {
				return i;
			}
		}
		return -1;
	}
	
	public static String[] addName( String[] names, String name ) {
		String[] newArray = new String[names.length + 1];
		 for (int i = 0; i < names.length; i++) {
			 newArray[i] = names[i];
		 }
		 	newArray[names.length] = name;
		 	return newArray;
	}
	
	public static int[] addNewCount( int[] counts ) {
		int[] newArray = new int[counts.length + 1];
		 for (int i = 0; i < counts.length; i++) {
			 newArray[i] = counts[i];
		 }
		 	newArray[counts.length] = 1;
		 	return newArray;
	}
	//I have no idea if this method is correct
	public static void findWinner( String[] names, int[] counts ) {
		int maxCount = 0, theWinner = 0;
		for(int i = 0; i < names.length; i++) {
			System.out.println(names[i] + " received " + counts[i] + " votes.");
		}
		for(int n = 0; n < names.length; n++) {
			if(counts[n] > maxCount) {
				maxCount = counts[n];
				theWinner = n;
			}
		}
		System.out.println("The Winner is " + names[theWinner]);
	}
}
