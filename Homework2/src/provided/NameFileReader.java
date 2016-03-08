package provided;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class NameFileReader
{

    public static void main(String[] args)
    {
        // open animal.dat for reading
        DataInputStream input = null;
        try
        {
           input = new DataInputStream(new FileInputStream("names.dat"));
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
                Integer a = (Integer)input.readInt();
                System.out.println(a);
            }
        } catch (EOFException e)
        {
            // file ended done reading - do nothing
            
        } catch (IOException e)
        {
           System.out.println("Problem reading from file");
            e.printStackTrace();
        } 

    }

}
