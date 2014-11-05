package RCM;
/**
 * @created On: 10 March 2014.
 * @version: 1
 * Student ID:W1093927,W1077339
/////////////////////////////////////////////////////////////////////
///         //
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
///  Purpose:     Maintaining the properties and conversion of
 *                    units of weight                     //
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

public class weight {

	private double weight;
	private String unit="POUND";
	public weight(){}
	
	/**
	 *  weight recycled
	 * @param weight recycle item weight
	 *
	 */
	
	public weight(double weight)
	{
		this.weight=weight;
	}
	
	/**
	 * sets the weight and units 
	 * @param weight we
	 * @param unit
	 */
	
	public weight(double weight, String unit)
	{
		this.weight=weight;
		this.unit=unit;
	}
	
	/**
	 * get the units of the weight
	 * 
	 * @return units 
	 */
	protected String getUnit()
	{
		return this.unit;
	}
	
	/**
	 * gets the weight of the item
	 * @return weight of the item
	 */
	
	protected double getWeight()
	{
		return this.weight;
	}
	
	/**
	 * unit of weight
	 * @param unit the unit of weight
	 */
	
	protected void setUnit(String unit)
	{
		this.unit=unit;
	}
	
	/**
	 * sets the weight of the item
	 * @param weight weight of the item
	 */
	protected void setWeight(double weight)
	{
		this.weight=weight;
	}
	
	
	/**
	 * converts the units ot metric
	 * @param weightInPounds weight in pounds
	 */
	protected void convertToMetric(double weightInPounds)
	{
		this.weight=weightInPounds/2.2046;
	}
	
	
	/**
	 * converts the weight from kilograms to pounds
	 * @param weightInKg weight in kilograms
	 */
	protected void convertToPounds(double weightInKg)
	{
		this.weight=weightInKg*2.2046;
	}
}
