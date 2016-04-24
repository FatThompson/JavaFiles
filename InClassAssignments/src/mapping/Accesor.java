/**
 * Class: Accesor.java
 * @author Matthew Thompson
 * @version 1.0
 * Course : ITEC 3150 Spring 2016
 * Written: Apr 14, 2016
 *
 *
 * This class –
 *
 * Purpose: – Describe the purpose of this class 
 */

package mapping;

import java.util.Set;

import javafx.scene.paint.Color;

/**
 * @author User
 *
 */
public class Accesor implements Runnable
{
	MyHashMap<String, Color> theMap;
	/**
	 * @param theMap
	 */
	public Accesor(MyHashMap<String, Color> theMap)
	{
		this.theMap = theMap;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		try
		{
			//print everything 10 times
			for (int i = 0; i < 10; i++)
			{
				//sleep for two seconds.
				//the same as creator
				Thread.sleep(2000);
				//print the map's values
				Set<String> tempSet = theMap.keySet();
				for (String string : tempSet)
				{
					System.out.println("The key is: "+ string + " and the color is: " + theMap.get(string) );
				}
				//System.out.println(theMap.values());
			}
			
			
		} catch (InterruptedException ex)
		{
			ex.printStackTrace();
		}
		
	}

}
