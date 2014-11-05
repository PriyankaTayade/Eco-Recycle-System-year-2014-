package RCM;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;

import connection.insertQueries;
import connection.selectQueries;
import connection.sqlConnection;
/**
 * @created On: 10 March 2014.
 * @version: 1
 * Student ID:W1093927,W1077339
/////////////////////////////////////////////////////////////////////
///       //
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
///  Purpose:     For recycling the item                        //
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


public class Recycler extends recycleMachine {
	private sqlConnection connnect= new sqlConnection();
	private selectQueries sql= new selectQueries();
	private insertQueries sqlInsert= new insertQueries();
	
	public Recycler() {	 }
	/**
	 * gets the acceptable items from the database for given RCM id
	 * @param setLocation the location of RCM
	 * @param SetId Id of the RCM
	 */
	
	public Recycler(String setLocation, int SetId)
	{
		super.location=setLocation;
		super.id=SetId;	
		try {
			getAcceptableItemsFromDataBase(SetId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param i count for the items recycled
	 * @param getPaymentType payment type for amount after recycling
	 * @throws SQLException
	 */
	public void recycleItem(item i, String getPaymentType) throws SQLException
	{
		 for(item item:acceptableItems)
		 {
			 if(item.getItemId()==i.getItemId())
			 {
				 super.items.add(i);
				 Connection conn=connnect.connect();
				 ResultSet transaction=sql.getTransactionCount(conn);
				 int count = 0;
				 while(transaction.next()){
					    count = transaction.getInt("count");
				}
				
				connnect.close(conn);
			 }
		 }
		
		/**
		 * For each of the items recycled,the transaction information
		 */
		for(item j: items)
		{
			System.out.println("-----------------");
			System.out.println("Items recycle");
			System.out.println(j.getName());
			System.out.println(j.getRate());
			System.out.println(j.getAmount());
			System.out.println("-----------------");
		}
	}
	
	/**
	 * Connects to database and gets the items list for recycling
	 * @param RcmId ID of the recycle machine
	 * @throws SQLException
	 */
	
	public void getAcceptableItemsFromDataBase(int RcmId) throws SQLException
	{
		 Connection conn=connnect.connect();
		 ResultSet item= sql.getAcceptableItemForRcm(conn,RcmId);
		 int item_id;
		 while(item.next()){
			 item_id = item.getInt("item_id");
			 super.acceptableItems.add(new item(item_id));
		}
		 conn.close();
	}
	
}
