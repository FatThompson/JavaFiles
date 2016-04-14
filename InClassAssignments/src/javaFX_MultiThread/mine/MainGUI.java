/**
 * Class: MainGUI.java
 * @author Matthew Thompson
 * @version 1.0
 * Course : ITEC 3150 Spring 2016
 * Written: Apr 6, 2016
 *
 *
 * This class –
 *
 * Purpose: – Describe the purpose of this class 
 */

package javaFX_MultiThread.mine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author User
 *
 */
public class MainGUI extends Application
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
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		//Main Pane
		GridPane container = new GridPane();
		
		//thread 1, adding a new pane to create the RandomMovemnetModule
		Pane randomContainer = new Pane();

		randomContainer.minHeight(Config.RANDOM_CONTAINER_HEIGHT);
		randomContainer.minWidth(Config.RANDOM_CONTAINER_WIDTH);
		
		ImageView particle = new ImageView(Config.RANDOM_CONTAINER_IMAGE);
		particle.setX(0);
		particle.setY(0);
		randomContainer.getChildren().add(particle);
		Thread t1 = new Thread(new RandomMovementModule(particle.getX(), particle.getY() ,1, particle));
		t1.start();
		

		//add the randomConatiner to the Main contaner
		container.add(randomContainer,1,1,2,2);
		
		
		//thread 2, creating pane from Flash Text
		Label particleText = new Label(Config.FLASHING_TEXT);
		container.add(particleText, 0, 0);
		Thread t2 = new Thread(new FlashText(particleText, 200));
		t2.start();
		
		
		
		//set stage onCloseRequest
		primaryStage.setOnCloseRequest(e -> {
			//interrupt all threads 
			t1.interrupt();
			t2.interrupt();

			//close Stage
			primaryStage.close();
			System.exit(0);
		});

		// Create a scene and place it in the stage
		Scene scene = new Scene(container, Config.MAIN_CONTAINER_HEIGHT, Config.MAIN_CONTAINER_WIDTH);
		primaryStage.setTitle("Movement"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

	}

}
