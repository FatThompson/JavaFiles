package javaFX.homeWork.basicGUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.text.*;


public class PersonGUI //extends Application
{

	private TextField txtFirstName = new TextField();
	private TextField txtLastName = new TextField();
	private TextField txtPersonID = new TextField();
	private TextField txtCity = new TextField();
	private Button btnCreatePerson = new Button("Create Person");
	private Button btnCancel = new Button("Cancel");
	
	
	public PersonGUI()
	{
		
	}
//	public static void main(String[] args)
//	{
//		launch(args);
//
//	}

//	@Override
//	public void start(Stage primaryStage) throws Exception
//	{
//		buildGUI(primaryStage);
//	}

//	public static void buildGUI(Stage primaryStage)
//	{
//		System.out.println("Start buidling GUI... \n");
//
//
//		System.out.println("Creating Scene...");
//		Scene scene = new Scene(buildCreatePersonGrid(), 300, 275);
//		System.out.println("Scene Created");
//
//		System.out.println("Setting Scene...");
//		primaryStage.setScene(scene);
//		System.out.println("Scene Set");
//
//		System.out.println("Showing Scene...");
//		primaryStage.show();
//		System.out.println("Scene Shown");
//
//	}
	public GridPane buildCreatePersonGrid(int y)
	{
		System.out.println("   Building Person Grid...");
		GridPane grid = new GridPane();

		System.out.println("   Add Label for First Name...");
		Label lblFirstName = new Label("First Name:");
		grid.add(lblFirstName, 0, y);

		System.out.println("   Add txtfield for First Name...");
		grid.add(txtFirstName, 1, y);

		System.out.println("   Add Label for Last Name...");
		Label lblLastName = new Label("Last Name:");
		grid.add(lblLastName, 0, ++y);

		System.out.println("   Add txtfield for Last Name...");
		grid.add(txtLastName, 1, y);

		System.out.println("   Add Label for Person ID...");
		Label lblPersonID = new Label("Person ID:");
		grid.add(lblPersonID, 0, ++y);

		System.out.println("   Add txtfield for Person ID...");
		grid.add(txtPersonID, 1, y);

		System.out.println("   Add Label for the City...");
		Label lblCity = new Label("City:");
		grid.add(lblCity, 0, ++y);

		System.out.println("   Add txtfield for the City");
		
		grid.add(txtCity, 1, y);

		System.out.println("   Adding Button...");
		
		btnCreatePerson.setOnAction(e -> createPersonButtonClicked());
		grid.add(btnCreatePerson, 0, ++y);

		System.out.println("   Adding Button...");
		
		btnCancel.setOnAction(e -> cancelButtonClicked());
		grid.add(btnCancel, 1, y);

		System.out.println("\nGrid Building Finished");

		return grid;
	}

	/**
	 * @return
	 */
	private void cancelButtonClicked()
	{
		// TODO Auto-generated method stub
		System.out.println("Cancel");
		
		txtFirstName.setText(null); 
		txtLastName.setText(null);   
		txtPersonID.setText(null);   
		txtCity.setText(null);       
		
		return;
	}

	/**
	 * @return
	 */
	private void createPersonButtonClicked()
	{
		System.out.println("create person");
		
		return;
		
	}
}
