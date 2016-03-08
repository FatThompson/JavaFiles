/**
 * Class: Commands.java
 * @author Matthew Thompson
 * @version 1.0
 * Course : ITEC 3150 Spring 2016
 * Written: Jan 16, 2016
 *
 *
 * This class – All Avalible commands
 *
 * Purpose: – Need to learn how to loop through list
 */

public enum Commands
{
	ADD, REMOVE, FIND, SAVE, SORT, OPEN, HELP,QUIT, VIEW;
	
	
	/**
	 * Adds a to string
	 */
	@Override 
	public String toString() 
	{
		String s = super.toString();
		return s.toLowerCase();
	}
}
