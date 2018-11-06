package kim.eren.code_practices.eor_oop_book.creational.abstractfactory.entities;

public class EnchantedRoom extends Room {

	public Spell spell;

	public EnchantedRoom(int roomNumber, Spell spell) {
		super(roomNumber);
		this.spell = spell;
	}
}
