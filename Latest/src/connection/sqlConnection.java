/**
 * @created On: 31 January 2014.
 * @version: 1
 * Student ID:W1093927,W1077339
/////////////////////////////////////////////////////////////////////
///  AuctionItem.java  -  Demonstrate AuctionItem Class            //
///                                                                //
///  Language:    Java                                             //
///  Platform:    Lenovo G500, Windows 8 .                         //
///  Application: COEN 275 -OO Analysis, Design & Programming,     //
///               Winter 2014                                      //
///  Instructor:  Dr.Rani Mikkilineni, Santa Clara University      //
///                                                                //
///  @author:      Priyanka Tayade, Santa Clara University         //
///               (315) 416-0205, ptayade@scu.edu  
                   Geethika Kilaru,Santa Clara University
                   408-458-0234, gkilaru@scu.edu
//
///                                                                //
///  Purpose:    holds attributes/information of item to be auction//
///                                                                // 
/////////////////////////////////////////////////////////////////////
///
 */
/*
 * Maintenance : Original
 * Modified On:--
 * Modified By:--
 * Purpose:--
 */ 
package connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class sqlConnection {
    
    static final String DATABASE_URL = "jdbc:mysql://localhost/eco_recycle_db";
    //static final String DATABASE_URL ="jdbc:derby://localhost:8081/eco_recycle_db";
	// Adding connection to Mysql database
    /**
     * 
     * @return Connection
     */
   public Connection connect()
   {
      Connection conn = null;
      try
      {                         
         conn = DriverManager.getConnection( DATABASE_URL, "root", "" );
         return conn;
      }
      catch ( SQLException sqlException )                                
      {                                                                  
         sqlException.printStackTrace();
         return null;
      }
   }
   
   /**
   // Closing connection to Mysql database
    * 
    * @param conn : Object
    */
   public void close(Connection conn)
   {
	   try 
	   {
		   conn.close();
	   } 
	   catch (SQLException e)
	   	{
	   		e.printStackTrace();
	   	}
   }
}
