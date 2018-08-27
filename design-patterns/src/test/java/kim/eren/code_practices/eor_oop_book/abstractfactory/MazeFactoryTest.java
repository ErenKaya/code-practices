package kim.eren.code_practices.eor_oop_book.abstractfactory;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import kim.eren.code_practices.eor_oop_book.abstractfactory.abstracts.AbsMazeFactory;
import kim.eren.code_practices.eor_oop_book.abstractfactory.entities.Door;
import kim.eren.code_practices.eor_oop_book.abstractfactory.entities.Maze;
import kim.eren.code_practices.eor_oop_book.abstractfactory.entities.Room;
import kim.eren.code_practices.eor_oop_book.abstractfactory.entities.Wall;
import kim.eren.code_practices.eor_oop_book.abstractfactory.enums.FactoryType;
import kim.eren.code_practices.eor_oop_book.abstractfactory.factories.EnchantedMazeFactory;
import kim.eren.code_practices.eor_oop_book.abstractfactory.factories.MazeFactory;
import kim.eren.code_practices.eor_oop_book.abstractfactory.factories.MazeFactoryProducer;

public class MazeFactoryTest {

	AbsMazeFactory factory;
	MazeFactoryProducer factoryProducer;

	@Before
	public void init() {
		factoryProducer = new MazeFactoryProducer();
	}

	@Test
	public void abstract_factory_pattern_enchanted_factory_test() {
		factory = factoryProducer.getFactory(FactoryType.ENCHANTED.toString());
		assertEquals(FactoryType.ENCHANTED.toString(), getFactoryResult(factory));
	}

	@Test
	public void abstract_factory_pattern_normal_factory_test() {
		factory = factoryProducer.getFactory(FactoryType.NORMAL.toString());
		assertEquals(FactoryType.NORMAL.toString(), getFactoryResult(factory));
	}

	@Test
	public void normal_factory_item_test() {
		factory = factoryProducer.getFactory(FactoryType.NORMAL.toString());
		Maze maze = createNormalMaze();
		System.out.println(maze.toString());

	}

	private Maze createNormalMaze() {
		Maze maze = factory.makeMaze();
		Room room1 = factory.makeRoom(1);
		Room room2 = factory.makeRoom(2);
		Door door = factory.makeDoor(room1, room2);

		room1.setEast(new Wall());
		room1.setNorth(new Wall());
		room1.setSouth(new Wall());
		room1.setWest(door);

		room2.setEast(door);
		room2.setNorth(new Wall());
		room2.setWest(new Wall());
		room2.setSouth(new Wall());

		maze.addRoom(room1);
		maze.addRoom(room2);

		return maze;
	}

	private String getFactoryResult(AbsMazeFactory resultFromFactory) {
		if (resultFromFactory instanceof EnchantedMazeFactory) {
			return FactoryType.ENCHANTED.toString();
		} else if (resultFromFactory instanceof MazeFactory) {
			return FactoryType.NORMAL.toString();
		} else {
			return null;
		}
	}

}
