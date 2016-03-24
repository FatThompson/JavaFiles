/**
 * Class: BasicGUI.java
 * @author Matthew Thompson
 * @version 1.0
 * Course : ITEC 3150 Spring 2016
 * Written: Mar 22, 2016
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
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.text.*;
import javafx.scene.input.KeyCode;


public class BasicGUI extends Application
{
	private PersonGUI personGUI = new PersonGUI();
	private PersonDataGUI personDataGUI = new PersonDataGUI();
	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		//look for file
		
		{
			buildScene(primaryStage);
		}
	}

	/**
	 * The main method is only needed for the IDE with limited
	 * JavaFX support. Not needed for running from the command line.
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
	public  void buildScene(Stage primaryStage)
	{
		System.out.println("Start buidling GUI... \n");

		System.out.println("Creating Scene...");

		System.out.println("MainPaneCreating...");
		GridPane grpMain = new GridPane();
		grpMain.setAlignment(Pos.CENTER);
		grpMain.setHgap(10);
		grpMain.setVgap(10);

		//Will Add a title later. 
		System.out.println("   Adding Title...");
		Text scenetitle = new Text("Title");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 16));
		grpMain.add(scenetitle, 0, 0, 2, 1);

		System.out.println("Create person Creation Pane");
		grpMain.add(personGUI.buildCreatePersonGrid(0), 0, 1);
		System.out.println("Person Creation Pane created.");

		


		grpMain.add(personDataGUI.createPersonData(), 1, 1);



		System.out.println("MainPane Created.");
		Scene scene = new Scene(grpMain);
		System.out.println("Scene Created");




		System.out.println("Setting Scene...");
		primaryStage.setScene(scene);
		System.out.println("Scene Set");

		System.out.println("Showing Scene...");
		primaryStage.show();
		System.out.println("Scene Shown");

	}
}
