package kim.eren.code_practices.eor_oop_book.creational.abstractfactory.abstracts;

import kim.eren.code_practices.eor_oop_book.creational.abstractfactory.entities.Door;
import kim.eren.code_practices.eor_oop_book.creational.abstractfactory.entities.Maze;
import kim.eren.code_practices.eor_oop_book.creational.abstractfactory.entities.Room;
import kim.eren.code_practices.eor_oop_book.creational.abstractfactory.entities.Wall;

public abstract class AbsMazeFactory {

	public abstract Maze makeMaze();

	public abstract Wall makeWall();

	public abstract Door makeDoor(Room openedRoom, Room closedRoom) ;

	public abstract Room makeRoom(int roomNumber);

}
