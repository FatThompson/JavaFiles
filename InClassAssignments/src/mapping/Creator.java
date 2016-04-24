package mapping;
import java.util.Random;

import javafx.scene.paint.Color;


/**
  This class adds random Double values to a binary search tree one every second
*/
public class Creator implements Runnable
{
   private static final int DELAY = 2000; 
   private MyHashMap<String, Color> map;
   private String[] nameArray =
	    { "Fred Flintstone", "Homer Simpson", "George Jetson", "Super Man",
	            "Bat Man", "Iron Man", "Captain America", "Papa Smurf",
	            "Peter Griffin" };
   private Color[] colorArray =
	    { Color.RED, Color.BLACK, Color.BLUE, Color.YELLOW, Color.BEIGE,
	            Color.BROWN, Color.MAGENTA, Color.ORANGE };
 
   Random rand ;

   /**
      Constructs a add runnable
      @param aTree- the tree to add to
      @param aCount the number of repetitions to add
   */
   public Creator(MyHashMap<String, Color> aMap)
   {
     map = aMap;
   
     
      rand = new Random();
   }

   /* starting point for the thread */
   public void run()
   {
      try
      {
        for (int i = 0; i< nameArray.length; i++)
         {
           // generate a random Double
        	//colors are only 6 i thought?
        	int newValue = rand.nextInt(8);
            map.put(nameArray[i], colorArray[newValue]);
            System.out.println();
        	System.out.println("Adding key of " + nameArray[i] + " with value of " + Color.valueOf(colorArray[newValue].toString()));
            Thread.sleep(DELAY);
         }
      }
      catch (InterruptedException exception) {}
   }
}

