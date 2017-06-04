import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VirtualPetShelterApp {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		VirtualPetShelter shelter = new VirtualPetShelter();

		writeLine("Welcome to the Virtual Pet Shelter");

		VirtualPet bob = new VirtualPet("Bob", "Dalmation", 40, 50, 60, 30);
		VirtualPet jif = new VirtualPet("Jif", "Golden Lab", 60, 50, 50, 30);
		VirtualPet percy = new VirtualPet("Percy", "Tabby", 40, 50, 80, 50);
		VirtualPet momo = new VirtualPet("Momo", "Border Collie", 50, 60, 70, 40);

		shelter.addPet(bob);
		shelter.addPet(jif);
		shelter.addPet(percy);
		shelter.addPet(momo);

		// Initial status update
		writeLine("This is the status of the pets:");

		writeLine("*****************************************");
		writeLine("Name\tHunger\tThirst\tClean\tBoredom");
		writeLine("_________________________________________");

		for (VirtualPet current : shelter.pets()) {
			writeLine(current.name + "\t" + current.hunger + "\t" + current.thirst + "\t" + current.cleanliness + "\t"
					+ current.boredom);
			writeLine("_________________________________________");
		}

		// boolean startGame = false;
		while (!shelter.shelterPets.isEmpty()) {

			writeLine("What do you want to do? Enter a number.");
			writeLine("1. Feed the pets");
			writeLine("2. Water the pets");
			writeLine("3. Clean the pets' cages");
			writeLine("4. Play with a pet");
			writeLine("5. Adopt a pet");
			writeLine("6. Admit a new pet");
			writeLine("7. Quit");

			String activity = input.next();

			switch (activity) {
			case "1":// Feed all pets
				shelter.feedAll();
				writeLine("You fed all the pets.");
				break;

			case "2":// Water all pets
				shelter.waterAll();
				writeLine("You watered all the pets.");
				break;

			case "3":// Clean pet cages all pets
				shelter.cleanAll();
				writeLine("You cleaned all the pets' cages.");
				break;

			case "4":// play with a pet
				writeLine("Which pet do you want to play with? Type a name.");
				for (VirtualPet currentPet : shelter.pets()) {
					writeLine(" [" + currentPet.name + "] " + currentPet.breed);
				}

				String playName = input.next().toLowerCase();

				VirtualPet tempPlay = shelter.getPet(playName);
				shelter.playOne(tempPlay);
				writeLine("You played with " + playName + ". ");
				break;

			case "5":// adopt a pet
				writeLine("Which pet do you want to adopt? Type a name.");
				for (VirtualPet currentPet : shelter.pets()) {
					writeLine(" [" + currentPet.name + "] " + currentPet.breed);
				}

				String adoptName = input.next().toLowerCase();

				shelter.adoptPet(adoptName);
				writeLine("You adopted " + adoptName + ". ");
				break;

			case "6":// admit a pet
				writeLine("You are admitting a pet.");
				writeLine("What is the pet's name?");
				String admitName = input.next().toLowerCase();
				writeLine("What is the pet's breed?");
				String admitBreed = input.next().toLowerCase();
				VirtualPet admitPet = new VirtualPet(admitName, admitBreed);
				shelter.addPet(admitPet);
				break;

			case "7":
				writeLine("You have quit the Virtual Pet Shelter.");
				System.exit(0);
			}

			// Status update
			writeLine("This is the status of the pets:");

			writeLine("*****************************************");
			writeLine("Name\tHunger\tThirst\tClean\tBoredom");
			writeLine("_________________________________________");

			for (VirtualPet current : shelter.pets()) {
				writeLine(current.name + "\t" + current.hunger + "\t" + current.thirst + "\t" + current.cleanliness
						+ "\t" + current.boredom);
				writeLine("_________________________________________");
			}

			shelter.tickAllPets();

			if (shelter.shelterPets.isEmpty()) {
				writeLine("All pets have been adopted, you win!");
				System.exit(0);
			}
		}

	}

	public static void writeLine(String message) {
		System.out.println(message);
	}
}
