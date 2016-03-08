package Homework1;
/**
 * Class: Cat.java
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
public class Cat extends Pets
{
	private boolean isLongHaired;
	private boolean isClawed;
	private String color;
	/**
	 * @param petName
	 * @param ownersName
	 * @param age
	 * @param type
	 */
	Cat(String petName, String ownersName, int age, String type, boolean isLongHaired, boolean isClawed, String color)
	{
		super(petName, ownersName, age, type);
		
		this.isLongHaired = isLongHaired;
		this.isClawed = isClawed;
		this.color = color;
		// TODO Auto-generated constructor stub
	}
	public boolean isLongHaired()
	{
		return isLongHaired;
	}
	public void setLongHaired(boolean isLongHaired)
	{
		this.isLongHaired = isLongHaired;
	}
	public boolean isClawed()
	{
		return isClawed;
	}
	public void setClawed(boolean isClawed)
	{
		this.isClawed = isClawed;
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
		return super.toString() + "Cat [isLongHaired=" + isLongHaired + ", isClawed=" + isClawed + ", "
				+ (color != null ? "color=" + color : "") + "]";
	}	
}
