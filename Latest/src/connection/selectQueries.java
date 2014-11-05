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
import java.sql.Date;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class selectQueries {
	/**
	// Demo Querry
	 * 
	 * @param conn : Connection
	 * @return ResultSet
	 */
	public ResultSet demoRead(Connection conn)
	{
		Statement statement=null;
		try 
		{
			statement = conn.createStatement();
			if(statement!=null)
			{
			ResultSet res = statement.executeQuery("SELECT * FROM  rcm");
			   while (res.next()) {
			          int id = res.getInt("rcm_id");
			          String msg = res.getString("location");
			          System.out.println(id + "\t" + msg);
			          }
			   return res;
			}
			System.out.println("null object found priyanka");
			return null;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		} 
	}
	
	/**
	 get transaction count
	 * @param conn : Connection
	 * @return ResultSet
	 */
	public ResultSet getTransactionCount(Connection conn)
	{
		Statement statement=null;
		try 
		{
			statement = conn.createStatement();
			if(statement!=null)
			{
			ResultSet res = statement.executeQuery("SELECT COUNT(*) AS count FROM  recycled_items ");
			   return res;
			}
			return null;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		} 
	}
	/**
	 get item by item id
	 * @param conn : Connection
	 * @param id : int
	 * @return ResultSet
	 */
	public ResultSet getAcceptableItemForRcm(Connection conn, int id)
	{
		Statement statement=null;
		try 
		{
			statement = conn.createStatement();
			if(statement!=null)
			{
			ResultSet res = statement.executeQuery("SELECT * FROM rcm_accepted_items WHERE rcm_id="+id+" ");
			   return res;
			}
			return null;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		} 
	}
	/**
	 get items from item table
	 * @param conn : Object
	 * @return ResultSet
	 */
	public ResultSet getItems(Connection conn)
	{
		Statement statement=null;
		try 
		{
			statement = conn.createStatement();
			if(statement!=null)
			{
				ResultSet res = statement.executeQuery("SELECT name FROM item ");
			   return res;
			}
			return null;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		} 
	}
	/**
	 get all the rcm
	 * @param conn : Object
	 * @return ResultSet
	 */
	public ResultSet getRcm(Connection conn)
	{
		Statement statement=null;
		try 
		{
			statement = conn.createStatement();
			if(statement!=null)
			{
				ResultSet res = statement.executeQuery("SELECT * FROM rcm ");
			   return res;
			}
			return null;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		} 
	}
	/**
	 get items recycled in the rcm 
	 * @param conn : Connection
	 * @param id : int
	 * @return ResultSet
	 */
	public ResultSet getItemsRecycledForRCM(Connection conn, int id)
	{
		Statement statement=null;
		try 
		{
			statement = conn.createStatement();
			if(statement!=null)
			{
				ResultSet res = statement.executeQuery("SELECT * FROM recycled_items WHERE rcm_id="+id+" ");
				   return res;
			}
			return null;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		} 
	}
	/**
	 // get acceptable items for rcm
	 * @param conn : Connection
	 * @param id : int
	 * @return ResultSet
	 */
	public ResultSet getAcceptableItemForRcm1(Connection conn, int id)
	{
		Statement statement=null;
		try 
		{
			statement = conn.createStatement();
			if(statement!=null)
			{
			ResultSet res = statement.executeQuery("SELECT rcm_accepted_items.rcm_id,rcm_accepted_items.item_id,item.name FROM rcm_accepted_items "
					+ "	INNER JOIN item	"
					+ " ON item.item_id=rcm_accepted_items.item_id"
					+ " WHERE rcm_id="+id+" ");
			
			   return res;
			}
			return null;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		} 
	}
	/**
	 // get the number of rcm 
	 * @param conn : Connection
	 * @return ResultSet
	 */
	
	public ResultSet getRCMCount(Connection conn)
	{
		Statement statement=null;
		try 
		{
			statement = conn.createStatement();
			if(statement!=null)
			{
			ResultSet res = statement.executeQuery("SELECT COUNT(*) AS count from RCM");
			   return res;
			}
			return null;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		} 
		
	}

	/**
	 // querry for (graph 2)  : analysis of number of times emptied / time for each rcm group
	 * @param conn : Object
	 * @param type : String
	 * @param strt : Date
	 * @param weekInterval : int
	 * @return ResultSet
	 */
	public ResultSet getGraph2(Connection conn,String type, java.util.Date strt, int weekInterval)
	{
		Statement statement=null;
		try 
		{
			statement = conn.createStatement();
			if(statement!=null)
			{
				System.out.println("SELECT * "+
							" FROM service"+
							" WHERE "+
							" BETWEEN  DATE_ADD("+strt+", INTERVAL "+weekInterval +" "+type+" )"+
							" AND "+strt+" "+
							" LIMIT 0 , 30");
			ResultSet res = statement.executeQuery("SELECT time_emptyed "+
							" FROM service"+
							" WHERE "+
							" BETWEEN  DATE_ADD("+strt+", INTERVAL "+weekInterval +" "+type+" )"+
							" AND "+strt+" "+
							" LIMIT 0 , 30");
			   return res;
			}
			return null;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		} 
		
	}
	/**
	 // values for graph 1 : analysis of weight/ time for each rcm group
	 * @param conn : Object
	 * @param type : String
	 * @param weekInterval : int
	 * @return
	 */
	public ResultSet getGraph1(Connection conn,String type, int weekInterval)
	{
		Statement statement=null;
		try 
		{
			statement = conn.createStatement();
			if(statement!=null)
			{
				
			ResultSet res = statement.executeQuery(" SELECT * "+
										" FROM service" +
										" WHERE time_emptyed" +
										" BETWEEN CURDATE( ) - INTERVAL "+ weekInterval+" "+ type +" "+
										" AND CURDATE( ) GROUP BY rcm_id "+
										" LIMIT 0 , 30 ");
			   return res;
			}
			return null;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		} 
		
	}
}
