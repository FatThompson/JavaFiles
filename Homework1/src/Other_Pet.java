/**
 * Class: Mobile_Games.java
 * @author Matthew Thompson
 * @specialCare 1.0
 * Course : ITEC 3150 Spring 2016
 * Written: Jan 14, 2016
 *
 *
 * This class – now describe what the class does
 *
 * Purpose: – Describe the purpose of this class 
 */

public class Other_Pet extends Pet
{
	private String petType;
	private boolean specialCare;

	/**
	 * 
	 * @param petType
	 * @param ownerName
	 * @param petID
	 * @param petName
	 * @param age
	 * @param specialCare
	 */
	public Other_Pet(String petType, String ownerName, String petID, String petName, String age,
			String specialCare)
	{
		super(ownerName, petID, petName, age);
		setPetType(petType);
		setSpecialCare(specialCare);
	}

	/**
	 * The species of pets
	 * @return species of pets
	 */
	public String getPetType()
	{
		return petType;
	}

	/**
	 * 
	 * @param petType
	 */
	public void setPetType(String petType)
	{
		this.petType = petType;
	}	

	/**
	 * 
	 * @return whether specialty care is needed
	 */
	public boolean isSpecialCare()
	{
		return specialCare;
	}

	/**
	 * 
	 * @param specialCare
	 */
	public void setSpecialCare(boolean specialCare)
	{
		this.specialCare = specialCare;
	}

	/**
	 * allows for setting booleans
	 * @param specialCare
	 */
	public void setSpecialCare(String specialCare)
	{
		if(specialCare.equalsIgnoreCase("False"))
			setSpecialCare(false);
		else 
			setSpecialCare(true);
	}

	/**
	 * returns a more user friendly to string
	 */
	@Override
	public String toString()
	{
		return super.toString() + String.format("Species: %-8s Special Care Needed: %-10s",getPetType(), isSpecialCare()); 
	}

	/**
	 * a to string for saving purposes
	 */
	@Override
	public String toString(String s)
	{
		return "Other, " + getPetType() + ", " + super.toString("SAVE")  + ", "  + isSpecialCare();
	}
}
