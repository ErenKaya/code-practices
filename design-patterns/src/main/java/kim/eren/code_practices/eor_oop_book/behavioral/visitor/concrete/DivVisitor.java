package kim.eren.code_practices.eor_oop_book.behavioral.visitor.concrete;

import kim.eren.code_practices.eor_oop_book.behavioral.visitor.HtmlElement;
import kim.eren.code_practices.eor_oop_book.behavioral.visitor.Visitor;

public class DivVisitor implements Visitor {

	@Override
	public void visit(HtmlElement v) {
		System.out.println("div visitor, name was: " + v.getName());
	}

}
