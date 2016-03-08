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

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class BinaryIODataInput
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		try 
		{ // Create an input stream for file object.dat
			System.out.println("Searching for file");
			DataInputStream input = new DataInputStream(new FileInputStream("People.dat"));
			System.out.println("File found");

			Person p = new Person();
			ArrayList<Person> pAL = new ArrayList<Person>();

			try {
				while(true)
				{

					p.setFirstName(input.readUTF());
					p.setLastName(input.readUTF());
					p.setIdNum(input.readInt());
					p.setCity(input.readUTF());

					pAL.add(p);

				}
			}
			catch(EOFException e)
			{

			}
			

			System.out.println("people have been created");

			for (Person person : pAL)
			{
				System.out.println(person);
			}

			input.close();
		}
		catch(FileNotFoundException fnfe)
		{
			System.out.println("fil not found");
		}
		catch(Exception e)
		{
			System.out.println("other exeption");
		}

	}
}