import java.io.DataOutputStream;
import java.io.FileOutputStream;
/**
 * For midterm
 * @author Matthew Thompson
 *
 */


public class BinaryFileIO
{
   

    public static void main(String[] args)
    {
       // create instance
        Pet[] pets = new Pet[3];
        pets[0] = new Pet("Mr. Jones", "A001", "Fluffy", 6);
        pets[1] = new Pet("Ms. Smith", "B001", "Spot", 1);
        pets[2] = new Pet("Mr. Simpson", "A002", "Peanut", 3);
        
        
        // YOUR CODE GOES HERE
        // Write code to create a binary file in the default directory 
        // named "Petss.dat" using ObjectOutputStream
        try
		{ 
				DataOutputStream output = new DataOutputStream(new FileOutputStream("Petss.dat"));
				for (Pet pet : pets)
				{
					output.writeUTF(pet.getOwnerName());
				}
				output.close();
		}		
		catch(Exception e)
		{ 
			e.printStackTrace();
			System.out.println("and Error has occured");
		}
        //   write the contents of the string array named petst to the file you just opened
        
        
        // close the file
             
        
    }

}
