package RCM;
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
///  Purpose:     For recycling the item when the item is 
 *                 selected                        //
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

import java.util.ArrayList;

abstract 
public class recycleMachine {
	
	private String status;  
	private Capacity capacity;
	private int noOfItems;  // count of item list
	//-----Attribute of machine
	protected String location;  
	protected int id;
	protected ArrayList <item> items;
	protected ArrayList <item> acceptableItems;
	
	//----Getters and Setters
	/**
	 * gets the status of the RCM
	 * @return status
	 */
	
	protected String getStatus() {
		return status;
	}
    /**
     * sets the status of the RCM
     * @param status status of the RCM
     */
	protected void setStatus(String status) {
		this.status = status;
	}
     
	/**
	 * gets the capacity
	 * @return capacity
	 */
	protected Capacity getCapacity() {
		return capacity;
	}
     
	/**
	 * 
	 * sets the capacity of the RCM
	 * @param capacity
	 */
	protected void setCapacity(Capacity capacity) {
		this.capacity = capacity;
	}

	/**
	 * gets the number of recycle items
	 * @return noOfItems
	 */
	protected int getNoOfItems() {
		return noOfItems;
	}
	
	/**
	 * sets the number of items
	 * @param noOfItems no of items recycled
	 */

	protected void setNoOfItems(int noOfItems) {
		this.noOfItems = noOfItems;
	}
    
	/**
	 * 
	 * gets the item list
	 * @return
	 */
	protected ArrayList<item> getItems() {
		return items;
	}

	/**
	 * sets the items in the list
	 * @param items
	 */
	protected void setItems(ArrayList<item> items) {
		this.items = items;
	}
	
	/**
	 * gets acceptable items 
	 * @return items
	 */
	public ArrayList<item> getAcceptableItems() {
		return items;
	}

	 /**
	  * sets acceptable items
	  * @param items
	  */
	protected void setAcceptableItems(ArrayList<item> items) {
		this.items = items;
	}
     
	
	/**
	 * gets the location of the item 
	 * @return
	 */
	public String getLocation()
	{
		return location;
	}
	
	/**
	 * gets the id of the item
	 * @return
	 */
	public int getId()
	{
		return id;
	}
	
	/**
	 * sets the location of the item
	 * @param location
	 */
	protected void setLocation(String location) {
		this.location = location;
	}
 
	/**
	 * sets the id of the location
	 * @param id
	 */
	protected void setId(int id) {
		this.id = id;
	}
	
	/**
	 * 
	 * Sets the location of the RCM
	 * @param setLoc sets the location of the RCM
	 * @param setId sets the id of the RCM
	 */

	public recycleMachine(String setLoc, int setId)
	{
		capacity=new Capacity();
		items= new ArrayList<item>();
		location= setLoc;
		id=setId;
	}
	
	/**
	 *  sets the location of the id
	 *  item Items of the List
	 */
	public recycleMachine()
	{
		capacity=new Capacity();
		items= new ArrayList<item>();
		acceptableItems = new ArrayList<item>();
	}
	/**
	 * 
	 * @param setMaxAmont sets the maximum amount
	 * @param setMaxWeight sets the maximum weight
	 * @param setMaxVolume sets the maximum volume
	 */
	public recycleMachine(double setMaxAmont, double setMaxWeight, double setMaxVolume)
	{
		capacity=new Capacity( setMaxAmont,  setMaxWeight,  setMaxVolume);	
		items= new ArrayList<item>();
		acceptableItems = new ArrayList<item>();
	}
	
}