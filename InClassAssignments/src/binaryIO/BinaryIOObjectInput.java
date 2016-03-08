/**
 * Class: BinaryIODataInput.java
 * @author Matthew Thompson
 * @version 1.0
 * Course : ITEC 3150 Spring 2016
 * Written: Jan 19, 2016
 *
 *
 * This class – now describe what the class does
 *
 * Purpose: – Describe the purpose of this class 
 */
package binaryIO;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class BinaryIOObjectInput
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		try 
		{ // Create an input stream for file object.dat
			System.out.println("Searching for file");
			ObjectInputStream input = new ObjectInputStream(new FileInputStream("PeopleObject.dat"));
			System.out.println("File found");
			ArrayList<Person> pAL = new ArrayList<Person>();

			try
			{
				while(true)//input.available() > 0)
				{
					pAL.add((Person) input.readObject());
				}
			}
			catch(EOFException eof)
			{
				for (Person person : pAL)
				{
					System.out.println(person);
				}
				System.out.println("people have been created");
			}
			
			input.close();

		}

		catch(FileNotFoundException fnfe)
		{
			System.out.println("file not found");
		}
		catch(Exception e)
		{
			System.out.println("other exeption");
		}

	}
}