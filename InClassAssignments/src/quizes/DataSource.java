package quizes;
import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 */

/**
 * @author cjohns25
 *
 */
public class DataSource
{

	private ArrayList<Integer> theData;
	private int amountOfData;

	public  Lock lock;
	public Condition condition;

	public DataSource()
	{
		theData = new ArrayList<Integer>();
		amountOfData = 0;
		lock = new ReentrantLock();
		condition = lock.newCondition(); 
	}


	public void write(int i)
	{
		lock.lock();
		try{

			theData.add(i);
			amountOfData++;
		}
		finally
		{
			lock.unlock();
		}
	}


	public int read() throws InterruptedException
	{
		lock.lock();
		try
		{

			if (amountOfData > 0)
			{
				int returnValue = theData.get(0);
				theData.remove(0);
				amountOfData --;
				return returnValue;
			}
			else
			{
				//lock.wait();
				return 0;
			}
		} finally
		{
			lock.unlock();
		}
	}
    

}
