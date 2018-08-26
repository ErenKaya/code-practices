package kim.eren.code_practices.eor_oop_book.abstractfactory.factories;

import kim.eren.code_practices.eor_oop_book.abstractfactory.abstracts.AbsMazeFactory;
import kim.eren.code_practices.eor_oop_book.abstractfactory.entities.Door;
import kim.eren.code_practices.eor_oop_book.abstractfactory.entities.Maze;
import kim.eren.code_practices.eor_oop_book.abstractfactory.entities.Room;
import kim.eren.code_practices.eor_oop_book.abstractfactory.entities.Wall;

public class MazeFactory extends AbsMazeFactory{

	public Maze makeMaze() {
		return new Maze();
	}

	public Wall makeWall() {
		return new Wall();
	}

	public Door makeDoor(Room openedRoom, Room closedRoom) {
		return new Door(openedRoom, closedRoom);
	}

	public Room makeRoom(int roomNumber) {
		return new Room(roomNumber);
	}
	
}
