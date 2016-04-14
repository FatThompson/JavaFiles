package mapping;
import javafx.scene.paint.Color;

/**
 * This program runs threads that deposit and withdraw money from the same bank
 * account.
 */
public class ThreadRunner
{
    public static void main(String[] args)
    {
        MyHashMap<String, Color> theMap = new MyHashMap<String, Color>();

       
        
            Creator c = new Creator(theMap);
            Accesor a = new Accesor(theMap);  
            // accesor should print map 10 times with a delay of 1 second in between

            Thread dt = new Thread(c);
            Thread wt = new Thread(a);

            dt.start();
            wt.start();
          

        
    }

}
