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
	public void setBtnCreatePerson(Button btnCreatePerson)
	{
		this.btnCreatePerson = btnCreatePerson;
	}
	public void setBtnCancel(Button btnCancel)
	{
		this.btnCancel = btnCancel;
	}
	public TextField getTxtFirstName()
	{
		return txtFirstName;
	}
	public TextField getTxtLastName()
	{
		return txtLastName;
	}
	public TextField getTxtPersonID()
	{
		return txtPersonID;
	}
	public TextField getTxtCity()
	{
		return txtCity;
	}
	public Button getBtnCreatePerson()
	{
		return btnCreatePerson;
	}
	public Button getBtnCancel()
	{
		return btnCancel;
	}
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
		clear();  

		return;
	}
	public void clear()
	{

		txtFirstName.setText(null); 
		txtLastName.setText(null);   
		txtPersonID.setText(null);   
		txtCity.setText(null); 
	}

	/**
	 * @return
	 */
	private Person createPersonButtonClicked()
	{
		System.out.println("create person");

		return createPerson();

	}
	public Person createPerson()
	{
		Person person = new Person();
		String firstName = getTxtFirstName().getText().trim();
		String lastName = getTxtLastName().getText().trim();
		String personID = getTxtPersonID().getText().trim();
		String city = getTxtCity().getText().trim();

		if(firstName!=null &&
				lastName!=null &&
				personID!=null &&
				city!=null)
		{
			person = new Person(getTxtFirstName().getText(),
					getTxtLastName().getText(),
					getTxtPersonID().getText(),
					getTxtCity().getText());
		}

		clear();
		return person;
	}
}