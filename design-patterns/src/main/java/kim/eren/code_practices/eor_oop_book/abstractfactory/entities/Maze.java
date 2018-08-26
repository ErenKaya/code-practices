package kim.eren.code_practices.eor_oop_book.abstractfactory.entities;

import java.util.ArrayList;
import java.util.List;

public class Maze {

	private List<Room> roomList;

	public Maze() {
		roomList = new ArrayList<Room>();
	}

	public void addRoom(Room room) {
		roomList.add(room);
	}

}
