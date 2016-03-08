package Homework1;
/**
 * Class: Dog.java
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
public class Dog extends Pets
{
	private String breed;
	private String color;
	
	/**
	 * @param petName
	 * @param ownersName
	 * @param age
	 * @param type
	 */
	Dog(String petName, String ownersName, int age, String type, String breed, String color)
	{
		super(petName, ownersName, age, type);
		
		this.breed = breed;
		this.color = color;
		// TODO Auto-generated constructor stub
	}

	public String getBreed()
	{
		return breed;
	}

	public void setBreed(String breed)
	{
		this.breed = breed;
	}

	public String getColor()
	{
		return color;
	}

	public void setColor(String color)
	{
		this.color = color;
	}

	@Override
	public String toString()
	{
		return super.toString() + "Dog [" + (breed != null ? "breed=" + breed + ", " : "") + (color != null ? "color=" + color : "") + "]";
	}
}
