package MultiThreading;
import java.util.Random;


/**
   This class periodically removes the smallest value in a binary search tree
*/
public class RemoveFromTree implements Runnable
{

   private BST<Double> tree;
   private long newValue;
   private int count;
   Random rand ;

   /**
      Constructs a deposit runnable.
      @param aTree - the tree to remove from
      @param aCount the number of repetitions of removing the smallest value
   */
   public RemoveFromTree(BST<Double> aTree, 
         int aCount)
   {
     tree = aTree;
   
      count = aCount;
      rand = new Random();
   }

   /**
    * Starting point of the thread
    */
   public void run()
   {
      try
      {
         for (int i = 1; i <= count; i++)
         {
           
        	Thread.sleep(3000);
        	Double d = tree.removeSmallest();
        	System.out.println("Removed value of " + d );
          
         }
      }
      catch (InterruptedException exception) {}
   }
}

