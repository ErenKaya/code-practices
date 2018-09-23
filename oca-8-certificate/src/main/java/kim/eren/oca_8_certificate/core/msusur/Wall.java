package kim.eren.oca_8_certificate.core.msusur;

public class Wall {
	private int length;
	private Side side;

	public Wall(int length, Side side) {
		this.side = side;
		this.length = length;
	}

	public int getLength() {
		return length;
	}

	public Side getSide() {
		return side;
	}

}
