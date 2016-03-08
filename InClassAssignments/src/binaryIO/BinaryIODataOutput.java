
package binaryIO;
/**
 * Class: BinaryIODataOutput.java
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
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class BinaryIODataOutput
{
	public static void main(String[] args)
	{
		ArrayList<Person> personAL = new ArrayList<Person>();
		
		
		for (int i = 0; i < 100; i++)
			personAL.add(new Person("fname"+i,"lname"+i,i,"city"+i));
		
				
		try
		{ 
				DataOutputStream output = new DataOutputStream(new FileOutputStream("People.dat"));
				for (Person person : personAL)
		        {
					output.writeUTF(person.getFirstName());
					output.writeUTF(person.getLastName());
					output.writeInt(person.getIdNum());
					output.writeUTF(person.getCity());			        
		        }
				output.close();
		}		
		catch(Exception e)
		{ 
			e.printStackTrace();
			System.out.println("and Error has occured");
		}
	}
}
