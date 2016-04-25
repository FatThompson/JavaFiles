/**
 * Class: AnimalListView.java
 * @author Matthew Thompson
 * @version 1.0
 * Course : ITEC 3150 Spring 2016
 * Written: Apr 24, 2016
 *
 *
 * This class – creates a GUI with the animal's and their favorite colors :)
 *
 * Purpose: – Describe the purpose of this class 
 */

package homework.homework5;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import binaryIO.Person;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

/**
 * @author User
 *
 */
public class AnimalListView extends Application
{
	/**
	 * The Global Variables 
	 */
	private ArrayList<Animal> animalArrayList = new ArrayList();
	private Color[] colorArray = {
			Color.BLUE, Color.RED, Color.GREEN, 
			Color.YELLOW, Color.PURPLE, Color.BLACK,
			Color.BROWN, Color.MAGENTA, Color.BEIGE, 
			Color.CYAN
	};
	private Ellipse ellipse;
	private HashMap<Animal, Color> animalColorHashMap;
	private ListView animalsListView;
	private ScrollPane scrollP;

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		launch(args);
	}


	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		// TODO Auto-generated method stub
		buildMainStage(primaryStage);
	}

	/**
	 * Addes an anmial to the list and refresh the ScrollPane
	 * and updates the hashmap
	 * @param animal
	 */
	public void addAnAnimal(Animal animal)
	{
		animalArrayList.add(animal);
		addToAnimalColorHashmap(animal);
		refreshScrollPane();
	}

	/**
	 * builds the stage
	 */
	public void buildMainStage(Stage primaryStage)
	{
		//Initiate ScrollPane
		scrollP = new ScrollPane(); //had to make global

		//read the data from file
		animalArrayList = new ArrayList( readAnimalsFromFile("src/homework/homework5/animal.dat"));

		//add the animals to the hashmap
		System.out.println("Adding animals from data file");
		animalColorHashMap = new HashMap<Animal, Color>();
		
		
		for (Animal animal : animalArrayList)
			addToAnimalColorHashmap(animal);
		
		
		System.out.println("Animals added.");
		//refresh the page with the new data
		refreshScrollPane();

		// Create a pane to hold image views
		FlowPane imagePane = new FlowPane(10, 10);
		BorderPane pane = new BorderPane();
		pane.setLeft(scrollP);
		pane.setCenter(imagePane);

		// Create a shape of your choosing and add to imagePane
		ellipse = new Ellipse(30,30);
		ellipse.setFill(Color.WHITE);
		ellipse.setStroke(Color.BLACK);
		imagePane.getChildren().add(ellipse);

		// add button
		Button addButton = new Button("Add a Name");
		pane.setBottom(addButton);
		addButton.setOnAction(e -> launchNewStage());
		
		//add the scene and show
		Scene scene = new Scene(pane, 600, 170);
		primaryStage.setTitle("Animal's and Their favorite Color"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}


	/**
	 * Method to launch new stage
	 */
	private void launchNewStage()
	{
		new AnimalStage(this);
		refreshScrollPane();
	}

	/**
	 * reads the files
	 * @param string
	 * @return
	 */
	private ArrayList<Animal> readAnimalsFromFile(String fileLocation)
	{

		// TODO Auto-generated method stub
		ArrayList<Animal> animalList = new ArrayList<Animal>();

		try 
		{ // Create an input stream for file object.dat
			System.out.println("Searching for file...");
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(fileLocation));
			System.out.println("File found");

			try
			{
				System.out.println("Creating Animals...");
				while(true)//input.available() > 0)
				{
					Animal animal = (Animal) input.readObject();
					animalList.add(animal);
					//System.out.println( animal);
				}
			}
			catch(EOFException eof)
			{
				System.out.println("Animals have been created");
			}
			finally
			{
				input.close();
			}
		}

		catch(FileNotFoundException fnfe)
		{
			System.out.println("file not found trying the animals.dat");
			/**
			 * This is for in case the file you need does not exist, will grab the default instead.
			 */
			try 
			{ // Create an input stream for file object.dat
				System.out.println("Searching for file...");
				ObjectInputStream input = new ObjectInputStream(new FileInputStream("animals.dat"));
				System.out.println("File found");

				try
				{
					System.out.println("Creating Animals...");
					while(true)//input.available() > 0)
					{
						Animal animal = (Animal) input.readObject();
						animalList.add(animal);
						//System.out.println( animal);
					}
				}
				catch(EOFException eof)
				{
					System.out.println("Animals have been created");
				} catch (ClassNotFoundException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("Animal Class not found");
				}
				finally
				{
					input.close();
				}
			}

			catch(FileNotFoundException fnfe2)
			{
				System.out.println("File is still not found");
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		catch(Exception e)
		{
			System.out.println("other exeption");
		}
		return animalList;
	}

	/**
	 * will be used to refresh the list in the scrollpane
	 */
	private void refreshScrollPane()
	{

		//get animal names for the list
		ArrayList<String> animalNameArrayList = new ArrayList<String>();

		for (Animal animal : animalArrayList)
		{
			//grabbing name from animal, and placing into the 
			//new animal name list
			animalNameArrayList.add(animal.getAnimalName() + " the " + animal.getAnimalBreed());
		}

		//add the animal names to the listview
		animalsListView = new ListView(FXCollections.observableList(animalNameArrayList));
		//set the animal ListView as a per line click
		animalsListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		//set the content as the ListView
		scrollP.setContent(animalsListView);

		//try catch incase of an animal missmatch
		try{
			//implement the map here 
			animalsListView.getSelectionModel().selectedItemProperty().addListener(ov -> {
				//get selected animal from the list
				Animal animal = animalArrayList.get(animalsListView.getSelectionModel().getSelectedIndex());
				//find it's "favorite" color
				ellipse.setFill(animalColorHashMap.get(animal));
			});
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Probably a missmatch between the animalNameArrayList and the animalArrayList");
		}
	}

	/**
	 * for adding in the hashmap
	 * @param animal
	 * @param i
	 */
	private void addToAnimalColorHashmap(Animal animal)
	{
		// TODO Auto-generated method stub
		//add to the mapp here
		int index = Math.abs(animal.hashCode() % colorArray.length);
		Color favoriteColor = colorArray[index];
		//add to the map/implement the map
		animalColorHashMap.putIfAbsent(animal, favoriteColor);
		System.out.println("Adding to hash map: " 
				+ animal.getAnimalName() + "'s favorit color is " 
				+ animalColorHashMap.get(animal).toString());
	}



}
