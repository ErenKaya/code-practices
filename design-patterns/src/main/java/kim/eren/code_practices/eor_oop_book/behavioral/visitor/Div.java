package kim.eren.code_practices.eor_oop_book.behavioral.visitor;

public class Div extends HtmlElement {

	public Div(String name) {
		super(name);
	}

	@Override
	void accept(Visitor visitor) {
		visitor.visit(this);

	}

}
