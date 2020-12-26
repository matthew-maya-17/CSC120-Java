package da;
import da.Rectangle;
public class RecTest
{
  public static void main( String[] args )
  {
    Rectangle[] recs = new Rectangle[ 10 ];
    for ( int i = 0; i < recs.length; i ++ )
    {
      recs[ i ] = new Rectangle(
          Math.random() * 100 - 50, Math.random() * 100 - 50,
          Math.random() * 100 - 50, Math.random() * 100 - 50 );
    }
    for ( int i = 0; i < recs.length; i ++ )
    {
      System.out.printf( "%d: (%7.3f,%7.3f), (%7.3f,%7.3f)\n",
         i,
         recs[ i ].getXLow(), recs[ i ].getYLow(),
         recs[ i ].getXHigh(), recs[ i ].getYHigh() );
    }
    for ( int i = 0; i < recs.length - 1; i ++ )
    {
      for ( int j = i; j < recs.length; j ++ )
      {
        if ( recs[ i ].disjoint( recs[ j ] ) )
        {
          System.out.printf( "%d and %d are disjoint\n", i, j );
        }
       
      }
    }
    double x = Math.random() * 100 - 50;
    double y = Math.random() * 100 - 50;
    System.out.printf( "x = %7.3f, y = %7.3f\n", x, y );
    for ( int i = 0; i < recs.length; i ++ )
    {
      if ( recs[ i ].isIn( x, y ) )
      {
        System.out.printf( "The point is in %d\n", i );
      }
      else
      {
        System.out.printf( "The distance to %d is %7.3f\n",
            i, recs[ i ].distance( x, y ) );
      }
    }
  }
}
