package javaFX_MultiThread.given;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ThreadsChangingGui extends Application
{
	private String text = "";

	@Override
	// Override the start method in the Application class
	public void start(Stage primaryStage)
	{
		BorderPane container = new BorderPane();
		StackPane pane = new StackPane();
		Label lblText = new Label("Programming is fun");
		pane.getChildren().add(lblText);
		container.setTop(pane);
		Thread t1 = new Thread(new FlashRunnable(lblText, 200));
		t1.start();

		Pane circlePane = new Pane();
		Image i = new Image("images/mole.png");
		ImageView c = new ImageView(i);
		c.setX(250);
		c.setY(250);
		circlePane.getChildren().add(c);
		Thread t2 = new Thread(new ShapeMoveInCircle(c, 50, 1));
		t2.start();
		container.setCenter(circlePane);

		primaryStage.setOnCloseRequest(e -> {

			t1.interrupt();
			t2.interrupt();
			primaryStage.close();
			System.exit(0);
		});

		// Create a scene and place it in the stage
		Scene scene = new Scene(container, 400,400);
		primaryStage.setTitle("Movement"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
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
