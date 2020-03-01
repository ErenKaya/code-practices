package kim.eren.oca_8_certificate.core.batik;

import java.awt.geom.GeneralPath;
import java.awt.geom.RoundRectangle2D;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.batik.svggen.SVGGeneratorContext;
import org.apache.batik.svggen.SVGPath;
import org.jfree.graphics2d.svg.SVGGraphics2D;
import org.w3c.dom.Document;

public class BatikTest {

	public static void main(String[] args) throws ParserConfigurationException {
		SVGGraphics2D g2 = new SVGGraphics2D(300, 400);
		GeneralPath path = new GeneralPath();
		DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = documentFactory.newDocumentBuilder();
		Document d = dBuilder.newDocument();
		float margin = 3;
		float x1 = margin, y1 = margin;
		float W = (float) 200;
		float H = (float) 100;
		float PX = W / 5;
		float PY = W / 5;
		path.append(new RoundRectangle2D.Float(x1, y1, W, H, PX, PY), false);
		g2.draw(path);
		String s = g2.getSVGElement();
		SVGGeneratorContext svgContext = SVGGeneratorContext.createDefault(d);
		String data = SVGPath.toSVGPathData(path, svgContext);
		System.out.println("BatikTest.main()" + data);
	}

}
