package kim.eren.code_practices.eor_oop_book.abstractfactory.entities;

import kim.eren.code_practices.eor_oop_book.abstractfactory.abstracts.Side;

public class Room {
	private Side north;
	private Side east;
	private Side west;
	private Side south;

	private int roomNumber;

	public Room() {
		super();
	}

	public Room(int roomNumber) {

	}

	public Room(Side north, Side east, Side west, Side south) {
		super();
		this.north = north;
		this.east = east;
		this.west = west;
		this.south = south;
	}

	public Side getNorth() {
		return north;
	}

	public void setNorth(Side north) {
		this.north = north;
	}

	public Side getEast() {
		return east;
	}

	public void setEast(Side east) {
		this.east = east;
	}

	public Side getSouth() {
		return south;
	}

	public void setSouth(Side south) {
		this.south = south;
	}

	public Side getWest() {
		return west;
	}

	public void setWest(Side west) {
		this.west = west;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

}
