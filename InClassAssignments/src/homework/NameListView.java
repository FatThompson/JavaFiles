package homework;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;

public class NameListView extends Application
{
	// Declare an array of Strings for names
	private String[] nameArray =
		{ "Fred Flintstone", "Homer Simpson", "George Jetson", "Super Man",
				"Bat Man", "Iron Man", "Captain America", "Papa Smurf",
		"Peter Griffin" };
	private List<String> nameList = new ArrayList();
	// Declare an array of 8 colors
	private Color[] colorArray =
		{ Color.RED, Color.BLACK, Color.BLUE, Color.YELLOW, Color.BEIGE,
				Color.BROWN, Color.MAGENTA, Color.ORANGE };
	// observable list for list view
	ObservableList<String> obNameList;

	@Override
	// Override the start method in the Application class
	public void start(Stage primaryStage)
	{


		// convert array to arrayList
		nameList.addAll(Arrays.asList(nameArray));
		obNameList = FXCollections.observableArrayList(nameList);

		ScrollPane scrollP = new ScrollPane();
		// create a ListView to display the values in nameList. Make it single
		// selection and add into scrollP

		ListView listNames = new ListView(FXCollections.observableList(obNameList));
		listNames.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

		scrollP.setContent(listNames);
		
		// Create a pane to hold image views
		FlowPane imagePane = new FlowPane(10, 10);
		BorderPane pane = new BorderPane();
		pane.setLeft(scrollP);
		pane.setCenter(imagePane);

		// Create a shape of your choosing and add to imagePane
		Ellipse ellipse = new Ellipse(30,30);
		ellipse.setFill(Color.WHITE);
		ellipse.setStroke(Color.BLACK);
		imagePane.getChildren().add(ellipse);

		// create an event handler that is called when a name is selected in the
		// listView
		// in the handler, get the String selected by the mouse and get its
		// hashCode (hint- it is an int value)
		// Take that int value - h and using a compression function have it
		// return a value between 0 and 7
		// Hint: int index = h % 7;
		// change the fill of the shape you added to imagePane to the color at
		// index in colorArray.

		listNames.getSelectionModel().selectedItemProperty().addListener(ov -> {
			String name = obNameList.get(listNames.getSelectionModel().getSelectedIndex());
			int index = Math.abs(name.hashCode() % colorArray.length);
			ellipse.setFill(colorArray[index]);

		});



		// add button
		Button addButton = new Button("Add a Name");

		pane.setBottom(addButton);

		addButton.setOnAction(e -> launchNewStage());



		Scene scene = new Scene(pane, 600, 170);
		primaryStage.setTitle("Name color demo"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	/**
	 * Method to launch new stage
	 */
	private void launchNewStage()
	{
		new NameStage(this);
	}

	/**
	 * Method to add a name to the array
	 * 
	 */
	public void addAName(String n)
	{
		obNameList.add(n);
	}

	/**
	 * The main method is only needed for the IDE with limited JavaFX support.
	 * Not needed for running from the command line.
	 */
	public static void main(String[] args)
	{
		launch(args);
	}
}
