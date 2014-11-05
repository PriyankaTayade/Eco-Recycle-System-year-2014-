package RCM;

/**
 * @created On: 10 March 2014.
 * @version: 1
 * Student ID:W1093927,W1077339
/////////////////////////////////////////////////////////////////////
///                                                                //
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
///  Purpose:     Maintains all the conversions related to 
                 volume and weight                                 //
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

public class Capacity {
	
	//-------current quantity in rcm
	private Money totalAmount;
	private weight totalWeight;
	private double totalVolume;
	//---- total capacity
	private Money maxAmount;
	private weight maxWeight;
	private double maxVolume;
	
	//---Getters n Setters
	/**
	 * Gives the total amount
	 * @return totalAmount the totalAmount stored is returned
	 */
	protected Money getTotalAmount() {
		return totalAmount;
	}
	
	
	/**
	 * Sets the total amount
	 * @param totalAmount the total amount
	 */
	protected void setTotalAmount(Money totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	/**
	 * get method to return getTotalWeight variable
	 * @return totalWeight the total Weight recycled
	 */
	protected weight getTotalWeight() {
		return totalWeight;
	}
	
	/**
	 * set method for the totalWeight
	 * @param totalWeight the total weight recycled
	 */
	protected void setTotalWeight(weight totalWeight) {
		this.totalWeight = totalWeight;
	}
	
	/**
	 * get method for the totalVolume
	 * @return totalVolume the total volume recycled
	 */
	protected double getTotalVolume() {
		return totalVolume;
	}
	/**
	 * set method for the TotalVolume
	 * @param TotalVolume the total volume recycled
	 */
	protected void setTotalVolume(double totalVolume) {
		this.totalVolume = totalVolume;
	}
	/**
	 * get method for the maxAmount
	 * @return maxAmount the maximum amount
	 */
	protected Money getMaxAmount() {
		return maxAmount;
	}
	/**
	 * set method for the MaxAmount
	 * @param MaxAmount the total weight recycled
	 */
	protected void setMaxAmount(Money maxAmount) {
		this.maxAmount = maxAmount;
	}
	/**
	 * get method for the maxWeight
	 * @return maxWeight the maximum
	 */
	protected weight getMaxWeight() {
		return maxWeight;
	}
	/**
	 * set method for the maxWeight
	 * @param maxWeight the total weight recycled
	 */
	protected void setMaxWeight(weight maxWeight) {
		this.maxWeight = maxWeight;
	}
	/**
	 * get method for the MaxVolume
	 * @return MaxVolume the total volume recycled
	 */
	protected double getMaxVolume() {
		return maxVolume;
	}
	
	/**
	 * set method for the MaxVolume
	 * @param MaxVolume the maximum volume of the RCM
	 */
	
	protected void setMaxVolume(double maxVolume) {
		this.maxVolume = maxVolume;
	}
	/**
	 * creates the variables totalAmount,totalWeight,maxAmount,maxWeight
	 */
	public Capacity()
	{
		totalAmount = new Money();
		totalWeight = new weight();
		maxAmount = new Money();
		maxWeight= new weight();
	}
	
	/**
	 * Sets the maximum amount,maximum weight and the maximum volume
	 * @param setMaxAmont The maximum amount in RCM
	 * @param setMaxWeight The maximum Weight in the RCM
	 * @param setMaxVolume The maximum volume of RCM
	 */
	public Capacity(double setMaxAmont, double setMaxWeight, double setMaxVolume)
	{
		totalAmount = new Money();
		totalWeight = new weight();
		maxAmount = new Money();
		maxWeight= new weight();
		maxAmount.setAmount(setMaxAmont);
		maxWeight.setWeight(setMaxWeight);
		maxVolume= setMaxVolume;
	}
}
