/**
 * Class: PC_Games.java
 * @author Matthew Thompson
 * @version 1.0
 * Course : ITEC 3150 Spring 2016
 * Written: Jan 14, 2016
 *
 *
 * This class – Child of Games
 *
 * Purpose: – Describe the purpose of this class 
 */


public class Cat_Pet extends Pet
{
	private String color;
	private boolean shortHair,declawed;

	/**
	 * 
	 * @param gameID
	 * @param petName
	 * @param age
	 * @param shortHair
	 * @param declawed
	 */
	public Cat_Pet(String gameID, String ownerName, String petName, String age,
			String color, String shortHair, String declawed)
	{
		super(gameID, ownerName, petName, age);
		setColor(color);
		setShortHair(shortHair);
		setDeclawed(declawed);
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
	 * 
	 * @return
	 */
	public boolean isShortHair()
	{
		return shortHair;
	}
	
	/**
	 * 
	 * @param shortHair
	 */
	public void setShortHair(boolean shortHair)
	{
		this.shortHair = shortHair;
	}
	
	/**
	 * allows for setting booleans
	 * @param specialCare
	 */
	public void setShortHair(String shortHair)

	{
		if(shortHair.equalsIgnoreCase("False"))
			setShortHair(false);
		else 
			setShortHair(true);

	}

	/**
	 * 
	 * @return
	 */
	public boolean isDeclawed()
	{
		return declawed;
	}

	/**
	 * 
	 * @param declawed
	 */
	public void setDeclawed(boolean declawed)
	{
		this.declawed = declawed;
	}
	
	/**
	 * 
	 * @param shortHair
	 */
	public void setDeclawed(String shortHair)
	{
		if(shortHair.equalsIgnoreCase("True"))
			setDeclawed(true);
		else 
			setDeclawed(false);
	}

	
	/**
	 * @return a more user friendly to String
	 */
	@Override
	public String toString()
	{
		return super.toString() + 
				String.format("Color: %-10s ShortHair:%-10s  Declawed:%s",
						getColor(), isShortHair(),isDeclawed());
	}
	
	/**
	 * a to string for saving purposes
	 */
	public String toString(String s)
	{
		return "Cat, "+ super.toString("save") + ", " + getColor() + ", " + isDeclawed() + ", " + isShortHair();
	}
}