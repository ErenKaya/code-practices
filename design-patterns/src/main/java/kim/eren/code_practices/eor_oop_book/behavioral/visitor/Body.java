package kim.eren.code_practices.eor_oop_book.behavioral.visitor;

import java.util.ArrayList;
import java.util.List;

public class Body extends HtmlElement {

	private List<HtmlElement> bodyParts = new ArrayList<>();

	public Body(String name) {
		super(name);
	}

	@Override
	public void accept(Visitor visitor) {
		for (HtmlElement v : bodyParts) {
			v.accept(visitor);
		}
	}

	public void addBodyParts(HtmlElement v) {
		bodyParts.add(v);
	}

}
