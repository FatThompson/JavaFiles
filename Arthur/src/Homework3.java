import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

/**
 * Class: Homework3.java
 * 
 * @author Arthur Wong
 * @version 1.0
 *          <p>
 * Course : ITEC 3150 Spring 2016 
 * Written: Feb 25, 2016
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
public class Homework3
{
	/**
	 * Arthur Wong
	 * 
	 */
	
	public static void main (String [] args)
	{
		BST animalTree = new BST();
		
		// open animal.dat and read into an arraylist of animals.
		ArrayList<Animal> animalAL = new ArrayList<Animal>();
		
		ObjectInputStream input = null;
		
		try
		{
			input = new ObjectInputStream(new FileInputStream("animal.dat"));
		}
		
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			while (true)
			{
				Animal a = (Animal)input.readObject();
				animalTree.insert(a.getAnimalName());
			}
		}
		
		catch (EOFException e)
		{
			System.out.println("file ended, done reading.");
		}
		
		catch (IOException e)
		{
			System.out.println("Problem reading from file.");
			e.printStackTrace();
		}
		
		catch (ClassNotFoundException e)
		{
			System.out.println("Corrupted file.");
			e.printStackTrace();
		}
		
		// create a random double number between 0 and 1000.
		Random randomGenerator = new Random();
		double random = randomGenerator.nextDouble() * 1000;
		
		// create a hashmap instance that will map the (key) to its (value).
		HashMap<String, Double> animalMap = new HashMap<String, Double>();
		
		for (Animal a : animalAL)
		{
			//animalMap.put(a, a);
		}
		
		Set<String> keys = animalMap.keySet();
		
		for (String animal : keys)
		{
			System.out.println("");
		}
		
		System.out.println("This is a list of animal names.");
		
		animalTree.inorder();
	}
}
