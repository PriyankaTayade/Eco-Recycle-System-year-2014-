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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class insertQueries {
	/**
	// Add RCM ( id and Location with default amount 1000 $ and default capacity
	 * 
	 * @param conn : Object
	 * @param setLocation : String
	 * @param setId : int
	 * @return
	 */
	public  ResultSet setIdLocation(Connection conn, String setLocation, int setId)
	{
		PreparedStatement statement=null;
		try 
		{
			statement = conn.prepareStatement("INSERT INTO rcm(rcm_id , location ,status,total_items,current_amount,max_weight,max_volume,current_weight,current_volume,last_removal_date) VALUES ("+setId+","+setLocation+","+null+","+null+",'100','300','100',"+null+","+null+","+null+")");
			ResultSet resSetIdLocation = statement.executeQuery();
			return resSetIdLocation;		
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
	 * @param transaction : int
	 * @param setId : int
	 * @param itemId : int
	 * @param weight : double
	 * @param payment : String
	 * @return
	 */
	public  int addItem(Connection conn,int transaction, int setId, int itemId, double weight, String payment)
	{
		PreparedStatement statement=null;
		try 
		{ 
            //double dweight = Double.parseDouble(weight);  
			statement = conn.prepareStatement("INSERT INTO recycled_items(transaction_id,rcm_id , item_id , weight, time, payment_type) VALUES ("+transaction+","+setId+","+itemId+","+weight+",NOW(),'"+payment+"')");
			int resAddItem = statement.executeUpdate();
			return resAddItem;		
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return 0;
		} 
	}
	/**
	 // adding new RCM
	 * @param conn : Object
	 * @param rcmcount : int
	 * @param Loc : String
	 * @param Weight : double
	 * @param Cash : double
	 * @return
	 */
	public  int addNewRCM(Connection conn,int rcmcount,String Loc, double Weight, double Cash)
	{
		PreparedStatement statement=null;
		try 
		{ 
              
			statement = conn.prepareStatement("INSERT INTO rcm(rcm_id, location,status,total_items,current_amount,max_weight,"
					+ "	max_volume,	current_weight,current_volume,last_removal_date) VALUES"
					+ " ("+rcmcount+", '" +Loc+ "' , 'ACTIVE' ,0 ," +Cash+ ","+ Weight +", 100 , 0.0 , 0.0 ," +null+")");
			int resAddRCM = statement.executeUpdate();
			return resAddRCM;		
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return 0;
		} 
	}
	/**
	 // Adding item to the RCM
	 * @param conn : Object
	 * @param rcmid : int
	 * @param itemid : int
	 * @return
	 */
	public int addItemToRCM(Connection conn,int rcmid,int itemid){
		
		PreparedStatement statement=null;
		try 
		{ 
              
			statement = conn.prepareStatement("INSERT INTO rcm_accepted_items(rcm_id,item_id) VALUES("+rcmid+","+itemid+")");
					
			int resItem = statement.executeUpdate();
			return resItem;		
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return 0;
		} 
		
	}
	

}
