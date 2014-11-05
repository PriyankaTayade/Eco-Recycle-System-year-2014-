package RCM;
/**
 * @created On: 10 March 2014.
 * @version: 1
 * Student ID:W1093927,W1077339
/////////////////////////////////////////////////////////////////////
///              //
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
///  Purpose:     Contains the properties like rate,weight,name
 *               of the item which can be recycled                   //
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

public class item {

	private Money rate;
	private weight wgt;
	private Money amount;
	private String name;
	private int itemId;

	public item(){}
	
	/**
	 * Set the id of the recycle item
	 * @param setId the id of the recycle item
	 */
	
	public item(int setId)
	{
		this.itemId=setId;
		rate= new Money();
		wgt=new weight();
		amount= new Money();
	}
	
	/**
	 * Sets the id,name, and the rate of the item
	 * @param name name of the recycle item
	 * @param setId id of the recycle item
	 * @param pricePerWeight the rate of the item
	 */
	public item(String name,int setId, double pricePerWeight)
	{
		this.name=name;
		this.itemId=setId;
		rate= new Money();
		rate.setAmount(pricePerWeight);
		wgt=new weight();
		amount= new Money();
	}
	
	/**
	 * Sets the name,id, rate and weight of the recycle item
	 * @param name name of the recycle item
	 * @param setId id of the recycle item
	 * @param pricePerWeight rate of the recycle item
	 * @param weight weight of the recycled item
	 */
	public item(String name, int setId, double pricePerWeight,double weight)
	{
		this.name=name;
		this.itemId=setId;
		rate= new Money();
		rate.setAmount(pricePerWeight);
		wgt=new weight();
		wgt.setWeight(weight);
		amount= new Money();
		amount.setAmount(weight*pricePerWeight);
	}
	
	/**
	 * Sets the amount
	 * @param amount the amount of the recycle item
	 */
	protected void setAmount(double amount)
	{
		this.amount.setAmount(amount);
	}
	
	/**
	 * Sets the rate of the item
	 * @param amount the rate of the item
	 */
	protected void setRate(double amount)
	{
		this.rate.setAmount(amount);
	}
	
	
    /**sets the weight of the recycle item
     * 
     * @param weight weight of the recycle item
     */
	protected void setWeight(double weight)
	{
		this.wgt.setWeight(weight);
	}
	
	/**
	 * gets the amount 
	 * @return the amount after recycling
	 */
	protected double getAmount()
	{
		return this.amount.getAmount();
	}
	
	/**
	 * gets the rate of the recycle item
	 * @return  the amount after recycling
	 */
	public double getRate()
	{
		return this.rate.getAmount();
	}
	
	/**
	 * gets the weight 
	 * @return the weight
	 */
	protected double getWeight()
	{
		return this.wgt.getWeight();
	}
	
	/**
	 * gets the name of the item
	 * @return name of the item
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * gets the item id
	 * @return item id 
	 */
	public int getItemId()
	{
		return itemId;
	}
	
	/**
	 * sets the item id
	 * @param id  item id 
	 */
	protected void setItemId(int id)
	{
		itemId=id;
	}
}
