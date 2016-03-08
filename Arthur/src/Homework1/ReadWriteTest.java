package Homework1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Class: ReadWriteTest.java
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
public class ReadWriteTest
{
	public static void main(String [] args)
	{
		File OpenFile = new File("Untitled");
		
		String f1 = "Fred";
		
		try
		{
			Scanner SC = new Scanner(OpenFile);
			
			while(SC != null && SC.hasNext())
			{
				String a1 = SC.nextLine();
				String a2 = SC.nextLine();
				String a3 = SC.nextLine();
				String a4 = SC.nextLine();
				String a5 = SC.nextLine();
				String a6 = SC.nextLine();
				String a7 = SC.nextLine();
				
				System.out.println(a1);
				System.out.println(a2);
				System.out.println(a3);
				System.out.println(a4);
				System.out.println(a5);
				System.out.println(a6);
				System.out.println(a7);
			}
		} 
		
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try
		{
			PrintWriter Arthur = new PrintWriter("NewDocument.txt");
			
			Arthur.println("happy");
			
			Arthur.close();
		} 
		
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
