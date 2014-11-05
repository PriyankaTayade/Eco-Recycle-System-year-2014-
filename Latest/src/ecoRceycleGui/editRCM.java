/**
 * @created On: 10 March 2014.
 * @version: 1
 * Student ID:W1093927,W1077339
/////////////////////////////////////////////////////////////////////
///  editRcm.java  -  Demonstrate editRCM Class            //
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
///  Purpose:    edit rcm information window                       //
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
package ecoRceycleGui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;

import connection.sqlConnection;



	
public class editRCM extends javax.swing.JFrame	{
	
public editRCM(int rcmid){
	createFrame(rcmid);
	
}
	
	
public  void createFrame( int requiredrcmid) {
	 final int r=requiredrcmid;
   // int y=requiredrcmid;
    EventQueue.invokeLater(new Runnable(){
        
    	@Override
        public void run()
        {
        	
            JFrame frame = new JFrame("RCM Details");
            frame.setBounds(50, 50, 400,400);
            frame.getContentPane().setLayout(null);
            
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            try 
            {
               UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
               e.printStackTrace();
            }
           
            JScrollPane scroller = new JScrollPane();
            scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
           
            jLayeredPane1 = new javax.swing.JLayeredPane();
            jLabel1 = new javax.swing.JLabel();
            jLabel2 = new javax.swing.JLabel();
            jLabel3 = new javax.swing.JLabel();
            jLabel4 = new javax.swing.JLabel();
            jLabel5 = new javax.swing.JLabel();
            jLabel6 = new javax.swing.JLabel();
            jLabel7 = new javax.swing.JLabel();
            jLabel8 = new javax.swing.JLabel();
            jLabel9 = new javax.swing.JLabel();
            jLabel10 = new javax.swing.JLabel();
            jLabel11 = new javax.swing.JLabel();
            jLabel12 = new javax.swing.JLabel();
            jLabel13 = new javax.swing.JLabel();
            jLabel14 = new javax.swing.JLabel();
            jLabel15 = new javax.swing.JLabel();
            jLabel16 = new javax.swing.JLabel();
            jLabel17 = new javax.swing.JLabel();
            jLabel18 = new javax.swing.JLabel();
            jLabel19 = new javax.swing.JLabel();
            jLabel20 = new javax.swing.JLabel();
            jLabel21 = new javax.swing.JLabel();
            jLabel22 = new javax.swing.JLabel();
            
            try {  
              	 sqlConnection connect2= new sqlConnection();
              	 Connection conn2=connect2.connect();
              
                  Statement stat1= conn2.createStatement(); 
                  
                  ResultSet rs1= stat1.executeQuery("SELECT * from rcm where rcm_id='"+r+"'");
                 // System.out.println("*********************************************");
                  while(rs1.next()){
                  jLabel2.setText(rs1.getString("location"));
                 
                 // System.out.println(rs1.getString("location"));
                  jLabel4.setText(rs1.getString("status"));
                  jLabel16.setText("$"+rs1.getString("current_amount"));
                  jLabel18.setText(rs1.getString("max_weight")+"pounds");
                  jLabel20.setText(rs1.getString("current_weight")+"pounds");
                  if(rs1.getTimestamp("last_removal_date")!=null)
                  jLabel22.setText(rs1.getTimestamp("last_removal_date").toString());
                  else jLabel22.setText("");
                  }
                  jLabel2.setBounds(130, 10, 100, 20);
                  jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
                  Statement stat2 = conn2.createStatement();
                  
                 // ResultSet rs2 = stat2.executeQuery("Select * from rcm_accepted_items where rcm_id='"+r+"'");
                  validator vq = new validator();          
                 String s[]= vq.getListOfAcceptableItems(r);
                 int i =0;
                 
                 
                	 
                
                 
                 
                	 
                 if(s[i]!=null){
                	 if(s[i]== "PAPER")
                    	 jLabel8.setText("$2 per lb");
                     else if(s[i]=="GLASS")
                           jLabel8.setText("$4 per lb");
                     else if(s[i]=="PLASTIC")
                     jLabel8.setText("$6 per lb");
                     else 
                    	 jLabel8.setText("$8 per lb");
                 jLabel7.setText(s[i]);
                 
                 System.out.println(s[i]);
                 i++;
                 }
                 if(s[i]!=null){
                	 if(s[i]== "PAPER")
                    	 jLabel10.setText("$2 per lb");
                     else if(s[i]=="GLASS")
                           jLabel10.setText("$4 per lb");
                     else if(s[i]=="PLASTIC")
                     jLabel10.setText("$6 per lb");
                     else 
                    	 jLabel10.setText("$8 per lb");
                     jLabel9.setText(s[i]);
                     System.out.println(s[i]);
                     i++;
                     }
                 
                 if(s[i]!=null){
                	 if(s[i]== "PAPER")
                    	 jLabel12.setText("$2 per lb");
                     else if(s[i]=="GLASS")
                           jLabel12.setText("$4 per lb");
                     else if(s[i]=="PLASTIC")
                     jLabel12.setText("$6 per lb");
                     else 
                    	 jLabel12.setText("$8 per lb");
                     jLabel11.setText(s[i]);
                     System.out.println(s[i]);
                     i++;
                     }
                 if(s[i]!=null){
                	 if(s[i]== "PAPER")
                    	 jLabel14.setText("$2 per lb");
                     else if(s[i]=="GLASS")
                           jLabel14.setText("$4 per lb");
                     else if(s[i]=="PLASTIC")
                     jLabel14.setText("$6 per lb");
                     else 
                    	 jLabel14.setText("$8 per lb");
                     jLabel13.setText(s[i]);
                     System.out.println(s[i]);
                     i++;}
                     
                 
                  

                   
               } 
            catch (SQLException e1) {  
                   // TODO Auto-generated catch block  
                   e1.printStackTrace();  
               } 

            

            jLabel1.setText("Location :");
            jLabel1.setBounds(20, 10, 70, 20);
            jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

            //jLabel2.setText("jLabel2");
            
            jLabel3.setText("Status :");
            jLabel3.setBounds(20, 40, 50, 14);
            jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

            //jLabel4.setText("jLabel4");
            jLabel4.setBounds(130, 30, 70, 20);
            jLayeredPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

            jLabel5.setText("Accepted Items for Recycling");
            jLabel5.setBounds(20, 60, 140, 14);
            jLayeredPane1.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

            jLabel6.setText("Rate");
            jLabel6.setBounds(200, 60, 23, 14);
            jLayeredPane1.add(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

           // jLabel7.setText("jLabel7");
            jLabel7.setBounds(20, 80, 70, 14);
            jLayeredPane1.add(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);

            //jLabel8.setText("jLabel8");
            jLabel8.setBounds(200, 80, 70, 14);
            jLayeredPane1.add(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);

            //jLabel9.setText("jLabel9");
            jLabel9.setBounds(20, 100, 70, 14);
            jLayeredPane1.add(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);

           // jLabel10.setText("jLabel10");
            jLabel10.setBounds(200, 100, 70, 14);
            jLayeredPane1.add(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);

            //jLabel11.setText("jLabel11");
            jLabel11.setBounds(20, 120, 70, 14);
            jLayeredPane1.add(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);

           // jLabel12.setText("jLabel12");
            jLabel12.setBounds(200, 120, 70, 14);
            jLayeredPane1.add(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);

           // jLabel13.setText("jLabel13");
            jLabel13.setBounds(20, 140, 70, 14);
            jLayeredPane1.add(jLabel13, javax.swing.JLayeredPane.DEFAULT_LAYER);

          //  jLabel14.setText("jLabel14");
            jLabel14.setBounds(200, 140, 70, 14);
            jLayeredPane1.add(jLabel14, javax.swing.JLayeredPane.DEFAULT_LAYER);

            jLabel15.setText("Current Amount:");
            jLabel15.setBounds(20, 170, 106, 14);
            jLayeredPane1.add(jLabel15, javax.swing.JLayeredPane.DEFAULT_LAYER);

          //  jLabel16.setText("jLabel16");
            jLabel16.setBounds(130, 170, 70, 14);
            jLayeredPane1.add(jLabel16, javax.swing.JLayeredPane.DEFAULT_LAYER);

            jLabel17.setText("Maximum Weight :");
            jLabel17.setBounds(20, 190, 100, 14);
            jLayeredPane1.add(jLabel17, javax.swing.JLayeredPane.DEFAULT_LAYER);

           // jLabel18.setText("jLabel18");
            jLabel18.setBounds(130, 190, 70, 14);
            jLayeredPane1.add(jLabel18, javax.swing.JLayeredPane.DEFAULT_LAYER);

            jLabel19.setText("Current Weight :");
            jLabel19.setBounds(20, 210, 90, 10);
            jLayeredPane1.add(jLabel19, javax.swing.JLayeredPane.DEFAULT_LAYER);

           // jLabel20.setText("jLabel20");
            jLabel20.setBounds(130, 210, 70, 14);
            jLayeredPane1.add(jLabel20, javax.swing.JLayeredPane.DEFAULT_LAYER);

            jLabel21.setText("Last Removal Date:");
            jLabel21.setBounds(20, 230, 100, 14);
            jLayeredPane1.add(jLabel21, javax.swing.JLayeredPane.DEFAULT_LAYER);

            //jLabel22.setText("jLabel22");
            jLabel22.setBounds(130, 230, 100, 14);
            jLayeredPane1.add(jLabel22, javax.swing.JLayeredPane.DEFAULT_LAYER);
            
            jLayeredPane1.add(scroller);

            
            
            
            frame.getContentPane().add(jLayeredPane1);
            jLayeredPane1.setBounds(-8, 1, 500, 900);;
           
          //  frame.setLocationByPlatform(true);
            frame.setVisible(true);
            frame.setResizable(true);
            

           pack();
       
        
    }

		
         });
    
}
private javax.swing.JLabel jLabel1;
private javax.swing.JLabel jLabel10;
private javax.swing.JLabel jLabel11;
private javax.swing.JLabel jLabel12;
private javax.swing.JLabel jLabel13;
private javax.swing.JLabel jLabel14;
private javax.swing.JLabel jLabel15;
private javax.swing.JLabel jLabel16;
private javax.swing.JLabel jLabel17;
private javax.swing.JLabel jLabel18;
private javax.swing.JLabel jLabel19;
private javax.swing.JLabel jLabel2;
private javax.swing.JLabel jLabel20;
private javax.swing.JLabel jLabel21;
private javax.swing.JLabel jLabel22;
private javax.swing.JLabel jLabel3;
private javax.swing.JLabel jLabel4;
private javax.swing.JLabel jLabel5;
private javax.swing.JLabel jLabel6;
private javax.swing.JLabel jLabel7;
private javax.swing.JLabel jLabel8;
private javax.swing.JLabel jLabel9;
private javax.swing.JLayeredPane jLayeredPane1;

    
}

