/**
 * Class: InventoryReader.java
 * @author Matthew Thompson
 * @version 1.1
 * Course : ITEC 3150 Spring 2016
 * Written: Jan 16, 2016
 *
 *
 * This class is the main scanner input for users. 
 * It contains most of the methods, and enables for the program to function.
 * Purpose: – Describe the purpose of this class 
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class InventoryReader
{
	private static String DEFAULT_FILE_NAME = "inventory.txt",DEFAULT_QUIT = "QUIT", 
			PARSE_CODE = ", ";//,DEFAULT_SORT = "petID"; I want to implement 
	private static Enum<Commands> DEFAULT_COMMAND = Commands.HELP;
	private static int IDCounter;
	private FileReader fileReader;
	private Scanner sc;
	private PrintWriter printWriter;

	/**
	 * constructor prepares items
	 */
	public InventoryReader()
	{
		fileReader = null;
		sc = null;
		printWriter = null;
	}


	/**
	 * prepares string for the new items
	 * @param inventoryList
	 * @param s
	 * @return
	 */
	public ArrayList<Pet> add(ArrayList<Pet> inventoryList, String s)
	{
		String[] sa = s.split(PARSE_CODE);
		return add(inventoryList, sa);
	}

	/**
	 * Add a pet to the active inventory
	 * @param inventoryList
	 * @param sa
	 * @return inventory with new item
	 */
	public ArrayList<Pet> add(ArrayList<Pet> inventoryList, String[] sa)
	{ 
		IDCounter++;
		for (int i = 0; i < sa.length; i++) 
		{
			sa[i] = sa[i].trim();
		}
		if(sa[0].trim().equalsIgnoreCase("Cat") && sa.length == 8)
		{
			inventoryList.add(new Cat_Pet(sa[1],IDCounter+"",sa[3],sa[4],sa[5],sa[6],sa[7]));
			System.out.println("Cat Pet found.");
		}
		else if(sa[0].trim().equalsIgnoreCase("Dog") && sa.length == 7)
		{
			inventoryList.add(new Dog_Pet(sa[1],IDCounter+"",sa[3],sa[4],sa[5],sa[6]));
			System.out.println("Dog Pet found.");
		}
		else if(sa.length == 7)
		{
			inventoryList.add(new Other_Pet(sa[1],sa[2],IDCounter+"",sa[4],sa[5],sa[6]));
			System.out.println("Other Pet found.");
		}
		else 
		{
			IDCounter--;
			printCommand(Commands.ADD);

			System.out.println("Unreconized type");
			System.out.println("You entered: ");
			System.out.print("add, ");
			for (int i = 0; i < sa.length - 1; i++)
			{
				System.out.print(sa[i]+ ", ");
			}
			System.out.println(sa[sa.length - 1]);
		}

		return inventoryList;
	}

	/**
	 * Finds things in the list provided. 
	 * @param searchlist
	 * @param searchCritria
	 * @return listFound
	 */
	public ArrayList<Pet> find(ArrayList<Pet> searchlist, String searchCritria)
	{
		ArrayList<Pet> listFound = new ArrayList<Pet>();
		searchCritria = searchCritria.toUpperCase();
		for (int i = 0; i < searchlist.size() ; i++)
		{
			if(searchlist.get(i).getPetID().toUpperCase().contains(searchCritria)        ||
					searchlist.get(i).getPetName().toUpperCase().contains(searchCritria) ||
					searchlist.get(i).getAge().toUpperCase().contains(searchCritria))
			{
				listFound.add(searchlist.get(i));
				System.out.println(searchlist.get(i));
			}
		}
		if(listFound.isEmpty())
			System.out.println("No Records Found Containing: '" + searchCritria + "'");
		return listFound;
	}

	/**
	 * gets a confirmation of y*
	 * @return boolean of yes/n
	 */
	public boolean getConfirmation()
	{
		String s = getUserInput();
		if(s.length() > 0)
			if(s.substring(0,1).equalsIgnoreCase("y"))
				return true;
		System.out.println("Action Cancled by user");
		return false;
	}
	/**
	 * get the input from the keyboard. 
	 * Closing it glitches, why is this? 
	 * 
	 * @return userInputInLines
	 */
	public String getUserInput()
	{

		System.out.println("\n");

		@SuppressWarnings("resource")
		Scanner keyboardInput = new Scanner(System.in);
		String lineEntered = keyboardInput.nextLine();
		return lineEntered;
	}


	/**
	 * prints all commands
	 */
	public void printCommand()
	{
		printCommand(DEFAULT_COMMAND);
		return;
	}
	/**
	 * Prints commands
	 * @param command
	 */
	public void printCommand(Enum<Commands> command)
	{

		if(command.equals(DEFAULT_COMMAND))
			System.out.println("\nCommands Avaliable \n");
		System.out.println("The \", \" are needed for commands.");
		System.out.println("Ie \'find, Jim\' with find pets named Jim.");
		if(command.equals(Commands.HELP)||command.equals(DEFAULT_COMMAND))
		{
			System.out.println("\nFor command list:");
			System.out.println("help");
		}
		if(command.equals(Commands.ADD)||command.equals(DEFAULT_COMMAND))
		{
			System.out.println("\nTo add a pet");
			System.out.println("add, Cat,     Owner Name, Pet Name, Age, Short Hair(True/False), Declawed(True/False), Color");
			System.out.println("add, Dog,     Owner Name, Pet Name, Age, Breed,                  Color");
			System.out.println("add, Other, Species, Owner Name, Pet Name, Age, Needs Special Care(True/False)");
		}
		if(command.equals(Commands.FIND)||command.equals(DEFAULT_COMMAND))
		{
			System.out.println("\nTo find a pet:");
			System.out.println("find,   petID OR Pet Name");
		}
		if(command.equals(Commands.OPEN)||command.equals(DEFAULT_COMMAND))
		{
			System.out.println("\nTo open a new inventory:");
			System.out.println("open, file location");
		}
		if(command.equals(Commands.REMOVE)||command.equals(DEFAULT_COMMAND))
		{
			System.out.println("\nTo remove a pet:");
			System.out.println("remove, petID OR Pet Name");
		}
		if(command.equals(Commands.SAVE)||command.equals(DEFAULT_COMMAND))
		{
			System.out.println("\nTo save the active inventory");
			System.out.println("save,   file location, confirmation[y/n]");
		}
		if(command.equals(Commands.VIEW)||command.equals(DEFAULT_COMMAND))
		{
			System.out.println("\nTo view all records");
			System.out.println("view");
		}
		if(command.equals(Commands.QUIT)||command.equals(DEFAULT_COMMAND))
		{
			System.out.println("\nTo quit.");
			System.out.println("quit");
		}
	}


	/**
	 * Prints all the records in the database
	 * @param inventoryList
	 */
	public void printRecords(ArrayList<Pet> inventoryList)
	{
		for (Pet pet : inventoryList)
		{
			System.out.print(pet);
		}
	}

	/**
	 * Waits for user input
	 */
	public void promptListener(ArrayList<Pet> inventoryList)
	{
		promptListener(inventoryList,"");
	}

	/**
	 * enables for terminating the program
	 * @param inventoryList
	 * @param s
	 */
	public void promptListener(ArrayList<Pet> inventoryList, String s)
	{
		while(!s.trim().equalsIgnoreCase(DEFAULT_QUIT))
		{
			s = getUserInput();
			readLine(inventoryList, s);
		}
		System.out.println("The Program has successfully closed.");
	}

	/**
	 * Saving
	 */
	public void quit(ArrayList<Pet> inventoryList, String line)
	{
		System.out.print("do you want to save?(Will save to default location)[y/n]: ");
		if(getConfirmation())
		{
			save(inventoryList,DEFAULT_FILE_NAME, true);
			System.out.println("Program Closed Successfully");
			System.exit(0);
		}

		System.out.println("Quiting without saving..");

		System.exit(0);
		//promptListener(inventoryList, DEFAULT_QUIT);



	}

	/**
	 * @param Will search for the default file
	 * @return the Inventory of pets found
	 */
	public ArrayList<Pet> readFile()
	{
		return readFile(DEFAULT_FILE_NAME);
	}

	/**
	 * for opening a new file
	 * @param inventoryList
	 * @return
	 */
	public ArrayList<Pet> readFile(ArrayList<Pet> inventoryList)
	{
		System.out.print("do you want to Open a new file?\n"
				+ "(It will remove anychanges made.)[y/n]: ");
		String s = new String();
		if(getConfirmation())
		{
			System.out.print("What do you want to open?"
					+ "\n"+DEFAULT_FILE_NAME+" ");
			s = getUserInput();
			try
			{
				if(s.trim().equals(""))
				{
					System.out.println("No input detected. Canceling.");
					System.out.println("Action canceled by system.");
				}
				else
				{
					fileReader = new FileReader(s);
					return readFile(s);
				}
			}
			catch (FileNotFoundException fnfe)
			{
				System.out.println("File does not exist.");
			}
			catch (NullPointerException npe)
			{
				System.out.println("File does not exist.");
			}
		}
		else
		{
			System.out.println("Would you like to open the defaul location instead.");
			s = getUserInput();
			if(getConfirmation())
				try
			{
					fileReader = new FileReader(DEFAULT_FILE_NAME);
					return readFile(DEFAULT_FILE_NAME);
			}
			catch (FileNotFoundException fnfe)
			{
				System.out.println("File does not exist.");
			}
			else
				System.out.println("New Inventory File Opening Canceled by User.");
		}
		return inventoryList;
	}

	/**
	 * for opening files
	 * @param fileName of file to search
	 * @return the Inventory of pets found
	 */
	public ArrayList<Pet> readFile(String fileName)
	{

		IDCounter = 0;
		ArrayList<Pet> inventoryList = new ArrayList<Pet>();
		try
		{
			fileReader = new FileReader(fileName);
			sc = new Scanner(fileReader);

			System.out.println("Opening file...\n\n");
			while(sc.hasNextLine())
			{
				add(inventoryList, sc.nextLine());
			}
			System.out.println("\n\nFile has been succesfully loaded.\n\n");
		}
		catch (FileNotFoundException fnfe)
		{
			System.out.println("No file found for "+fileName+"."
					+ "\nA blank inventory has been created.");
			return new ArrayList<Pet>();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}


		System.out.println("\n\nRun Help for Command List");
		return inventoryList;
	}

	/**
	 * used for reading lines in the scanner
	 * @param inventoryList
	 * @param line material entered
	 * @return
	 */
	public ArrayList<Pet> readLine(ArrayList<Pet> inventoryList,String line)
	{
		//for none tokenize-able entries
		if (!line.contains(","))
		{
			if(line.trim().equals(""))
				printCommand();
			else if(line.trim().equalsIgnoreCase(Commands.ADD.toString()))
			{
				printCommand(Commands.ADD);
			}
			else if(line.trim().equalsIgnoreCase(Commands.QUIT.toString()))
				quit(inventoryList, line);
			else if(line.trim().equalsIgnoreCase(Commands.SAVE.toString()))
				save(inventoryList);
			else if(line.trim().equalsIgnoreCase(Commands.HELP.toString()))
				printCommand();
			else if(line.trim().equalsIgnoreCase(Commands.REMOVE.toString()))
				printCommand(Commands.REMOVE);
			else if(line.trim().equalsIgnoreCase(Commands.FIND.toString()))
				printCommand(Commands.FIND);
			else if(line.trim().equalsIgnoreCase(Commands.VIEW.toString()))
				printRecords(inventoryList);
			else if(line.trim().equalsIgnoreCase(Commands.SORT.toString()))
				sort(inventoryList);
			else if(line.trim().equalsIgnoreCase(Commands.OPEN.toString()))
				readFile(inventoryList);
			else
			{
				System.out.println("Unreconized Command.");
				printCommand();
			}


		}
		//for tokens
		else 
		{
			String[] sa = line.split(PARSE_CODE);


			if(sa[0].equalsIgnoreCase(Commands.HELP.toString()) ||sa[0].equalsIgnoreCase("?"))
			{
				printCommand();
				return inventoryList;
			}
			else if(sa[0].equalsIgnoreCase(Commands.ADD.toString()) && sa.length > 1)
			{
				line = line.substring(sa[0].length() + PARSE_CODE.length());
				return add(inventoryList, line);
			}
			else if(sa[0].equalsIgnoreCase(Commands.ADD.toString()) && sa.length < 1)
			{
				printCommand(Commands.ADD);
				return inventoryList;
			}
			else if(sa[0].equalsIgnoreCase(Commands.FIND.toString()) && sa.length > 1)
			{
				line = line.substring(sa[0].length() + PARSE_CODE.length());
				return find(inventoryList, line);
			}
			else if(sa[0].equalsIgnoreCase(Commands.FIND.toString()) && sa.length < 1)
			{
				printCommand(Commands.FIND);
			}
			else if(sa[0].equalsIgnoreCase(Commands.OPEN.toString()) && sa.length > 1)
			{
				return readFile(inventoryList);
			}
			else if(sa[0].equalsIgnoreCase(Commands.REMOVE.toString()) && sa.length > 1)
			{
				line = line.substring(sa[0].length() + PARSE_CODE.length());
				return remove(inventoryList, line);
			}
			else if(sa[0].equalsIgnoreCase(Commands.REMOVE.toString()) && sa.length < 1)
			{
				printCommand(Commands.REMOVE);
			}
			else if(sa[0].equalsIgnoreCase(Commands.SAVE.toString()) && sa.length > 1)
			{
				line = line.substring(sa[0].length() + PARSE_CODE.length());
				save(inventoryList, line);
			}
			else if(sa[0].equalsIgnoreCase(Commands.SAVE.toString()) && sa.length < 1)
			{
				printCommand(Commands.SAVE);
			}
			else if(sa[0].equalsIgnoreCase(Commands.SORT.toString()) && sa.length < 1)
				sort(inventoryList);
			else if(sa[0].equalsIgnoreCase(Commands.QUIT.toString()) && sa.length > 1)
			{
				line = line.substring(sa[0].length() + PARSE_CODE.length());
				quit(inventoryList, line);
			}
			else if(sa[0].equalsIgnoreCase(Commands.VIEW.toString()) && sa.length > 1)
			{
				printRecords(inventoryList);
			}
			else
				System.out.println("Unreconized Command.");
		}
		return inventoryList;
	}

	/**
	 * Removes selected items
	 * @param inventoryList
	 * @param searchCritria
	 * @return
	 */
	public ArrayList<Pet> remove(ArrayList<Pet> inventoryList, String searchCritria)
	{
		ArrayList<Pet> foundThings = find(inventoryList, searchCritria);
		if(!foundThings.isEmpty())
		{
			System.out.println("Are you sure you want to remove the selected records?[y/n]");
			if(getConfirmation())
			{
				for (int i = 0; i < foundThings.size(); i++)
				{
					for (int j = 0; j < inventoryList.size(); j++)
					{
						if(inventoryList.get(j).equals(foundThings.get(i)))
						{
							System.out.println("\nRemoved: "+foundThings.get(i));
							inventoryList.remove(j);

						}
					}
				}
			}
			else 
			{
				System.out.println("Removal Canceled by User.");
			}
		}
		return inventoryList;
	}


	/**
	 * For saving the files
	 * @param inventoryList
	 */
	public void save(ArrayList<Pet> inventoryList)
	{

		save(inventoryList, DEFAULT_FILE_NAME);

	}

	/**
	 * Saves at a certain location and gets a confirmation
	 * @param inventoryList
	 * @param saveLocation
	 */
	public void save(ArrayList<Pet> inventoryList, String saveLocation)
	{
		System.out.println("Do you wish to save at '"+saveLocation+"'?[y/n]");
		if(getConfirmation())
			save(inventoryList, saveLocation, true); 
		else
			System.out.println("Saving Cancled by user");
	}

	/**
	 * actually saves the active inventory into a file. 
	 * @param inventoryList
	 * @param saveLocation
	 * @param confirmation
	 */
	public void save(ArrayList<Pet> inventoryList, String saveLocation, boolean confirmation)
	{
		if(confirmation)
		{
			try
			{
				printWriter = new PrintWriter(saveLocation);
				System.out.println("Saving Location: " + saveLocation);
				System.out.println("Saving...");

				for (Pet pet : inventoryList)
					printWriter.println(pet.toString("save"));

				System.out.println("Saving finished.");
			}
			catch(IOException ioe)
			{
				ioe.printStackTrace();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				try
				{
					printWriter.close();
					sc.close();
					fileReader.close();
				} 
				catch (IOException iOE)
				{
					iOE.printStackTrace();
					System.out.println("Error on Close");
				}

				catch (NullPointerException nPE)
				{
					nPE.printStackTrace();
					System.out.println("Error reading no data");
				}

				catch (Exception e)
				{
					e.printStackTrace();
					System.out.println("Error Found");
				}
			}
		}
	}
	/**
	 * Sorts the pets based on the Class of the pet.
	 * @param pet
	 * @return
	 */
	public ArrayList<Pet> sort(ArrayList<Pet> pet)
	{
		System.out.println("Sorting by Pet Type....");
		Collections.sort(pet, Pet.sortBy);
		System.out.println("Sorting Finished.");
		return pet;
	}
}