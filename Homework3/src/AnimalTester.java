import java.util.ArrayList;

public class AnimalTester
{

	/**
	 * runs all commands
	 * @param args
	 */
	public static void main(String[] args)
	{
		AnimalReader ar = new AnimalReader();
		ArrayList<Animal> animalArrayList = ar.addAnimalObjects(ar.readFile("animal.dat"));
		AnimalHashMap ahm = new AnimalHashMap();
		ar.printHashMap(ar.hashMap(animalArrayList));
	}
}
