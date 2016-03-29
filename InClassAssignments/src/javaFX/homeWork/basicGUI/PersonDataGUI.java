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

import javafx.scene.control.TextArea;

/**
 * @author User
 *
 */
public class PersonDataGUI
{
	private ArrayList<Person> personAL = new ArrayList<Person>();
	private TextArea txaPersonData = new TextArea();
	private boolean hasData;
	
	public PersonDataGUI()
	{
		setPersonAL(searchForFile());
		setHasData();
	}
	
	public void add(Person person)
	{
		if(person!=new Person())
		{
			personAL.add(person);
			txaPersonData.setText(toString());
		}
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

	public TextArea createPersonDataField(){
		txaPersonData.setEditable(false);

		//get data file here
		
		txaPersonData.setMinSize(100, 50);
		txaPersonData.setMaxWidth(300);
		txaPersonData.setText(toString());
		txaPersonData.setWrapText(true);
		
		
		return txaPersonData;
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
			//return null;
		}
		catch(Exception e)
		{
			System.out.println("other exeption");
			//return null;
		}
		return new ArrayList<Person>();
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