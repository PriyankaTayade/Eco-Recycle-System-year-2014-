package RCM;

/**
 * @created On: 10 March 2014.
 * @version: 1
 * Student ID:W1093927,W1077339
/////////////////////////////////////////////////////////////////////
///            //
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
///  Purpose:     Contains the properties for money and the methods 
 *                                   for conversion
 *                                                                  //
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

public class Money {
	private String currencyUnits="dollars"; //default value  dollars
	private double amount;
	/**
	 * class constructor sets amount to zero
	 */
	public Money(){ 
		this.amount=0;
	}
	/**
	 *  Class constructor sets amount equal to parameter value
	 * @param inputAmount
	 */
	public Money(double inputAmount){
		this.amount=inputAmount;
	}
	/**
	 * Class constructor sets amount and Currency units
	 * @param inputAmount
	 * @param inputCurrencyUnits
	 */
	public Money(double inputAmount, String inputCurrencyUnits){
		amount=inputAmount;
		currencyUnits=inputCurrencyUnits;
	}
	/**
	 * gets item price in dollars
	 * @return amount:double
	 */
	protected double getAmount(){   
		if(currencyUnits.equalsIgnoreCase("euro")==true) 
			return (this.amount)*0.7;   // conversion, 1 US dollar = 0.7 Euro 
		else
			return this.amount;
	}
	/**
	 * sets item price equal to the parameter passed
	 * @param setAmount
	 */
	protected void setAmount(double setAmount){
		this.amount=setAmount;
	}
	/**
	 * get iteam price in euros
	 * @return amount:double
	 */
	protected double getAmountInEuro(){
		if(currencyUnits.equalsIgnoreCase("dollars")==true)      
			return  Math.round((this.amount/0.7) * 100) / 100.0; // round to 2 decimal places. conversion, 1 US dollar = 0.7 Euro 
		else 
			return this.amount;
	}
}
