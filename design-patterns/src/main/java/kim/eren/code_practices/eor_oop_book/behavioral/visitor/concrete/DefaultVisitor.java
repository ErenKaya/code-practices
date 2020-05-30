package kim.eren.code_practices.eor_oop_book.behavioral.visitor.concrete;

import kim.eren.code_practices.eor_oop_book.behavioral.visitor.HtmlElement;
import kim.eren.code_practices.eor_oop_book.behavioral.visitor.Visitor;

public class DefaultVisitor implements Visitor{

	@Override
	public void visit(HtmlElement a) {
		System.out.println("body visitor, name was: " + a.getName());

	}

}
