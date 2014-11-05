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
import java.sql.*;

public class updateQueries{
	/**
	// Demo Querry
	 * 
	 * @param conn : Object
	 * @return ResultSet 
	 */
	public ResultSet demoUpdate(Connection conn)
	{
		Statement statement=null;
		try 
		{
			statement = conn.createStatement();
		
			PreparedStatement pst = conn.prepareStatement("UPDATE rcm SET location ='SAN DEIAGO' WHERE rcm_id= 1 ");
			pst.executeUpdate();
			ResultSet res = statement.executeQuery("SELECT * FROM  rcm");
			   while (res.next()) {
			          int id = res.getInt("rcm_id");
			          String msg = res.getString("location");
			          System.out.println(id + "\t" + msg);
			          }
			  return res;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return null;
		} 
	}
	/**
	// Add Item to the RCM
	 * 
	 * @param conn : Object
	 * @param id : int
	 * @param status : String
	 * @param cash : String
	 * @return
	 */
	public  int service(Connection conn,int id, String status, String cash)
	{
		PreparedStatement pst=null;
		String update = "current_amount = "+ Double.parseDouble(cash)+ " , status = "+status ;
		try 
		{ 
			if(cash==null)
			{
				 update = " status = "+status ;
			}
			
				
			 pst = conn.prepareStatement("UPDATE rcm SET "+update+" WHERE rcm_id= "+id+" ");
			
			 pst.executeUpdate();	
			 return 1;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return 0;
		} 
	}

}