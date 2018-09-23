package kim.eren.oca_8_certificate.core.msusur;

public class WallBuilder {
	private static Wall _wall;

	public static String printWall(Wall wall) {
		_wall = wall;
		switch (wall.getSide()) {
		case VERTICAL:
			return printLeftRightWall();
		case HORIZONTAL:
			return printHorizantalWall();
		default:
			return null;
		}
	}

	private static String printHorizantalWall() {
		StringBuilder topWallBuilder = new StringBuilder();
		for (int i = 0; i < _wall.getLength(); i++) {
			topWallBuilder.append("*");
		}
		topWallBuilder.append("\n");
		return topWallBuilder.toString();
	}

	private static String printLeftRightWall() {
		StringBuilder leftWallBuilder = new StringBuilder();
		for (int i = 0; i < _wall.getLength() - 2; i++) {
			leftWallBuilder.append("*");
			for (int j = 0; j < _wall.getLength() - 2; j++) {
				leftWallBuilder.append(" ");
			}
			leftWallBuilder.append("*");
			leftWallBuilder.append("\n");
		}
		return leftWallBuilder.toString();
	}

}
