package kim.eren.code_practices.eor_oop_book.abstractfactory.abstracts;

import kim.eren.code_practices.eor_oop_book.abstractfactory.entities.Door;
import kim.eren.code_practices.eor_oop_book.abstractfactory.entities.Maze;
import kim.eren.code_practices.eor_oop_book.abstractfactory.entities.Room;
import kim.eren.code_practices.eor_oop_book.abstractfactory.entities.Wall;

public abstract class AbsMazeFactory {

	public abstract Maze makeMaze();

	public abstract Wall makeWall();

	public abstract Door makeDoor(Room openedRoom, Room closedRoom) ;

	public abstract Room makeRoom(int roomNumber);

}
