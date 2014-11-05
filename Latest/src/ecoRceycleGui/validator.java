/**
 * @created On: 10 March 2014.
 * @version: 1
 * Student ID:W1093927,W1077339
/////////////////////////////////////////////////////////////////////
///  validator.java  -  Demonstrate validator Class                //
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
///  Purpose:    get the valid data from the form and              //
///                     enter in the system                        // 
/////////////////////////////////////////////////////////////////////
///
 */

package ecoRceycleGui;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import RCM.Recycler;
import RCM.item;
import RCM.recycleMachine;
import RecycleStation.rcmList;
import connection.insertQueries;
import connection.selectQueries;
import connection.sqlConnection;
import connection.updateQueries;

public class validator {
	private  sqlConnection connnect;
	private selectQueries sql;
	private insertQueries sqlInsert;
	private updateQueries sqlUpdate;
	private rcmList rcms;
	private ArrayList<Recycler> rcm;
	private Object[] r;
	private Vector columnNames;
    private Vector data;
    /**
     * Default Constructor
     */
	public validator(){
	     connnect= new sqlConnection();
		 sql= new selectQueries();
		 sqlInsert= new insertQueries();
	  	 rcms=new rcmList();
	  	 rcm = new ArrayList<Recycler>();
	  	for(Recycler i: rcms.getRcmList())
	   	{
	   		System.out.println("RCMS Detected");
	   		System.out.println(i.getLocation()+" : "+i.getId());
	   		rcm.add(new Recycler(i.getLocation(),i.getId()));
	   	}
	
	   	 r = new Object[rcm.size()];
	   	int j=0;
	   	for(Recycler i :rcm)
	   	{
	   		r[j]=i;
	   		j++;
	   	}
	}
	/**
	 get the list of rcm object 
	 * @param rcm: int
	 * @return Object
	 */
	public Object getObj(int rcm)
	{
		return r[rcm];
	}
	public void Recycle(int RcmId, String itemFromUser,String PaymentType, double weight)
	{
		r[RcmId] = new Recycler();
		ArrayList<item> acceptableList=((recycleMachine) r[RcmId]).getAcceptableItems();
		
		for(item acceptableItem: acceptableList)
		{
			if(acceptableItem.getName().equalsIgnoreCase(itemFromUser))
			{
		   		try {
					((Recycler) r[RcmId]).recycleItem(new item(acceptableItem.getName(),acceptableItem.getItemId(), acceptableItem.getRate(),  weight),PaymentType);
					   java.awt.EventQueue.invokeLater(new Runnable() {

				           public void run() {
				              try {
								mainWindow f= new mainWindow();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				              
				           }
				       });
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	/**
	 * function for getting items recycled for rcm
	 * @param rcm : int
	 * @return ResultSet
	 */
		public ResultSet getItemsRecycledForRCM(int rcm)
		{
			Connection conn= connnect.connect();
			
			return sql.getItemsRecycledForRCM(conn, rcm);
		}
		/**
		 * Get Column to generate table
		 * @param res : ResultSet
		 * @return Vector
		 * @throws SQLException
		 */
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public Vector getCol(ResultSet res) throws SQLException
		{
			columnNames = new Vector();
	   	    ResultSetMetaData md = res.getMetaData();
	   	    int columns = md.getColumnCount();

	   	       //  Get column names
	   	          int i=1;
	   	       for (; i <= columns; i++)
	   	       {
	   	    	columnNames.addElement( md.getColumnName(i));
	   	           
	   	       }
	   	       return columnNames;	
		}
		/**
		 get the row data for table rows
		 * @param res : ResultSet
		 * @param columns : int
		 * @return Vector
		 * @throws SQLException
		 */
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public Vector getRow(ResultSet res, int columns) throws SQLException
		{
		     data = new Vector();
			while (res.next())
	   	       {
	   	           Vector row = new Vector(columns);

	   	           for (int k = 1; k <= columns; k++)
	   	           {
	   	               row.addElement( res.getObject(k) );
	   	           }

	   	           data.addElement( row );
	   	       }
			return data;
		}
		/**
		 * get list of acceptable items for rcm
		 * @param rcm : int
		 * @return String[]
		 * @throws SQLException
		 */
		public String[] getListOfAcceptableItems(int rcm) throws SQLException
		{

			 Connection conn=connnect.connect();
			 ResultSet item= sql.getAcceptableItemForRcm1(conn,rcm);
			 ResultSetMetaData md = item.getMetaData();
		   	 int count = md.getColumnCount();
		   	int i=0;
			 String[] List= new String[count];
			 while(item.next()){
				 List[i] = item.getString("item.name");
				 i++;
			}
			 conn.close();
			return List;
		}	
		/**
		 * get The Rcm location
		 * @return String[]
		 * @throws SQLException
		 */
		
		public String[] getRcm() throws SQLException
		{

			 Connection conn=connnect.connect();
			 ResultSet item= sql.getRcm(conn);
			 ResultSetMetaData md = item.getMetaData();
		   	 int count = md.getColumnCount();
		   	int i=0;
			 String[] List= new String[count];
			 while(item.next()){
				 List[i] = item.getString("location");
				 i++;
			}
			 conn.close();
			return List;
		}
		/**
		 * get rcm details
		 * @return String[][]
		 * @throws SQLException
		 */
		public String[][] getRcmDetails() throws SQLException
		{

			 Connection conn=connnect.connect();
			 ResultSet item= sql.getRcm(conn);
			 ResultSetMetaData md = item.getMetaData();
		   	 int count = md.getColumnCount();
		   	int i=0;
		   	String[][] data= new String[count][count];
			 String[] List= new String[count];
			 while(item.next()){
				 List[i] = item.getString("location");
				 data[i][0]=item.getString("location");
				 data[i][1]=item.getString("status");
				 data[i][2]=item.getString("current_amount");
				 i++;
			}
			 conn.close();
			return data;
		}
		/**
		 * activate / deactivate rcm
		 * @param rcm : int
		 * @param status : String
		 * @param cash: String
		 * @return int
		 * @throws SQLException
		 */
		public int service(int rcm, String status, String cash) throws SQLException
		{

			 Connection conn=connnect.connect();
			 return sqlUpdate.service(conn, rcm,  status,  cash);
		}
		
		
		/**
		 * add new rcm
		 * @param loc : String
		 * @param id : int
		 * @param wei : double
		 * @param cashh : double
		 * @throws SQLException
		 */

        public void addNewRcm(String loc,int id,double wei,double cashh) throws SQLException{
        	Connection conn=connnect.connect();
        	
        	
        	 
        	 ResultSet res = sql.getRCMCount(conn);
        	 int count=0;
        	 while(res.next())
        	 {
        		 count= res.getInt("count");
        	 }
        	 sqlInsert.addNewRCM(conn, count+1, loc, wei, cashh);
        	 sqlInsert.addItemToRCM(conn, count+1, id);
        	 conn.close();
        	 
        }
}
