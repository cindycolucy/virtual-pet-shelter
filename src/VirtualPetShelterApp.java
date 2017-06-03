import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VirtualPetShelterApp {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		VirtualPetShelter shelter = new VirtualPetShelter();

		writeLine("Welcome to the Virtual Pet Shelter");

		VirtualPet bob = new VirtualPet("Bob", "Dalmation", 40, 50, 60);
		VirtualPet jif = new VirtualPet("Jif", "Lab", 60, 50, 50);
		VirtualPet percy = new VirtualPet("Percy", "Tabby", 40, 50, 80);
		VirtualPet momo = new VirtualPet("Momo", "Border Collie", 50, 60, 70);

		shelter.addPet(bob);
		shelter.addPet(jif);
		shelter.addPet(percy);
		shelter.addPet(momo);

		writeLine("This is the status of the pets:");

		writeLine("***************************************************************");
		writeLine("|Name\t\t|Hunger\t\t|Thirst\t\t|Boredom\t|");
		writeLine("|_____________________________________________________________");

		for (VirtualPet current : shelter.pets()) {
			writeLine("|" + current.name + "\t\t" + current.hunger + "\t\t" + current.thirst + "\t\t" + current.boredom
					+ "\t\t|");
			writeLine("_____________________________________________________________");
		}
		
		boolean startGame = false;
		while (!startGame) {

			writeLine("What do you want to do? Enter a number.");
			writeLine("1. Feed the pets");
			writeLine("2. Water the pets");
			writeLine("3. Play with a pet");
			writeLine("4. Adopt a pet");
			writeLine("5. Admit a new pet");
			writeLine("6. Quit");

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

			case "3":// play with a pet
				writeLine("Which pet do you want to play with? Type a name.");
				for (VirtualPet currentPet : shelter.pets()) {
					writeLine(" [" + currentPet.name + "] " + currentPet.breed);
				}

				String playName = input.next();

				VirtualPet tempPlay = shelter.getPet(playName);
				shelter.playOne(tempPlay);
				writeLine("You played with " + playName + ". ");
				break;

			case "4":// adopt a pet
				writeLine("Which pet do you want to adopt? Type a name.");
				for (VirtualPet currentPet : shelter.pets()) {
					writeLine(" [" + currentPet.name + "] " + currentPet.breed);
				}

				String adoptName = input.next();

				shelter.adoptPet(adoptName);
				writeLine("You adopted " + adoptName + ". ");
				break;

			case "5":// admit a pet
				writeLine("You are admitting a pet.");
				writeLine("What is the pet's name?");
				String admitName = input.next();
				writeLine("What is the pet's breed?");
				String admitBreed = input.next();
				VirtualPet admitPet = new VirtualPet(admitName, admitBreed);
				shelter.addPet(admitPet);
				break;

			case "6":
				writeLine("You have quit the Virtual Pet Shelter.");
				System.exit(0);
			}

			writeLine("This is the status of the pets:");

			writeLine("***************************************************************");
			writeLine("|Name\t\t|Hunger\t\t|Thirst\t\t|Boredom\t|");
			writeLine("|_____________________________________________________________");

			for (VirtualPet current : shelter.pets()) {
				writeLine("|" + current.name + "\t\t" + current.hunger + "\t\t" + current.thirst + "\t\t"
						+ current.boredom + "\t\t|");
				writeLine("_____________________________________________________________");

			}

			shelter.tickAllPets();
		}
	}

	public static void writeLine(String message) {
		System.out.println(message);
	}
}
