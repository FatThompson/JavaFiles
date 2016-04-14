/**
 * Class: QuizGUI.java
 * @author Matthew Thompson
 * @version 1.0
 * Course : ITEC 3150 Spring 2016
 * Written: Apr 7, 2016
 *
 *
 * This class –
 *
 * Purpose: – Describe the purpose of this class 
 */

package quizes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

/**
 * @author User
 *
 */
public class QuizGUI extends Application
{

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
	/**
	 * creates and launches program
	 * @param primaryStage
	 */
	@Override
	public void start(Stage primaryStage) 
	{
		
		BorderPane mainContanier = new BorderPane();
		mainContanier.setMinSize(300, 350);;
		
		Label txtTopText = new Label("Red when saved");

		mainContanier.setTop(txtTopText);
		
		
		StackPane ellipsePane = new StackPane();
		
		Ellipse ellipse = new Ellipse(60,30);
		ellipse.setFill(Color.WHITE);
		ellipse.setStroke(Color.BLACK);
		Label txtRetcangle = new Label("Rectangle");
		
		ellipsePane.getChildren().addAll(ellipse,txtRetcangle);
		
		mainContanier.setCenter(ellipsePane);
		
		Button btnSave = new Button("Save");
		Button btnClose = new Button("Close");
		
		btnSave.setOnAction(e -> {
			txtTopText.setTextFill(Color.RED);
		});
		
		btnClose.setOnAction(e -> {

			primaryStage.close();
			System.exit(0);
		});
		
		
		GridPane buttonPane = new GridPane();
		buttonPane.add(btnSave, 0, 0);
		buttonPane.add(btnClose, 1, 0);
		
		mainContanier.setBottom(buttonPane);
		
		Scene scene = new Scene(mainContanier);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}

}
