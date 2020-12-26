package da;
import java.util.*;

public class Precipitation
{
	static final int FIRST_YEAR = 1900;
	static final int LAST_YEAR = 2019;
	static final int SIZE = LAST_YEAR - FIRST_YEAR + 1;
	static final double UNDEF = -99.99;
	static double[][][] data = new double[ SIZE ][ 12 ][ 31 ];
	static double[] mMax = new double[]{0.5, 0.75, 0.5, 0.25, 1.0, 2.0, 3.0, 2.25, 0.5, 0.35, 0.45, 1.0 };
	static int[] mLength = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	private static void generateData() {
		//Fills data array with UNDEF values for all markers orginally
		for(int i = 0; i < SIZE ; i++) {
			for(int j = 0; j < 11; j++) {
				Arrays.fill( data[ i ][ j ], UNDEF );
				int y = i + FIRST_YEAR;
				if ( j == 1  && isLeapYear(y) ) {
					for(int k = 0; k < 29; k++ ) {
						data[i][j][k] = Math.random() * mMax[j];
					}
				}
				else {
					for(int k = 0; k < mLength[j]; k++ ) {
						data[i][j][k] = Math.random() * mMax[j];
					}
				}
			}
		}
	}
	private static boolean isLeapYear( int year ) {
		if(year % 4 == 0 && year % 100 == 0 && year % 400 == 0) {
			return true;
		}
		return false;
	}

  private static double getDayData( int y, int m, int d ) {
    ///// return UNDEF if y, m, or d is out of range
	  if(y > LAST_YEAR || y < FIRST_YEAR || m > 12 || m < 1 || d > 31 || d < 1) {
		  return UNDEF;
	  }
	  return data[ y - FIRST_YEAR ][ m - 1 ][ d - 1 ];
  }

  public static void main( String[] args ){
	generateData();
    int month, day, year;
    double value;
    Scanner keyboard = new Scanner( System.in );
    System.out.print( "Enter year month day: " );
    while ( keyboard.hasNext() ) {
      year = keyboard.nextInt();
      month = keyboard.nextInt();
      day = keyboard.nextInt();
      value = getDayData( year, month, day );
      System.out.printf( "The data on %02d/%02d/%04d is ",
         month, day, year );
      System.out.println( value );
      System.out.print( "Enter year month day: " );
    }
  }
}