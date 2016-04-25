package homework.homework5;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class GenerateAnimalBinaryFile
{

    public static void main(String[] args)
    {
        // create 6 instances of animals and write using ObjectOutputStream to animal.dat
        
        ArrayList<Animal> animalList = new ArrayList<Animal>();
        
        // create 6 aniamals and add  to animalList
        Animal a = new Animal("Cheetah", "Chimpanzee", 10.2, 1);
        animalList.add(a);
        a = new Animal("Fluffy", "Lion", 5.6, 2);
        animalList.add(a);
        a = new Animal("Fred", "elephant", 55.2, 3);
        animalList.add(a);
        a = new Animal("Slimy", "tree frog", 0.33, 12);
        animalList.add(a);
        a = new Animal("Mai-Mai", "Panda", 12.2, 2);
        animalList.add(a);
        a = new Animal("Cheetah", "Chimpanzee", 14, 2);
        animalList.add(a);
        
        // open file for writing
        try
        {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src/homework/homework5/animal.dat"));
            
            // write each Animal in turn
            for (int i =0; i< animalList.size(); i++)
            {
                Animal myAnimal = animalList.get(i);
                output.writeObject(myAnimal);
            }
            // done writing close file
            output.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Problem writing to file");
        }
        
    }

}
