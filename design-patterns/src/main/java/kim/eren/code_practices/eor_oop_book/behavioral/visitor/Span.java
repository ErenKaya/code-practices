package kim.eren.code_practices.eor_oop_book.behavioral.visitor;

public class Span extends HtmlElement {

	public Span(String name) {
		super(name);
	}

	@Override
	 void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
