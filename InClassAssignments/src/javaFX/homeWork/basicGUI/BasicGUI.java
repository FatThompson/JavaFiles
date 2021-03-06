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


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


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
		//just creates fake data
		//BinaryIOObjectOutput.createPeopleDat();
		

		buildScene(primaryStage);

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


		System.out.println("MainPaneCreating...");
		GridPane grpMain = new GridPane();
		grpMain.setAlignment(Pos.CENTER);
		grpMain.setHgap(10);
		grpMain.setVgap(10);

		//Will Add a title later. 
		System.out.println("   Adding Title...");
		Text scenetitle = new Text(Config.BASIC_GUI_TITLE);
		scenetitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 16));
		grpMain.add(scenetitle, 0, 0, 2, 1);

		System.out.println("Create person Creation Pane");
		grpMain.add(personGUI.buildCreatePersonGrid(0), 0, 1);

		personGUI.getBtnCreatePerson().setOnAction(e -> createPerson());

		System.out.println("Creating PersonDataField...");
		grpMain.add(personDataGUI.createPersonDataField(), 1, 1);


		System.out.println("Create Scene");
		Scene scene = new Scene(grpMain);



		System.out.println("Setting Scene...");
		primaryStage.setScene(scene);

		System.out.println("Showing Scene...");
		primaryStage.show();

	}

	/**
	 * Will create person based on data from personGUI fields,
	 * then will insert into the ArrayList in the PersonDataGUI's textarea (txa)
	 * then refresh.
	 * @return void
	 */
	private void createPerson()
	{
		// TODO Auto-generated method stub
		
		Person person = personGUI.createPerson();
		personDataGUI.add(person);

		
		return;
	}
}
