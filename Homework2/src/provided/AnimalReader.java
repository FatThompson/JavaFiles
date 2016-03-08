package provided;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class AnimalReader
{
	//Global Static for calling methods in main.
	private static AnimalReader ar = new AnimalReader();
	
	/**
	 * runs all commands
	 * @param args
	 */
	public static void main(String[] args)
	{
		ar.saveNames(ar.hashNames(ar.addAnimalObjects(ar.readFile("animal.dat"))), "names.dat");
	}
	
	/**
	 * adds all the animal objects in the file to an arraylist
	 * @param input
	 * @return all animals in file
	 */
	public ArrayList<Animal> addAnimalObjects(ObjectInputStream input)
	{
		System.out.println("Reading File...");
		ArrayList<Animal> animalArrayList = new ArrayList<Animal>();
		try
		{
			while (true)
			{
				Animal a = (Animal)input.readObject();
				animalArrayList.add(a);
			}
		} catch (EOFException e)
		{
		} catch (IOException e)
		{
			System.out.println("Problem reading from file");
			e.printStackTrace();
		} catch (ClassNotFoundException e)
		{
			System.out.println("Corrupted file - regenerate");
			e.printStackTrace();
		}
		System.out.println("\nReading File Finished.");
		return animalArrayList;
	}
	
	/**
	 * hashes names and adds to a set.
	 * @param animalArrayList
	 * @return
	 */
	public Set<Integer> hashNames(ArrayList<Animal> animalArrayList)
	{
		System.out.println();		
		Set<Integer> animalNames = new HashSet<Integer>();
		for (Animal animal : animalArrayList)
			animalNames.add(animal.getAnimalName().toUpperCase().hashCode());
		return animalNames;
	}
	
	/**
	 * returns all objects in a file 
	 * @param fileName
	 * @return objects
	 */
	public ObjectInputStream readFile(String fileName)
	{
		System.out.println("Looking for file " + fileName + "...");
		ObjectInputStream input = null;
		try
		{
			input = new ObjectInputStream(new FileInputStream(fileName));

			System.out.println(fileName + " was found.");
		} catch (IOException e)
		{
			// TODO Auto-generated catch block

			System.out.println(fileName + " was not found.");
		}
		return input;
	}
	/**
	 * saves all the animal names to a binary file based on hash code.
	 * @param animalArrayList
	 * @param fileName
	 */
	public void saveNames(Set<Integer> animalNames, String fileName)
	{
		System.out.println("Saving to " + fileName + "...");
		try
		{
			DataOutputStream output = new DataOutputStream(new FileOutputStream(fileName));
			for (Integer integer : animalNames)
			{
				output.writeInt(integer);
			}
			output.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("Problem writing to file");
		}

		System.out.println("\nSaving Finished.");
	}
}
