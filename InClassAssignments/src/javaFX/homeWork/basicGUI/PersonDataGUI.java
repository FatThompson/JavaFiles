/**
 * Class: PersonData.java
 * @author Matthew Thompson
 * @version 1.0
 * Course : ITEC 3150 Spring 2016
 * Written: Mar 23, 2016
 *
 *
 * This class –
 *
 * Purpose: – Describe the purpose of this class 
 */

package javaFX.homeWork.basicGUI;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Set;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

/**
 * @author User
 *
 */
public class PersonDataGUI
{
	private ArrayList<Person> personAL = new ArrayList<Person>();
	private TextArea txaPersonData = new TextArea();
	private GridPane personDataPane;
	private Button btnSave, btnClear, btnRegenerateData;
	private boolean hasData;
	private static int personIDCounter;

	public PersonDataGUI()
	{
		setPersonAL(searchForFile());
		//personIDCounter = (personAL.get(personAL.size()-1).getIdNum()+1);
		setHasData();
	}

	public void refresh()
	{
		txaPersonData.setText(toString());
	}

	//add, person name = john doe set ID 0, and update ID counter.
	public void add(Person person)
	{
		try{

			if((!person.getFirstName().equals(null))||
					(!person.getLastName().equals(null))||
					(!person.getCity().equals(null))||
					(person.getIdNum() != 0))
			{
				if (person.getIdNum() <= 0)
				{
					person.setIdNum(personIDCounter++);
					System.out.println("ID <= 0, changing to next avaliable.");
				}	
				else
				{
					personIDCounter = person.getIdNum()+1;
					System.out.println("ID > 0, still could be a duplicate.");
				}
				personAL.add(person);
				refresh();
			}
		}
		catch(NullPointerException npe)
		{
			System.out.println("NullPonter");
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

	public GridPane createPersonDataField(){
		personDataPane = new GridPane();

		//modify and add txa for Person Data
		txaPersonData.setEditable(false);		
		txaPersonData.setMinSize(Config.PERSON_DATA_MIN_HEIGTH, Config.PERSON_DATA_MIN_WIDTH);
		txaPersonData.setMaxWidth(Config.PERSON_DATA_MAX_WIDTH);
		txaPersonData.setMaxHeight(Config.PERSON_DATA_MAX_HEIGTH);
		refresh();
		txaPersonData.setWrapText(true);


		btnSave = new Button();
		btnSave.setOnAction(e -> save());
		btnSave.setText("Save");


		btnClear = new Button();
		btnClear.setOnAction(e -> clearData());
		btnClear.setText("Clear List");

		btnRegenerateData = new Button();
		btnRegenerateData.setOnAction(e -> regenData());
		btnRegenerateData.setText("Regenerate Random Data");

		personDataPane.add(txaPersonData, 0, 0, 3,1);
		personDataPane.add(btnSave, 0, 2);
		personDataPane.add(btnClear, 1, 2);
		personDataPane.add(btnRegenerateData, 2, 2);



		return personDataPane;
	}


	/**
	 * @return
	 */
	private void regenData()
	{
		BinaryIOObjectOutput.createPeopleDat();
		setPersonAL(searchForFile());
		setHasData();
		refresh();
		return;
	}

	/**
	 * @return 
	 * @return
	 */
	private void clearData()
	{
		personAL.clear();
		refresh();
		return;
	}

	/**
	 * @return
	 */
	private void save()
	{
		try
		{

			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(Config.FILE_NAME));
			for (Person person : personAL)
			{
				output.writeObject(person);
			} 
			output.close();
		} catch (Exception e)
		{
			// TODO: handle exception
			System.out.println("An Error Occured");
			e.printStackTrace();
		}
		return;
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
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(Config.FILE_NAME));
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
			
			personIDCounter = (pAL.get(pAL.size()-1).getIdNum()+1);
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
