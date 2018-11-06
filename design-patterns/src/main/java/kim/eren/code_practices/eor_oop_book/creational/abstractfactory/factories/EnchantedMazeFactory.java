package kim.eren.code_practices.eor_oop_book.creational.abstractfactory.factories;

import kim.eren.code_practices.eor_oop_book.creational.abstractfactory.abstracts.AbsMazeFactory;
import kim.eren.code_practices.eor_oop_book.creational.abstractfactory.entities.Door;
import kim.eren.code_practices.eor_oop_book.creational.abstractfactory.entities.DoorNeedingSpell;
import kim.eren.code_practices.eor_oop_book.creational.abstractfactory.entities.EnchantedRoom;
import kim.eren.code_practices.eor_oop_book.creational.abstractfactory.entities.Maze;
import kim.eren.code_practices.eor_oop_book.creational.abstractfactory.entities.Room;
import kim.eren.code_practices.eor_oop_book.creational.abstractfactory.entities.Spell;
import kim.eren.code_practices.eor_oop_book.creational.abstractfactory.entities.Wall;

public class EnchantedMazeFactory extends AbsMazeFactory {

	@Override
	public Maze makeMaze() {
		return new Maze();
	}

	@Override
	public Wall makeWall() {
		return new Wall();
	}

	@Override
	public Door makeDoor(Room openedRoom, Room closedRoom) {

		return new DoorNeedingSpell((EnchantedRoom) openedRoom, (EnchantedRoom) closedRoom);
	}

	@Override
	public Room makeRoom(int roomNumber) {
		return new EnchantedRoom(roomNumber, castSpell());
	}

	private Spell castSpell() {
		return new Spell();
	}

}
