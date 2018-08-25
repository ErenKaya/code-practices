package kim.eren.code_practices.tpoint.proxydp;

import kim.eren.code_practices.tpoint.proxydp.entity.Image;
import kim.eren.code_practices.tpoint.proxydp.entity.ProxyResult;
import kim.eren.code_practices.tpoint.proxydp.entity.RealImage;

public class ProxyImage implements Image {

	private RealImage realImage;
	private String fileName;

	public ProxyImage(String fileName) {
		super();
		this.fileName = fileName;
	}

	public ProxyResult display() {
		ProxyResult proxyResult;
		if (realImage == null) {
			realImage = new RealImage(fileName);
			proxyResult = realImage.display();
			proxyResult.setResultId("Load");
		}else {
			proxyResult = realImage.display();
		}
		
		return proxyResult;
	}

}
