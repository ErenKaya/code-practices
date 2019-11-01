package kim.eren.oca_8_certificate.core.absint.inh;

public class AnimalContainer implements IAnimalContainerable {

	private Animal animal = null;

	public AnimalContainer(Animal animal) {
		this.animal = animal;
	}

	@Override
	public void changeSeason() {
		System.out.println("AnimalContainer.changeSeason()");
	} 

}
