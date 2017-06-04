import java.util.Map;
import java.util.Random;

public class VirtualPet {

	//Instance variables
	String name;
	String breed;

	int hunger;
	int thirst;
	int boredom;
	int cleanliness;
	
	//Constructor that accepts VirtualPet and establishes default attributes for new pets
	public VirtualPet(String newName, String newBreed) {
		name = newName;
		breed = newBreed;
		hunger = 50;
		thirst = 50;
		boredom = 50;
		cleanliness = 50;

	}
	//Constructor creates an object that allows to add pets and populate values initially in the map
	public VirtualPet(String newName, String newBreed, Integer newHunger, Integer newThirst, Integer newBoredom, Integer newCleanliness) {
		name = newName;
		breed = newBreed;
		hunger = newHunger;
		thirst = newThirst;
		boredom = newBoredom;
		cleanliness = newCleanliness;
	}

	// Tick method
	Random r = new Random();

	void tick() {
		hunger = hunger + r.nextInt(20);
		thirst = thirst + r.nextInt(20);
		boredom = boredom + r.nextInt(20);
	}

	// Hunger method
	void feedPet() {
		hunger = hunger - 25;
	}

	// Thirst method
	void waterPet() {
		thirst = thirst - 20;
		hunger = hunger + 10;
	}
	
	// Cleanliness method
		void cleanPet() {
			cleanliness = cleanliness + 20;
		}

	// Boredom method
	void playPet() {
		boredom = boredom - 20;
		thirst = thirst + 10;
		hunger = hunger + 10;
	}
	
	
}
