import java.io.Serializable;

/**
 * Class: Animal
 * 
 * @author Dr. Johnson
 * @version 1.0 Course : ITEC 3150, Fall, 2015 Written: September 02, 2015
 * 
 * 
 *          This class : Contains information about a generic Animal
 * 
 *          Purpose: ï This class is created for use in Spring, 2016 Homework 2
 *
 */
public class Animal implements Serializable
{

    private String animalName;
    private String animalBreed;
    private double animalAge, balance;
    private int numInZoo;

    /**
     * @param animalName
     * @param animalBreed
     * @param animalAge
     * @param numInZoo
     */
    public Animal(String animalName, String animalBreed, double animalAge,
            int numInZoo)
    {
        super();
        this.animalName = animalName;
        this.animalBreed = animalBreed;
        this.animalAge = animalAge;
        this.numInZoo = numInZoo;
        this.balance = 0;
    }

    public double getBalance()
	{
		return balance;
	}

	public void setBalance(double balance)
	{
		this.balance = balance;
	}

	/* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "Animal [animalName=" + animalName + ", animalBreed="
                + animalBreed + ", animalAge=" + animalAge + ", numInZoo="
                + numInZoo + "]";
    }

    /**
     * 
     */
    public Animal()
    {
        super();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((animalBreed == null) ? 0 : animalBreed.hashCode());
        result = prime * result
                + ((animalName == null) ? 0 : animalName.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Animal other = (Animal) obj;
        if (animalBreed == null)
        {
            if (other.animalBreed != null)
                return false;
        } else if (!animalBreed.equals(other.animalBreed))
            return false;
        if (animalName == null)
        {
            if (other.animalName != null)
                return false;
        } else if (!animalName.equals(other.animalName))
            return false;
        return true;
    }

    /**
     * @return the animalName
     */
    public String getAnimalName()
    {
        return animalName;
    }

    /**
     * @param animalName
     *            the animalName to set
     */
    public void setAnimalName(String animalName)
    {
        this.animalName = animalName;
    }

    /**
     * @return the animalBreed
     */
    public String getAnimalBreed()
    {
        return animalBreed;
    }

    /**
     * @param animalBreed
     *            the animalBreed to set
     */
    public void setAnimalBreed(String animalBreed)
    {
        this.animalBreed = animalBreed;
    }

    /**
     * @return the animalAge
     */
    public double getAnimalAge()
    {
        return animalAge;
    }

    /**
     * @param animalAge
     *            the animalAge to set
     */
    public void setAnimalAge(double animalAge)
    {
        this.animalAge = animalAge;
    }

    /**
     * @return the numInZoo
     */
    public int getNumInZoo()
    {
        return numInZoo;
    }

    /**
     * @param numInZoo
     *            the numInZoo to set
     */
    public void setNumInZoo(int numInZoo)
    {
        this.numInZoo = numInZoo;
    }

}
