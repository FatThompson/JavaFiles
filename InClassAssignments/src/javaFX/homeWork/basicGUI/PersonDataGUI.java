/**
 * Class: PersonData.java
 * @author Matthew Thompson
 * @version 1.0
 * Course : ITEC 3150 Spring 2016
 * Written: Mar 23, 2016
 *
 *
 * This class �
 *
 * Purpose: � Describe the purpose of this class 
 */

package javaFX.homeWork.basicGUI;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import binaryIO.Person;
import javafx.scene.control.TextArea;

/**
 * @author User
 *
 */
public class PersonDataGUI
{
	private ArrayList<Person> personAL = new ArrayList<Person>();
	private boolean hasData;
	
	public PersonDataGUI()
	{
		setPersonAL(searchForFile());
		setHasData();
	}
	
	public ArrayList<Person> getPersonAL()
	{
		return personAL;
	}

	public void setPersonAL(ArrayList<Person> personAL)
	{
		this.personAL = personAL;
	}

	public boolean isHasData()
	{
		return hasData;
	}

	public void setHasData()
	{
		if(personAL!=null)
			setHasData(true);
		else
			setHasData(false);
		
	}

	public void setHasData(boolean hasData)
	{
		this.hasData = hasData;
	}

	public TextArea createPersonData(){
		TextArea grpPersonDataField = new TextArea();
		grpPersonDataField.setEditable(false);

		//get data file here
		
		grpPersonDataField.setText(toString());
		grpPersonDataField.setMinSize(100, 50);
		grpPersonDataField.setMaxWidth(300);
		grpPersonDataField.setWrapText(true);
		
		return grpPersonDataField;
	}
	
	/**
	 * 
	 * @return
	 */
	public static ArrayList<Person> searchForFile()
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
			return pAL;
		}

		catch(FileNotFoundException fnfe)
		{
			System.out.println("file not found");
			return null;
		}
		catch(Exception e)
		{
			System.out.println("other exeption");
			return null;
		}
	}
	
	@Override
	public String toString()
	{
		String temp = new String();
		for (Person person : personAL)
		{
			temp = temp + person.toString() +"\n";
		}
		return temp;
	}
}
