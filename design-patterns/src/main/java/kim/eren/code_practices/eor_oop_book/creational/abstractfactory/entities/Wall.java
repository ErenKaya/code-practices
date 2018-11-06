package kim.eren.code_practices.eor_oop_book.creational.abstractfactory.entities;

import kim.eren.code_practices.eor_oop_book.creational.abstractfactory.abstracts.Side;

public class Wall implements Side
{

	@Override
	public String getInfo() {
		return "Wall";
	}
	
}
