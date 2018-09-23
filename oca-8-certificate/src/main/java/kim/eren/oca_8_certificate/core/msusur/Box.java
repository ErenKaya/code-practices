package kim.eren.oca_8_certificate.core.msusur;

import java.util.Map;

public class Box {
	private Wall topWall;
	private Wall bottomWall;
	private Wall rightLeftWall;

	public Box(Wall topWall, Wall rightLeftWall, Wall bottomWall) {
		this.topWall = topWall;
		this.bottomWall = bottomWall;
		this.rightLeftWall = rightLeftWall;
	}

	public String printBox() {
		return WallBuilder.printWall(topWall) + WallBuilder.printWall(rightLeftWall)
				+ WallBuilder.printWall(bottomWall);
	}

}
