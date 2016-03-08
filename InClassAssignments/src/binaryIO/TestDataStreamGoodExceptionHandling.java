package binaryIO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestDataStreamGoodExceptionHandling {
  public static void main(String[] args) throws IOException {
    try  
    {
        // Create an output stream for file temp.dat
      DataOutputStream output =
        new DataOutputStream(new FileOutputStream("c:\temp.dat"));
     
      // Write student test scores to the file
      output.writeUTF("John");
      output.writeDouble(85.5);
      output.writeUTF("Jim");
      output.writeDouble(185.5);
      output.writeUTF("George");
      output.writeDouble(105.25);
      output.close();
    }
    catch (Exception ex)
    {
        ex.printStackTrace();
        System.out.println("unable to write to file");
    }
    

    
    try 
    {
        // Create an input stream for file temp.dat
   
      DataInputStream input =
        new DataInputStream(new FileInputStream("temp.dat"));
    
      // Read student test scores from the file
      System.out.println(/*input.readUTF() +*/ " " + input.readDouble());
      System.out.println(input.readUTF() + " " + input.readDouble());
      System.out.println(input.readUTF() + " " + input.readDouble());
      //input.close();
    }
    catch (Exception ex)
    {
        ex.printStackTrace();
        System.out.println("unable to read from file");
    }
    
  }
}

