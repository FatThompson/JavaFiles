
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class AnimalFilePrinter
{

    public static void main(String[] args)
    {
        // open animal.dat for reading
        ObjectInputStream input = null;
        try
        {
           input = new ObjectInputStream(new FileInputStream("animal.dat"));
        } catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        // now read from the file- get an animal and print it
        try
        {
            while (true)
            {
                Animal a = (Animal)input.readObject();
                System.out.println(a);
            }
        } catch (EOFException e)
        {
            // file ended done reading - do nothing
            
        } catch (IOException e)
        {
           System.out.println("Problem reading from file");
            e.printStackTrace();
        } catch (ClassNotFoundException e)
        {
            System.out.println("Corrupted file - regenerate");
            e.printStackTrace();
        }

    }

}
