package kim.eren.code_practices.tpoint.proxydp.entity;

public class RealImage implements Image {
	private String fileName;
	ProxyResult proxyResult;

	public RealImage(String fileName) {
		this.fileName = fileName;
		showRealImage(fileName);
	}
	

	private ProxyResult showRealImage(String fileName) {
		proxyResult = new ProxyResult();
		proxyResult.setFileName(fileName);
		proxyResult.setResultId("Load");
		proxyResult.setResultText("Real Image loaded from disk.");
		return proxyResult;
	}

	public ProxyResult display() {
		proxyResult = new ProxyResult();
		proxyResult.setFileName(fileName);
		proxyResult.setResultId("Display");
		proxyResult.setResultText("Image display from proxy object");
		return proxyResult;
	}
	
	
}
