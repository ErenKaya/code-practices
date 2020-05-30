package kim.eren.code_practices.eor_oop_book.behavioral.visitor.concrete;

import kim.eren.code_practices.eor_oop_book.behavioral.visitor.HtmlElement;
import kim.eren.code_practices.eor_oop_book.behavioral.visitor.Visitor;

public class SpanVisitor implements Visitor {

	@Override
	public void visit(HtmlElement a) {
		System.out.println("span visitor, name was: " + a.getName());
	}

}
