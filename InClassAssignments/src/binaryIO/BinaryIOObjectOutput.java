
package binaryIO;
/**
 * Class: BinaryIODataOutput.java
 * @author Matthew Thompson
 * @version 1.0
 * Course : ITEC 3150 Spring 2016
 * Written: Jan 19, 2016
 *
 *
 * This class � now describe what the class does
 *
 * Purpose: � Describe the purpose of this class 
 */
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class BinaryIOObjectOutput
{
	public static void main(String[] args)
	{
		try
		{ 
				ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("PeopleObject.dat"));
				for (int i = 0; i < 100; i++)
		        {
					output.writeObject(new Person("fname"+i,"lname"+i,i,"city"+i));	        
		        }
				output.close();
				System.out.println("Successully Finshied");
		}		
		
		catch(Exception e)
		{ 
			e.printStackTrace();
			System.out.println("and Error has occured");
		}
	}
}
