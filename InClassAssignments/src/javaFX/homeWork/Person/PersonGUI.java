package javaFX.homeWork.Person;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.text.*;


public class PersonGUI extends Application
{

	public static void main(String[] args)
	{
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		buildGUI(primaryStage);
	}

	public static void buildGUI(Stage primaryStage)
	{
		System.out.println("Start buidling GUI... \n");


		System.out.println("Creating Scene...");
		Scene scene = new Scene(buildCreatePersonGrid(), 300, 275);
		System.out.println("Scene Created");

		System.out.println("Setting Scene...");
		primaryStage.setScene(scene);
		System.out.println("Scene Set");

		System.out.println("Showing Scene...");
		primaryStage.show();
		System.out.println("Scene Shown");

	}
	public static GridPane buildCreatePersonGrid()
	{
		System.out.println("   Building Person Grid...");
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);


		System.out.println("   Adding Title...");
		Text scenetitle = new Text("Build your person");
		//scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);

		System.out.println("   Add Label for First Name...");
		Label lblFirstName = new Label("First Name:");
		grid.add(lblFirstName, 0, 1);

		System.out.println("   Add txtfield for First Name...");
		TextField txtFirstName = new TextField();
		grid.add(txtFirstName, 1, 1);

		System.out.println("   Add Label for Last Name...");
		Label lblLastName = new Label("Last Name:");
		grid.add(lblLastName, 0, 2);

		System.out.println("   Add txtfield for Last Name...");
		TextField txtLastName = new TextField();
		grid.add(txtLastName, 1, 2);

		System.out.println("   Add Label for Person ID...");
		Label lblPersonID = new Label("Person ID:");
		grid.add(lblPersonID, 0, 3);

		System.out.println("   Add txtfield for Person ID...");
		TextField txtPersonID = new TextField();
		grid.add(txtPersonID, 1, 3);

		System.out.println("   Add Label for the City...");
		Label lblCity = new Label("City:");
		grid.add(lblCity, 0, 4);

		System.out.println("   Add txtfield for the City");
		TextField txtCity = new TextField();
		grid.add(txtCity, 1, 4);

		System.out.println("   Adding Button...");
		Button btnCreatePerson = new Button("Create Person");
		grid.add(btnCreatePerson, 0, 5);

		System.out.println("   Adding Button...");
		Button btnCancel = new Button("Cancel");
		grid.add(btnCancel, 1, 5);

		System.out.println("\nGrid Building Finished");

		return grid;
	}
}
