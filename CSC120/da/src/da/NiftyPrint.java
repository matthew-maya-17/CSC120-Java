package da;
import java.util.*;
public class NiftyPrint {
	public static final int LEFT = 0;
	public static final int RIGHT = 1;
	public static final int CENTER = 2;

	public static void main( String[] args ){
	    Scanner keyboard = new Scanner( System.in );
	    System.out.print( "Enter width: " );
	    int width = keyboard.nextInt();
	    System.out.print( "Enter formatting option\n"
	                    + "LEFT=0, RIGHT=1, CENTER=2: " );
	    int option = keyboard.nextInt();

	    format( INPUT1, width, option );
	  }
	
	private static void flush( StringBuilder builder, int width, int option ){
		int diff = 0;
		if(option == 1) {
			diff = 0;
		}
		else if(option == 0) {
			if(builder.length() > width ) {
				diff = 0;
			}
			else {
				diff = width - builder.length();
			}
		}
		else if(option == 2) {
			if(builder.length() > width ) {
				diff = 0;
			}
			else {
				diff = (int) Math.floor(0.5*(width - builder.length()));
			}
		}
		for(int i = 0; i < diff; i++) {
			System.out.print(" ");
		}
		System.out.print(builder);
		System.out.println();
	}

	public static void format( String text, int width, int option ){
		Scanner scanner1 = new Scanner( text );
	    Scanner scanner2;
	    while ( scanner1.hasNextLine() )
	    {
	      scanner2 = new Scanner( scanner1.nextLine() );
	      StringBuilder lineBuilder = new StringBuilder();
	      while ( scanner2.hasNext() ){
	    	  String token = scanner2.nextLine();
	    	  if( lineBuilder.length() < width) {
	    		  lineBuilder.append(token);
	    	  }
	      }
	      flush( lineBuilder, width, option );
	      lineBuilder = new StringBuilder();
	    }
	  }


	public static final String INPUT1 =
	    "Among other public buildings in a certain town, which for many reasons "
	  + "it will be prudent to refrain from mentioning, and to which I will "
	  + "assign no fictitious name, there is one anciently common to most towns, "
	  + "great or small: to wit, a workhouse; and in this workhouse was born; on "
	  + "a day and date which I need not trouble myself to repeat, inasmuch as "
	  + "it can be of no possible consequence to the reader, in this stage of "
	  + "the business at all events; the item of mortality whose name is "
	  + "prefixed to the head of this chapter. "
	  + "\n"
	  + "For a long time after it was ushered into this world of sorrow and "
	  + "trouble, by the parish surgeon, it remained a matter of considerable "
	  + "doubt whether the child would survive to bear any name at all; in which "
	  + "case it is somewhat more than probable that these memoirs would never "
	  + "have appeared; or, if they had, that being comprised within a couple of "
	  + "pages, they would have possessed the inestimable merit of being the "
	  + "most concise and faithful specimen of biography, extant in the "
	  + "literature of any age or country. "
	  + "\n"
	  + "Although I am not disposed to maintain that the being born in a "
	  + "workhouse, is in itself the most fortunate and enviable circumstance "
	  + "that can possibly befall a human being, I do mean to say that in this "
	  + "particular instance, it was the best thing for Oliver Twist that could "
	  + "by possibility have occurred.  The fact is, that there was considerable "
	  + "difficulty in inducing Oliver to take upon himself the office of "
	  + "respiration,--a troublesome practice, but one which custom has rendered "
	  + "necessary to our easy existence; and for some time he lay gasping on a "
	  + "little flock mattress, rather unequally poised between this world and "
	  + "the next: the balance being decidedly in favour of the latter.  Now, "
	  + "if, during this brief period, Oliver had been surrounded by careful "
	  + "grandmothers, anxious aunts, experienced nurses, and doctors of "
	  + "profound wisdom, he would most inevitably and indubitably have been "
	  + "killed in no time.  There being nobody by, however, but a pauper old "
	  + "woman, who was rendered rather misty by an unwonted allowance of beer; "
	  + "and a parish surgeon who did such matters by contract; Oliver and "
	  + "Nature fought out the point between them.  The result was, that, after "
	  + "a few struggles, Oliver breathed, sneezed, and proceeded to advertise "
	  + "to the inmates of the workhouse the fact of a new burden having been "
	  + "imposed  upon the parish, by setting up as loud a cry as could "
	  + "reasonably have been expected from a male infant who had not been "
	  + "possessed of that very useful appendage, a voice, for a much longer "
	  + "space of time than three minutes and a quarter.";

}

