/**
 * Class: FlashText.java
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
import javafx.scene.control.Label;

/**
 * @author User
 *
 */
public class FlashText implements Runnable
{
	private Label text;
	private int delay;
	private boolean visible;
	
	public FlashText(Label flashText, int milliseconds)
	{
		text = flashText;
		delay = milliseconds;
		visible = true;
	}
	
	@Override
	public void run()
	{
		try
		{
			while (true)
			{
				Thread.sleep(delay);
				//change visible's value
				visible = !visible;
				
				Platform.runLater(new Runnable() {
					@Override 
					public void run() {
						text.setVisible(visible);
					}
				});

			}
		}
		catch (InterruptedException ex)
		{
			// do nothing and exit gracefully
		}
	}
}
