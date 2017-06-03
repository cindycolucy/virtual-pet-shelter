import java.util.Map;
import java.util.Random;

public class VirtualPet {

	String name;
	String breed;

	int hunger;
	int thirst;
	int boredom;
	
	

	public VirtualPet(String newName, String newBreed) {
		name = newName;
		breed = newBreed;
		hunger = 50;
		thirst = 50;
		boredom = 50;

	}

	public VirtualPet(String newName, String newBreed, Integer newHunger, Integer newThirst, Integer newBoredom) {
		name = newName;
		breed = newBreed;
		hunger = newHunger;
		thirst = newThirst;
		boredom = newBoredom;
	}
	// public String toString(){
	// return name + " " + breed + " " + hunger + " " + thirst + " " + boredom;
	// }
	
	

	Random r = new Random();

	//Tick method
	void tick() {
	hunger = hunger + r.nextInt(40);
	thirst = thirst + r.nextInt(40);
	boredom = boredom + r.nextInt(40);
	}
	public String toString() {
		return name + " " + breed + " " + hunger + " " + thirst + " " + boredom;
	}

	// Hunger method
	void feedPet() {
		hunger = hunger - 25;
	}

	boolean isHungry() {
		return hunger >= 20;
	}

	int getHunger() {
		return hunger;
	}

	// Thirst methods
	void waterPet() {
		thirst = thirst - 5;
		hunger = hunger + 5;
	}

	boolean isThirsty() {
		return thirst >= 20;
	}

	int getThirst() {
		return thirst;
	}

	// Boredom methods
	void playPet() {
		boredom = boredom - 5;
		thirst = thirst + 5;
		hunger = hunger + 5;
	}

	boolean isBored() {
		return boredom >= 20;
	}

	int getBoredom() {
		return boredom;
	}

}
