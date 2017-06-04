import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//Map of pets and attributes
public class VirtualPetShelter {
	Map<String, VirtualPet> shelterPets = new HashMap<String, VirtualPet>();

	// Tick method
	void tickAllPets() {
		for (VirtualPet p : shelterPets.values()) {
			p.tick();
		}
	}

	// Method returning collection of all pets in the shelter
	public Collection<VirtualPet> pets() {
		return shelterPets.values();
	}

	// Method adding pets to the map
	public void addPet(VirtualPet pet) {
		shelterPets.put(pet.name, pet);
	}

	// Method to feed all pets. For each VirtualPet in the map, run the feedPet
	// method.
	public void feedAll() {
		for (VirtualPet p : shelterPets.values()) {
			p.feedPet();
		}
	}

	// Method to water all pets
	public void waterAll() {
		for (VirtualPet p : shelterPets.values()) {
			p.waterPet();
		}
	}

	// Method to clean all pets
	public void cleanAll() {
		for (VirtualPet p : shelterPets.values()) {
			p.cleanPet();
		}
	}

	// Method to return a pet from the map by name
	public VirtualPet getPet(String name) {
		return shelterPets.get(name);

	}

	// Method to play with one pet
	public void playOne(VirtualPet player) {
		player.playPet();
	}

	// Method to adopt a pet
	public void adoptPet(String removedPet) {
		shelterPets.remove(removedPet);
	}

	// Method identifying dead
	// boolean dead() {
	// for (VirtualPet v : shelterPets.values()) {
	// if ((v.hunger > 100) || (v.thirst > 100) || (v.cleanliness < 50) ||
	// (v.boredom > 100)) {
	// return true;
	// }
	// }
}
