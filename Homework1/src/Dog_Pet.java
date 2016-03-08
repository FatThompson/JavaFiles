/**
 * Class: Console_Games.java
 * @author Matthew Thompson
 * @version 1.0
 * Course : ITEC 3150 Spring 2016
 * Written: Jan 14, 2016
 *
 *
 * This class – now describe what the class does
 *
 * Purpose: – Describe the purpose of this class 
 */

public class Dog_Pet extends Pet
{
	private String breed, color;
	
	/**
	 * 
	 * @param ownerName
	 * @param petID
	 * @param petName
	 * @param age
	 * @param breed
	 * @param color
	 */
	public Dog_Pet(String ownerName, String petID, String petName, String age, 
			String breed, String color)
	{
		super(ownerName, petID, petName, age);
		setBreed(breed);
		setColor(color);
	}

	/**
	 * 
	 * @return
	 */
	public String getBreed()
	{
		return breed;
	}
	
	/**
	 * 
	 * @param breed
	 */
	public void setBreed(String breed)
	{
		this.breed = breed;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getColor()
	{
		return color;
	}
	
	/**
	 * 
	 * @param color
	 */
	public void setColor(String color)
	{
		this.color = color;
	}
	
	/**
	 * @return a more user friendly to string
	 */
	@Override
	public String toString()
	{
		return super.toString() + String.format("Breed: %-10s Color: %-10s", getBreed(), getColor());

	}
	
	/**
	 * a to string for saving purposes
	 */
	public String toString(String s)
	{
		return "DOG, " + super.toString("SAVE")  + ", " + getBreed() + ", " + getColor();
	}
}
