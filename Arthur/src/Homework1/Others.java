package Homework1;
/**
 * Class: Others.java
 * 
 * @author Arthur Wong
 * @version 1.0
 *          <p>
 * Course : ITEC 3150 Spring 2016 
 * Written: Jan 14, 2016
 * 
 * 
 *  This class – ******
 * 
 *  Purpose: – ******
 */

/**
 * @author arthurwong
 *
 */
public class Others extends Pets
{
	private boolean needsSpecialHandling;
	
	/**
	 * @param petName
	 * @param ownersName
	 * @param age
	 * @param type
	 */
	Others(String petName, String ownersName, int age, String type, boolean needsSpecialHandling)
	{
		super(petName, ownersName, age, type);
		
		this.needsSpecialHandling = needsSpecialHandling;
		// TODO Auto-generated constructor stub
	}

	public boolean isNeedsSpecialHandling()
	{
		return needsSpecialHandling;
	}

	public void setNeedsSpecialHandling(boolean needsSpecialHandling)
	{
		this.needsSpecialHandling = needsSpecialHandling;
	}

	@Override
	public String toString()
	{
		return super.toString() + "Others [needsSpecialHandling=" + needsSpecialHandling + "]";
	}
}
