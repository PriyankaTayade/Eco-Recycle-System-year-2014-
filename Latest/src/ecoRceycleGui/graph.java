/**
 * @created On: 10 March 2014.
 * @version: 1
 * Student ID:W1093927,W1077339
/////////////////////////////////////////////////////////////////////
///  graph.java  -  Demonstrate graph Class                        //
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
///  Purpose:   generate statistics                                //
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


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

import connection.insertQueries;
import connection.selectQueries;
import connection.sqlConnection;
import connection.updateQueries;

public class graph extends JFrame {
	
	private  sqlConnection connnect;
	private selectQueries sql;
	private insertQueries sqlInsert;
	private updateQueries sqlUpdate;
	public graph(){
		super ("Bar Chart");
		connnect= new sqlConnection();
		 sql= new selectQueries();
		 sqlInsert= new insertQueries();
		setPreferredSize(new Dimension(800,400));
		setLocationRelativeTo(null);
		

		BarChart chart = new BarChart();
		
		// the data values are hardcoded
		chart.addBar(Color.red, 100);
		chart.addBar(Color.green, 8);
		chart.addBar(Color.blue, 54);
		chart.addBar(Color.black, 23);
		getContentPane().setBackground(Color.CYAN  ); 
		getContentPane().add(chart);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	public graph(String C,String type,Date Strt, String interval){
		super ("Bar Chart");
		connnect= new sqlConnection();
		 sql= new selectQueries();
		 sqlInsert= new insertQueries();
		 Connection conn=connnect.connect();
			int inte=Integer.parseInt(interval);
		 ResultSet item= sql.getGraph2(conn, "WEEK" , Strt , inte);
		 System.out.println("this happned");
		 /*ResultSetMetaData md = item.getMetaData();
	   	 int count = md.getColumnCount();
	   	int i=0;
		 String[] List= new String[count];*/
		/* while(item.next()){
			// List[i] = 
					System.out.println(item.getString("time_emptyed"));
			// i++;//
		}*/
		 //conn.close();
		

		setPreferredSize(new Dimension(800,400));
		setLocationRelativeTo(null);
		

		BarChart chart = new BarChart();
		
		// the data values are hardcoded
		chart.addBar(Color.red, 100);
		chart.addBar(Color.green, 8);
		chart.addBar(Color.blue, 54);
		chart.addBar(Color.black, 23);
		getContentPane().setBackground(Color.CYAN  ); 
		getContentPane().add(chart);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}


public graph(String C,String type, String interval, String r) throws SQLException{
		
	super ("Bar Chart");
	connnect= new sqlConnection();
	 sql= new selectQueries();
	 sqlInsert= new insertQueries();
	 Connection conn=connnect.connect();
		int inte=Integer.parseInt(interval);
	 ResultSet item= sql.getGraph1(conn, type,  inte);
	 int i=0;
	 ResultSetMetaData md = item.getMetaData();
   	 int count = md.getColumnCount();
	 String[] list= new String[count];
	 int i1=0;
	 	while(item.next())
	 	{                
	 		list[i1]=item.getString("rcm_id");
	 		i1++;
	 	}
	/* 	String[][] result=new String[count][];
	 	for(int j=0;j<count;j++)
	 	{
	 		int occ=0;
	 		for(int k=0;k< count; k++)
	 		{
	 			if(Integer.parseInt(list[j])==k)
	 			{ 
	 				occ++;
	 				result[j]=""+occ;
	 			}
	 		}
	 		
	 	}*/
	 	BarChart chart = new BarChart();
	 	Object[] col=new Object[]{ Color.red ,Color.green,Color.blue, Color.black, Color.pink,Color.yellow, Color.DARK_GRAY};
	 	for(int p=0;p<count;p++)
	 	{
	 		if(p==col.length-1)
	 		{
	 			break;
	 		}
	 		try
	 		{
	 		chart.addBar((Color) col[p], Integer.parseInt(list[p]));
	 		}
	 		catch(Exception e)
	 		{
	 			System.out.println("Exception occured here");
	 		}
	 	}

		getContentPane().setBackground(Color.CYAN  ); 
		getContentPane().add(chart);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	 
}
}
class BarChart extends JPanel
{
	private Map<Color, Integer> bars =
            new LinkedHashMap<Color, Integer>();

	public BarChart()
	{
		setPreferredSize(new Dimension(500,500));
		
	}
	/**
	 * Add new bar to chart
	 * @param color color to display bar
	 * @param value size of bar
	 */
	public void addBar(Color color, int value)
	{
		bars.put(color, value);
		
		// cannot call paintComponent() or paint() directly
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		// determine longest bar

		int max = Integer.MIN_VALUE;
		for (Integer value : bars.values())
		{
			max = Math.max(max, value);
		}

		// paint bars

		int width = (getWidth() / bars.size()) - 100;
		int x = 1;
		for (Color color : bars.keySet())
		{
			int value = bars.get(color);
			int height = (int)
                            ((getHeight()-5) * ((double)value / max));
			g.setColor(color);
			g.fillRect(x, getHeight() - height, width, height);
			g.setColor(Color.black);
			g.drawRect(x, getHeight() - height, width, height);
			x += (width + 2);
		}
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(bars.size() * 10 + 2, 50);
	}
	
}

