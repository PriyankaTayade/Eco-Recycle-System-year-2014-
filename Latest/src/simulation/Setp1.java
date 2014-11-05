
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
package simulation;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import RCM.Recycler;
import RCM.item;
import RecycleStation.rcmList;
import connection.insertQueries;
import connection.selectQueries;
import connection.sqlConnection;
import ecoRceycleGui.mainWindow;

//import javax.swing.*;

public class Setp1 {

	public static void main(String[] args) throws SQLException
	{
		 
      //  * Set the Nimbus look and feel
        
       //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
       
      //  * If Nimbus (introduced in Java SE 6) is not available, stay with the
      //  * default look and feel. For details see
       // * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
        
       try {
           for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
               if ("Nimbus".equals(info.getName())) {
                   javax.swing.UIManager.setLookAndFeel(info.getClassName());
                   break;
               }
           }
       } catch (ClassNotFoundException ex) {
           java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (InstantiationException ex) {
           java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (IllegalAccessException ex) {
           java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (javax.swing.UnsupportedLookAndFeelException ex) {
           java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       }
       //</editor-fold>

       
       // * Create and display the form
        
       java.awt.EventQueue.invokeLater(new Runnable() {

           public void run() {
               try {
				new mainWindow().setVisible(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           }
       });
         sqlConnection connnect= new sqlConnection();
    	selectQueries sql= new selectQueries();
    	insertQueries sqlInsert= new insertQueries();
    	 Connection conn=connnect.connect();
    /*	sqlInsert.demoInsert(conn);
    	sql.demoRead(conn);*/

    	rcmList rcms=new rcmList();
    	
    	ArrayList<Recycler> rcm = new ArrayList<Recycler>();	
    	
    	for(Recycler i: rcms.getRcmList())
    	{
    		System.out.println("RCMS Detected");
    		System.out.println(i.getLocation()+" : "+i.getId());
    		rcm.add(new Recycler(i.getLocation(),i.getId()));
    	}

    	 Object[] r = new Object[rcm.size()];
    	int j=0;
    	for(Recycler i :rcm)
    	{
    		r[j]=i;
    		j++;
    	}
    	
    	
    	for(int k=0;k<rcm.size();k++)
    	{
    		 int k1=k;
    		((Recycler) r[k1]).recycleItem(new item("paper",1, 5,  20),"CASH");
    		((Recycler) r[k1]).recycleItem(new item("cloth",3, 3,  40),"CASH");
    		((Recycler) r[k1]).recycleItem(new item("glass",2, 6,  10),"CASH");
    		((Recycler) r[k1]).recycleItem(new item("paper",1, 5,  20),"CASH");
    		((Recycler) r[k1]).recycleItem(new item("cloth",3, 3,  40),"CASH");
    		((Recycler) r[k1]).recycleItem(new item("glass",2, 6,  10),"CASH");
    	}
	}
}
	
        
        
