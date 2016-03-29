package javaFX.homeWork.basicGUI;
import java.io.Serializable;

/**
 * ITEC 3150 - Homework 2 Person Class - This is the object we will read and
 * write to file
 * 
 * @author cjohns25
 * 
 */
public class Person implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String firstName;
    public String lastName;
    public int idNum;
    public String city;

    /**
     * Default constructor used to create empty attributes
     */
    public Person()
    {
        firstName = "";
        lastName = "";
        idNum = 0;
        city = "";
    }

    /**
     * @param firstName
     * @param lastName
     * @param idNum
     * @param city
     */
    public Person(String firstName, String lastName, int idNum, String city)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNum = idNum;
        this.city = city;
    }
    
    /**
     * @param firstName
     * @param lastName
     * @param idNum
     * @param city
     */
    public Person(String firstName, String lastName, String idNum, String city)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        setIdNum(idNum);
        this.city = city;
    }

   

    

	/**
     * @return the firstName
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * @param firstName
     *            the firstName to set
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * @param lastName
     *            the lastName to set
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * @return the idNum
     */
    public int getIdNum()
    {
        return idNum;
    }

    /**
     * @param idNum
     *            the idNum to set
     */
    public void setIdNum(int idNum)
    {
        this.idNum = idNum;
    }
    /**
	 * @param idNum2
	 */
	private void setIdNum(String idNum2)
	{
		idNum2 = "0"+ idNum2;
		setIdNum(Integer.parseInt(idNum2.replaceAll("\\D", "")));
				
		
	}

    /**
     * @return the city
     */
    public String getCity()
    {
        return city;
    }

    /**
     * @param city
     *            the city to set
     */
    public void setCity(String city)
    {
        this.city = city;
    }
    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return idNum+ ": " + lastName+", "+ firstName +", from "+city;
    }
}