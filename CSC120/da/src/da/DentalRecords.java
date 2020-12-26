import java.lang.reflect.Array;
import java.util.Scanner;
//======================================
public class DentalRecords {
    //----------------------------------
    public static final Scanner keyboard = new Scanner(System.in);
    final static int TEETH_ROWS = 2;
    final static int TEETH_COLUMNS = 10;
    final static int MAX_PEOPLE = 5;

    public static void main (String [] args) {

    //Welcome statement
        System.out.println("Welcome to the Floridian Tooth Records");
        System.out.println("--------------------------------------");
    //Call method getRecords
        getRecords();
    }
//-------------------------------------------------------------------
    private static void getRecords() {

        //assign variable to method numPeople, define variables
        int x = numPeople();
        keyboard.nextLine();
        String[] names = new String[x];
        char[][][] dentalRecord = new char[x][TEETH_ROWS][];
        int i;
        //incrament i to go through each index of array
        for (i = 0; i < x; i++) {
            System.out.println("Please enter name for family member " + (i + 1) + "   : ");
            String name = keyboard.nextLine();
            names[i] = name;
            char[][] teeth = inputToothType(name);
            dentalRecord[i] = teeth;
        }
        showMenu(dentalRecord, names);
    }
    //-------------------------------------------------------------------
    private static int numPeople() {

        //input # ppl in family (must be in range of 1-5), while loop prompts until valid entry
        System.out.println("Please enter number of people in the family : ");
        int i = keyboard.nextInt();

        while (i < 1 || i > MAX_PEOPLE) {
            System.out.println("Invalid number of people, try again         : ");
            i = keyboard.nextInt();
        }
        return (i);
    }

    //-----------------------------------------------------------------------
    private static boolean areTeethValid (char[] teeth) {

        for (char t : teeth) {
            if (t != 'C' && t != 'B' && t != 'M') {
                return false;
            }
        }
        return true;
    }

    //------------------------------------------------------------------------
    private static char[][] inputToothType (String name) {
        //get uppers data for individual
        char[][] typeTooth = new char[TEETH_ROWS][TEETH_COLUMNS];

        System.out.println("Please enter the uppers for " + name + "           : ");
        //string upperStr to hold uppers **idiot proof: set all inputs to uppercase
        String upperStr = keyboard.nextLine().toUpperCase();
        char [] uppers = upperStr.toCharArray();

        //check range of # of teeth, & that areTeethValid = true
        while (upperStr.length() > 10 || !areTeethValid(uppers)) {
            if (upperStr.length() > 10) {
                System.out.println("Too many teeth, try again                   : ");
                upperStr = keyboard.nextLine().toUpperCase();
                uppers = upperStr.toCharArray();
            } else {
                System.out.println("Invalid teeth types, try again              : ");
                upperStr = keyboard.nextLine().toUpperCase();
                uppers = upperStr.toCharArray();
            }
        }

        //repeat steps for uppers with lowers
        System.out.println("Please enter the lowers for " + name + "   : ");
        String lowerStr = keyboard.nextLine().toUpperCase();
        char [] lowers = lowerStr.toCharArray();

        //check range of # of teeth
        while (lowerStr.length() > 10 || !areTeethValid(lowers)) {
            if (lowerStr.length() > 10) {
                System.out.println("Too many teeth, try again                   : ");
                lowerStr = keyboard.nextLine().toUpperCase();
                lowers = lowerStr.toCharArray();
            } else {
                System.out.println("Invalid teeth types, try again              : ");
                lowerStr = keyboard.nextLine().toUpperCase();
                lowers = lowerStr.toCharArray();
            }
        }
        typeTooth[0] = uppers;
        typeTooth[1] = lowers;
        return (typeTooth);
    }
    //-------------------------------------------------------------------
    private static void showMenu (char[][][] dentalRecord, String[] names) {

        //initialize userChoice to nothing, display menu
        char userChoice = ' ';
        while (userChoice != 'X') {
            System.out.print("(P)rint, (E)xtract, (R)oot, e(X)it          : ");
            userChoice = keyboard.next().toUpperCase().charAt(0);
            keyboard.nextLine();
            while (userChoice != 'P' && userChoice != 'E' && userChoice != 'R' && userChoice != 'X') {
                System.out.print("Invalid menu option, try again              : ");
                userChoice = keyboard.next().toUpperCase().charAt(0);
                keyboard.nextLine();
            }
            System.out.println();
            if (userChoice == 'P') {
                printRecords(dentalRecord, names);
            } else if (userChoice == 'E') {
                dentalRecord = extractTooth(dentalRecord, names);
            } else if (userChoice == 'R') {

            } else {
                break;
            }
            System.out.println();
        }
    //-------------------------------------------------------------------
        System.out.println();
        System.out.print("Exiting the Floridian Tooth Records :-)");
        return;
    }
    //-------------------------------------------------------------------
    private static void printRecords(char[][][] dentalRecord, String[] names)   {

        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            char[][] teeth = dentalRecord[i];
            System.out.println(name);
            System.out.print("Uppers: ");
            for (int j = 0; j < teeth[0].length; j++){
                System.out.print(" " + (j+1) + ":" + teeth[0][j]);
            }
            System.out.println();

            System.out.print("Lowers: ");
            for (int j = 0; j < teeth[1].length; j++){
                System.out.print(" " + (j+1) + ":" + teeth[1][j]);
            }
            System.out.println();
        }
    }
    //-------------------------------------------------------------------
    private static char[][][] extractTooth (char[][][] dentalRecord, String[] names) {

        System.out.println("Which family member: ");
        String name = keyboard.nextLine();
        while (isMemberValid(names, name) == -1) {
            System.out.println("Invalid family member, try again");
            name = keyboard.nextLine();
        }
        System.out.println("Which tooth layer (U)pper or (L)ower: ");
        char toothLayer = keyboard.nextLine().toUpperCase().charAt(0);
        while (toothLayer != 'U' && toothLayer != 'L') {
            System.out.println("Invalid layer, try again: ");
            toothLayer = keyboard.nextLine().toUpperCase().charAt(0);
        }
        int toothLayerIndex;
        if (toothLayer == 'U'){
            toothLayerIndex = 0;
        } else {
            toothLayerIndex = 1;
        }
        System.out.println("Which tooth number: ");
        int toothNumber = keyboard.nextInt();
        keyboard.nextLine();
        int memberIndex = isMemberValid(names, name);
        while (toothNumber <= 0 || toothNumber > dentalRecord[memberIndex][toothLayerIndex].length || dentalRecord[memberIndex][toothLayerIndex][toothNumber-1] == 'M'){
            if (toothNumber <= 0 || toothNumber > dentalRecord[memberIndex][toothLayerIndex].length){
                System.out.print("Invalid tooth number, try again:");
                toothNumber = keyboard.nextInt();
                keyboard.nextLine();
            } else {
                System.out.println("Missing tooth, try again: ");
                toothNumber = keyboard.nextInt();
                keyboard.nextLine();
            }
        }
        dentalRecord[memberIndex][toothLayerIndex][toothNumber-1] = 'M';
        return (dentalRecord);

    }
    //-------------------------------------------------------------------
    private static int isMemberValid (String[] names, String name) {

        for (int i = 0; i < names.length; i++){
            if (name.toUpperCase().equals(names[i].toUpperCase())) {
                return i;
            }
        }
        return -1;
    }
    //-------------------------------------------------------------------
    private static int rootValue (String[] names, char [][][] dentalRecord, int toothNumber, int [] toothLayer){
        int bCount = 0;
        int cCount = 0;
        int mCount = 0;

        for (String[] names : dentalRecord){
            for (int[] toothLayer : names){
                for (inttoothNumber : toothLayer){
                    if (toothNumber == 'B') {
                        bCount++;
                    } else if (toothNumber == 'C') {
                        cCount++;
                    }else if (toothNumber == 'M') {
                        mCount++;
                    }
                }
            }
        }
        double root1, root2;
        double determinant = cCount * cCount - 4 * bCount * mCount;

        //condition for real roots
        if (determinant >= 0) {
            root1 = (-cCount + Math.sqrt(determinant)) / (2 * bCount);
            root2 = (-cCount - Math.sqrt(determinant)) / (2 * bCount);
            System.out.println("One root canal at     " + root1);
            System.out.println("Another root canal at " + root2);
        }
    }
}

