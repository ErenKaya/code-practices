package kim.eren.code_practices.eor_oop_book.creational.abstractfactory.entities;

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

	@Override
	public String toString() {
		StringBuilder sBuilder = new StringBuilder();
		if (!roomList.isEmpty()) {

			for (Room room : roomList) {
				sBuilder.append(room.toString()).append("\r");
			}
			return sBuilder.toString().substring(0, sBuilder.toString().length() - 2);
		}
		return null;
	}

}
