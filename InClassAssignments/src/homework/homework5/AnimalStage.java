/**
 * Class: AnimalStage.java
 * @author Matthew Thompson
 * @version 1.0
 * Course : ITEC 3150 Spring 2016
 * Written: Apr 24, 2016
 *
 *
 * This class – this is a GUI that will call an new animal from the parent
 *
 * Purpose: – Describe the purpose of this class 
 */

package homework.homework5;

import homework.examples.NameListView;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * @author User
 *
 */
public class AnimalStage extends Stage
{

	/**
	 * Constructor
	 * this is a GUI that will call an new animal from the parent
	 * @param parent - reference to calling class so data can be returned
	 */
	public AnimalStage(AnimalListView parent)
	{

		//		Examples of how to build the GUI
		//		// Create a pane and set its properties


		GridPane pane = new GridPane();
		//pane settings
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		pane.setHgap(5.5);
		pane.setVgap(5.5);

		//so if I change things later
		//It will auto set the counters
		int blankPaneCounter = 0;

		//add the animal parts of the GUI

		//animal name
		pane.add(new Label("Animal Name:"), 0, blankPaneCounter);
		TextField animalName = new TextField();
		pane.add(animalName, 1, blankPaneCounter);
		blankPaneCounter++;

		//animal breed
		pane.add(new Label("Animal Breed:"), 0, blankPaneCounter);
		TextField animalBreed = new TextField();
		pane.add(animalBreed, 1, blankPaneCounter);
		blankPaneCounter++;

		//animal age
		pane.add(new Label("Animal Age:"), 0, blankPaneCounter);
		TextField animalAge = new TextField();
		pane.add(animalAge, 1, blankPaneCounter);
		blankPaneCounter++;

		//animal zoo
		pane.add(new Label("Animal Zoo Number:"), 0, blankPaneCounter);
		TextField animalZoo = new TextField();
		pane.add(animalZoo, 1, blankPaneCounter);
		blankPaneCounter++;

		//button for animal
		Button btAdd = new Button("Add Animal");
		pane.add(btAdd, 1, blankPaneCounter);
		GridPane.setHalignment(btAdd, HPos.RIGHT);

		btAdd.setOnAction(e-> 
		{
			//gather animal details
			
			//strings
			String newName = animalName.getText().trim();
			if (newName.equals(""))
				newName = new String("NoName");
			String newBreed = animalBreed.getText().trim();
			if(newBreed.equals(""))
				newBreed = new String("NoBreed");				

			//numbers
			String newAgeString = animalAge.getText().trim();
			newAgeString = newAgeString.replaceAll("\\D", "");
			int newAge = Integer.parseInt("0" + newAgeString);

			String newZooString = animalZoo.getText().trim();
			newZooString = newZooString.replaceAll("\\D", "");
			int newZoo = Integer.parseInt("0" + newZooString);

			//create new animal in the parent class
			System.out.println("Adding new animal...");
			parent.addAnAnimal(new Animal(newName, newBreed, newAge, newZoo)); //based on the animal Details 
			System.out.println("Animal Added; Animal Name: " + newName
					+ ", Animal Breed: " + newBreed 
					+ ", Animal Age: " + newAge
					+ ", Zoo Number: " + newZoo);

			// end pane
			this.close();
		});

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane);
		this.setTitle("Add a Name"); // Set the stage title
		this.setScene(scene); // Place the scene in the stage
		this.show(); // Display the stage
	}

}
