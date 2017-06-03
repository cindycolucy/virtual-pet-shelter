import java.util.ArrayList;
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

	public Collection<VirtualPet> pets() {
		return shelterPets.values();
	}

	// Method adding pets to the map
	public void addPet(VirtualPet pet) {
		shelterPets.put(pet.name, pet);
	}

	public Collection getMap() {
		return shelterPets.values();
	}

	// Method to feed all pets
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

	// Method to get a pet
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

}
