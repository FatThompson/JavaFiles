/**
 * Class: RandomMovementModule.java
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

import javafx.application.Platform;
import javafx.scene.image.ImageView;

/**
 * @author User
 *	Designed to move an image randomly about the screen. 
 */
public class RandomMovementModule implements Runnable
{
	private int speedMultiplier;
	private ImageView shape;
	private double coordinateX, coordinateY;



	public RandomMovementModule(ImageView image)
	{
		setCoordinateX(0);
		setCoordinateY(0);
		setSpeedMultiplier(1);
		setImage(image);
	}
	/**
	 * @param coordinateX
	 * @param coordinateY
	 * @param speedMultiplier
	 * @param image
	 */
	public RandomMovementModule(double coordinateX, double coordinateY, int speedMultiplier, ImageView image)
	{
		setCoordinateX(coordinateX);
		setCoordinateY(coordinateY);
		setSpeedMultiplier(speedMultiplier);
		setImage(image);
	}

	public void setCoordinateX(double coordinateX)
	{
		this.coordinateX = coordinateX;
	}

	public void setCoordinateY(double coordinateY)
	{
		this.coordinateY = coordinateY;
	}

	public void setSpeedMultiplier(int speedMultiplier)
	{
		this.speedMultiplier = speedMultiplier;
	}

	/**
	 * @param image2
	 */
	private void setImage(ImageView image)
	{
		this.shape = image;
		shape.setFitWidth(Config.RANDOM_CONTAINTER_IMAGE_FIT_WIDTH);
		shape.setFitHeight(Config.RANDOM_CONTAINTER_IMAGE_FIT_HEIGTH);

	}

	@Override
	public void run()
	{
		try
		{
			while (true)
			{
				Thread.sleep(1000/speedMultiplier);

				//create new random place to spawn
				coordinateX = Math.random() * (Config.RANDOM_CONTAINER_WIDTH - shape.getFitWidth());
				coordinateY = Math.random() * (Config.RANDOM_CONTAINER_HEIGHT - shape.getFitHeight());
				System.out.println("new x = " + coordinateX + ", new y = " + coordinateY + ".");
				
				//set the new places
				shape.setX(coordinateX);
				shape.setY(coordinateY);
				
				// launch a Java FX update thread
				Platform.runLater(new Runnable()
				{
					@Override
					public void run()
					{
						shape.setX(coordinateX);
						shape.setY(coordinateY);
					}
				});


			}
		} catch (InterruptedException ex)
		{
			// do nothing just stop moving the shape
		}

	}
}
