package Homework1;
/**
 * Class: Pets.java
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
public class Pets
{
	// Attributes
	private String petName;
	private String ownersName;
	private int age;
	private String type;
	
	Pets()
	{
		this.petName = null;
		this.ownersName = null;
		this.age = 0;
		this.type = null;
	}
	
	Pets(String petName, String ownersName, int age, String type)
	{
		this.petName = petName;
		this.ownersName = ownersName;
		this.age = age;
		this.type = type;
	}

	public String getPetName()
	{
		return petName;
	}

	public void setPetName(String petName)
	{
		this.petName = petName;
	}

	public String getOwnersName()
	{
		return ownersName;
	}

	public void setOwnersName(String ownersName)
	{
		this.ownersName = ownersName;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	@Override
	public String toString()
	{
		return "Pets [" + (petName != null ? "petName=" + petName + ", " : "")
				+ (ownersName != null ? "ownersName=" + ownersName + ", " : "") + "age=" + age + ", "
				+ (type != null ? "type=" + type : "") + "]";
	}
}
