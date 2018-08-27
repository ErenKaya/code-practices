package kim.eren.code_practices.tpoint.facedepattern;

public class FacedeFactory {

	private final static FacedeFactory facedeFactory = new FacedeFactory();

	public static FacedeFactory getInstance() {
		return facedeFactory;
	}

	public ComponentFacede getFacede() {
		return new FacedeImpl();
	}
}
