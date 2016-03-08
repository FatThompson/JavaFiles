import java.io.Serializable;

/**
 * Class: Pets.java
 * 
 *
 * 
 */

public class Pet implements Serializable, Comparable<Pet> {
	protected String petID, petName, ownerName;
	protected int age;

	/**
	 * 
	 * @param ownerName
	 * @param petID
	 * @param petName
	 * @param age
	 */
	public Pet(String ownerName, String petID, String petName, int age) {
		setOwnerName(ownerName);
		setPetID(petID);
		setPetName(petName);
		setAge(age);
	}

	/**
	 * 
	 * @return the owner name
	 */
	public String getOwnerName() {
		return ownerName;
	}

	/**
	 * sets the owner name
	 * 
	 * @param ownerName
	 */
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	/**
	 * 
	 * @return the pet id
	 */
	public String getPetID() {
		return petID;
	}

	/**
	 * 
	 * @param petID
	 */
	public void setPetID(String petID) {
		this.petID = petID;
	}

	/**
	 * 
	 * @return
	 */
	public String getPetName() {
		return petName;
	}

	/**
	 * 
	 * @param petName
	 */
	public void setPetName(String petName) {
		this.petName = petName;
	}

	/**
	 * 
	 * @return
	 */
	public String getAge() {
		return age + "";
	}

	/**
	 * 
	 * @param age
	 */
	public void setAge(String age) {
		age = age.replaceAll("\\D", "");
		if (age.length() > 0)
			setAge(Integer.parseInt(age));
		else
			setAge(0);

	}

	/**
	 * 
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return a more user friendly to string
	 */
	@Override
	public String toString() {
		return String.format(
				"\n%-20s Owner: %-10s Pet ID: %-8s PetName: %-10s Age: %-4s",
				getClass(), getOwnerName(), getPetID(), getPetName(), getAge());
	}

	/**
	 * a to string for saving purposes
	 */
	public String toString(String s) {
		return getOwnerName() + ", " + getPetID() + ", " + getPetName() + ", "
				+ getAge();

	}

	@Override
	public int compareTo(Pet a) {
		return petName.compareTo(a.getPetName());
	}

}
