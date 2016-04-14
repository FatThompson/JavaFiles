package MultiThreading;
import java.util.Random;


/**
  This class adds random Double values to a binary search tree one every second
 */
public class AddToTreeRunnable implements Runnable
{
	private static final int DELAY = 1000; 
	private BST<Double> tree;
	private double newValue;
	private int count;
	Random rand ;

	/**
      Constructs a add runnable
      @param aTree- the tree to add to
      @param aCount the number of repetitions to add
	 */
	public AddToTreeRunnable(BST<Double> aTree, int aCount)
	{
		tree = aTree;
		count = aCount;
		rand = new Random();
	}

	/* starting point for the thread */
	public void run()
	{
		try
		{
			for (int i = 1; i <= count; i++)
			{
				// generate a random Double
				newValue = rand.nextDouble() * 1000;
				tree.insert(new Double(newValue));
				System.out.println("Adding a value of " + newValue);
				Thread.sleep(DELAY);
			}
		}
		catch (InterruptedException exception) {}
	}
}

