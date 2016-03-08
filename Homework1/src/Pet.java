/**
 * Class: Pets.java
 * @author Matthew Thompson
 * @version 1.0
 * Course : ITEC 3150 Spring 2016
 * Written: Jan 14, 2016
 *
 * this class - Parents
 */

import java.util.Comparator;
public class Pet 
{
	protected String petID, petName, ownerName;
	protected int age;

	/**
	 * 
	 * @param ownerName
	 * @param petID
	 * @param petName
	 * @param age
	 */
	public Pet(String ownerName, String petID, String petName, String age ) 
	{	
		setOwnerName(ownerName);
		setPetID(petID);
		setPetName(petName);
		setAge(age);
	}
	
	/**
	 * 
	 * @return the owner name
	 */
	public String getOwnerName() 
	{
		return ownerName;
	}

	/**
	 * sets the owner name
	 * @param ownerName
	 */
	public void setOwnerName(String ownerName) 
	{
		this.ownerName = ownerName;
	}

	/**
	 * 
	 * @return the pet id
	 */
	public String getPetID() 
	{
		return petID;
	}

	/**
	 * 
	 * @param petID
	 */
	public void setPetID(String petID) 
	{
		this.petID = petID;
	}

	/**
	 * 
	 * @return
	 */
	public String getPetName() 
	{
		return petName;
	}

	/**
	 * 
	 * @param petName
	 */
	public void setPetName(String petName) 
	{
		this.petName = petName;
	}

	/**
	 * 
	 * @return
	 */
	public String getAge() 
	{
		return age + "";
	}

	/**
	 * 
	 * @param age
	 */
	public void setAge(String age) 
	{
		age = age.replaceAll("\\D", "");
		if(age.length() > 0)
			setAge(Integer.parseInt(age));
		else 
			setAge(0);

	}

	/**
	 * 
	 * @param age
	 */
	public void setAge(int age) 
	{
		this.age = age;
	}

	/**
	 * Makes it prettier
	 * @param s
	 * @return just s prettier to String
	 */
	public String getClass(String s)
	{
		if(super.getClass().toString().equals("class Cat_Pet"))
			return "Cat";
		else if(super.getClass().toString().equals("class Dog_Pet"))
			return "Dog";
		return "Other";

	}

	/**
	 * @return a more user friendly to string 
	 */
	@Override
	public String toString() 
	{
		return String.format("\n%-6s Owner: %-10s Pet ID: %-8s PetName: %-10s Age: %-4s",
				getClass(""),getOwnerName(), getPetID(), getPetName(),getAge());
	}

	/**
	 * a to string for saving purposes
	 */
	public String toString(String s)
	{
		return getOwnerName()+ ", " + getPetID() + ", " + getPetName() + ", " + getAge();

	}

	/**
	 * For Sorting
	 */
	public static Comparator<Pet> sortBy = new Comparator<Pet>()
	{
		public int compare(Pet pet1, Pet pet2)
		{
			String p1 = pet1.getClass().toString().toUpperCase();
			String p2 = pet2.getClass().toString().toUpperCase();
			return p1.compareTo(p2);
		}
	};
}
