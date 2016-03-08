
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.HashMap;

/**
 * For midterm
 * @author Matthew Thompson
 *
 */
public class HashMapUser
{
    
    public static void main(String[] args)
    {
       // create instance
        String initialSet[] = {"Romeo", "Juliet", "Adam", "Eve", "Homer", "Marge", "Bart", "Eve"};
       
        Random randomGenerator = new Random();
        
        

        //create the hashmap
        HashMap<String, Double> stringInt = new HashMap<String, Double>();
        //add the names in
        for (String name : initialSet)
		{
        	// create a random double number between 0 and 60
        	stringInt.put(name, (randomGenerator.nextDouble() * 60));
		}
        
        //create iterator
        ////create the set for the iterator
        Set<Entry<String, Double>> set = stringInt.entrySet();
        ////create iterator from set
        Iterator<Entry<String, Double>> iterator = set.iterator();
        
        //print everything
        while(iterator.hasNext())
        {
        	System.out.println(iterator.next());
        }
    }

}
