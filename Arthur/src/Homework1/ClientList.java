package Homework1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class: ClientList.java
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
public class ClientList
{
	/**
	 * @param args
	 */
	static ArrayList<Pets> listOfPets = new ArrayList<Pets>();


	public static void main(String[] args)
	{

		ClientList cl = new ClientList();
		cl.whichPet(listOfPets);
		cl.menu(listOfPets);
	}

	public void promptUser()
	{
		String input = "";
		while(!input.equals("quit"))
		{
			input = userInput();
		}
	}

	public void addPet(String petType)
	{		
		if(petType.equalsIgnoreCase("cat"))
		{
			System.out.println("Enter Pet Name");
			String petName = userInput();

			System.out.println("Enter Owner Name");
			String ownersName = userInput();

			System.out.println("Enter Pet Age");
			String age = userInput();
			int ageInt = Integer.parseInt(age);

			System.out.println("Enter Pet Type");
			String type = userInput();

			System.out.println("Enter True or False\n"
					+ "Does your pet have long hair?");
			String isLongHaired = userInput();
			boolean longHair = Boolean.parseBoolean(isLongHaired);

			System.out.println("Enter True or False\n"
					+ "Does your pet have claws?");
			String isClawed = userInput();
			boolean clawed = Boolean.parseBoolean(isClawed);

			System.out.println("Enter Pet Color");
			String color = userInput();

			//make new cat
			Cat tempCat = new Cat(petName, ownersName, ageInt, type, longHair, clawed, color);

			//add to AL
			listOfPets.add(tempCat);

		}

		else if(petType.equalsIgnoreCase("dog"))
		{

		}

		else if(petType.equalsIgnoreCase("other"))
		{

		}

		else if(petType.equalsIgnoreCase("exit"))
		{

		}

		else
		{
			System.out.println("Invalid Input, Please Try Again.");
		}
	}

	public void commands()
	{
		System.out.println("List of Command\n"
				+ "Add a pet: add\n"
				+ "Remove a pet: remove\n"
				+ "Save file: save\n"
				+ "View records: view(I ADDED THIS ARTHUR< CAPS TO LETT YOU SEE IT>\n"
				+ "Quit program: quit\n");
	}

	public Pets findPet(ArrayList<Pets> listOfPets)
	{
		Pets pet = new Pets();
		String find = userInput();
		String current = "";
		int counter = 0;

		while(!find.equals(current) && counter < listOfPets.size())
		{
			if(current.equalsIgnoreCase(listOfPets.get(counter).getPetName()))
			{
				pet = listOfPets.get(counter);
				counter ++;
			}

		}

		if(find.equals(""))
		{
			System.out.println("No records found");
		}

		else
		{
			System.out.println(find);
		}

		System.out.println(listOfPets);
		saveFile(listOfPets);
		return pet;
	}

	public void menu(ArrayList<Pets> listOfPets)
	{
		boolean finish = false;

		while (finish != true)
		{
			commands();
			String uP = userInput();

			if (uP.equalsIgnoreCase("add"))
			{
				while(true)
				{
					System.out.println("To add a cat: cat\n"
							+ "To add a dog: dog\n"
							+ "To add something else: other\n"
							+ "To exit: exit\n");
					System.out.println("Please type the type of pet you wish to add:");
					uP = userInput();
					if(uP.equalsIgnoreCase("cat"))
						addPet(uP);
					else if(uP.equalsIgnoreCase("dog"))
						addPet(uP);
					else if(uP.equalsIgnoreCase("other"))
						addPet(uP);
					else if(uP.equalsIgnoreCase("exit"))
						break;					
					else
					{
						System.out.println("Invalid Input. Please try again.");
					}
				}
			}


			else if(uP.equalsIgnoreCase("remove"))
			{
				removePet(listOfPets);
			}

			else if(uP.equalsIgnoreCase("save"))
			{
				saveFile(listOfPets);
			}

			else if(uP.equalsIgnoreCase("quit"))
			{
				System.out.println("Thank you for using this program");
				finish = true;
			}

			else if(uP.equalsIgnoreCase("view"))
			{
				view();
			}

			else
			{
				System.out.println("Invalid Input, Please try again.");
			}
		}
	}

	public Pets removePet(ArrayList<Pets> listOfPets)
	{
		Pets pet = new Pets();
		String find = userInput();
		String current = "";
		int counter = 0;

		while(!find.equals(current) && counter < listOfPets.size())
		{
			if(current.equalsIgnoreCase(listOfPets.get(counter).getPetName()))
			{
				pet = listOfPets.get(counter);
				listOfPets.remove(counter);
				counter ++;

			}

		}

		if(find.equals(""))
		{
			System.out.println("No records found");
		}

		else
		{
			System.out.println(find);
		}

		System.out.println(listOfPets);
		saveFile(listOfPets);
		return pet;
	}

	public void saveFile(ArrayList<Pets> listOfPets)
	{
		try
		{
			PrintWriter pW = new PrintWriter("newPetsList.txt");
			System.out.println("New List saved to " + pW);

			for(Pets pets2 : listOfPets)
			{
				pW.println(pets2);
			}
		} 

		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	public String userInput()
	{
		Scanner SC = new Scanner(System.in);
		String input = SC.nextLine();
		return input;
	}

	public void view()
	{
		System.out.println("Here are all pets on record.");

		for (Pets pets : listOfPets)
		{
			System.out.println(pets);
		}

		System.out.println("Listing finished");
	}

	public void whichPet(ArrayList<Pets> listOfPets)
	{
		System.out.println("You must a File not Found Execption"
				+ " for Scanner when searching for a document\n"
				+ "Also, to have try catch in a method. ");
		try
		{
			File OpenFile = new File("PetList.txt");
			Scanner SC = new Scanner(OpenFile);


			while(SC.hasNextLine())
			{
				String next = SC.nextLine();
				String[] split = next.split(",");

				if(split.length == 7)
				{
					Cat cats = new Cat(split[0].trim(), split[1].trim(), Integer.parseInt(split[2].trim()), split[3].trim(), Boolean.parseBoolean(split[4].trim()), Boolean.parseBoolean(split[5].trim()), split[6].trim());
					listOfPets.add(cats);
				}

				else if(split.length == 6)
				{
					Dog dogs = new Dog(split[0].trim(), split[1].trim(), Integer.parseInt(split[2].trim()), split[3].trim(), split[4].trim(), split[5].trim());
				}

				else if(split.length == 5)
				{
					Others others = new Others(split[0].trim(), split[1].trim(), Integer.parseInt(split[2].trim()), split[3].trim(), Boolean.parseBoolean(split[4].trim()));
				}

				else
				{
					System.out.println("No Pets Found");
				}
			}
			SC.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("the File Does not Exist.");

		}
		catch(Exception e)
		{
			System.out.println("Another Error has occured."
					+ "\nStack Trace to follow:");
			e.printStackTrace();
		}

	}
}