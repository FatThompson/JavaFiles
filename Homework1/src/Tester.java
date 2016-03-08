import java.util.ArrayList;

/**
 * Class: Tester.java
 * @author Matthew Thompson
 * @version 1.0
 * Course : ITEC 3150 Spring 2016
 * Written: Jan 16, 2016
 *
 *
 * This class – now describe what the class does
 *
 * Purpose: – Describe the purpose of this class 
 */

/**
 * Launches the user prompt
 */
public class Tester
{
	/**
	 * main method that launches prompt
	 * @param args
	 */
	public static void main(String[] args)
	{

		InventoryReader ir = new InventoryReader();
		ArrayList<Pet> gameInventoryList = ir.readFile();
		ir.promptListener(gameInventoryList);
	}

}

