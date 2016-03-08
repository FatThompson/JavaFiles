package binaryIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class ReadPeopleFromFile
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// Starting point of program
		// open a file of Person class and read them into an ArrayList of Persons
		ArrayList<Person>  people = new ArrayList<Person>();
		File peopleFile = new File("peopleFile.txt");
		// open a Scanner to read data from File
		Scanner peopleReader =null;
		try
      {
	      peopleReader = new Scanner(peopleFile);
      } catch (FileNotFoundException e)
      {
	      // TODO Auto-generated catch block
	      System.out.println("File not found - terminating program");
	      System.exit(0);
      	e.printStackTrace();
	      
      }
      
      // read one person at a time
      while (peopleReader.hasNext())
      {
      	// read first name
      	String firstName = peopleReader.next();
      	String lastName = peopleReader.next();
      	String city = peopleReader.next();
      	int id = peopleReader.nextInt();
      	// create new Person instance and add to ArrayList
      	Person temp = new Person(firstName, lastName, id, city);
      	people.add(temp);
      	
      }

      // print info to user
      System.out.println("The people from the file are:");
      System.out.println(people);
      
      
      // write people to another file
      File secondPeopleFile = new File("secondPeople.txt");
      PrintWriter peopleWrite = null;
      try
      {
      	peopleWrite = new PrintWriter("secondPeople.txt");
      } catch (FileNotFoundException e)
      {
      	System.out.println("unable to open file to write to- program ending");
      	System.exit(0);
	      // TODO Auto-generated catch block
	      e.printStackTrace();
      }
      
      for (Person temp: people)
      {
      	peopleWrite.println(temp.getFirstName());
      	peopleWrite.println(temp.getLastName());
      	peopleWrite.println(temp.getCity());
      	peopleWrite.println(temp.getIdNum());
      }
      peopleWrite.close();
	}

}
