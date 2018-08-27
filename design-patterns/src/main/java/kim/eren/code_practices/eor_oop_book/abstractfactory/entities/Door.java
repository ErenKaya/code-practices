package kim.eren.code_practices.eor_oop_book.abstractfactory.entities;

import kim.eren.code_practices.eor_oop_book.abstractfactory.abstracts.Side;

public class Door implements Side {
	
	private Room openedRoom;
	private Room closedRoom;
	
	
	/**+
	 * opened room represent for the door opens which room closedRoom object is opposite
	 * @param openedRoom
	 * @param closedRoom
	 */
	public Door(Room openedRoom, Room closedRoom) {
		super();
		this.openedRoom = openedRoom;
		this.closedRoom = closedRoom;
	}



	@Override
	public String getInfo() {
		return "Door";
	}

}
