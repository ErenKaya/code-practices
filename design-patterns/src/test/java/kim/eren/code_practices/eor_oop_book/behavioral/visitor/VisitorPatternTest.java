package kim.eren.code_practices.eor_oop_book.behavioral.visitor;

import org.junit.Before;
import org.junit.Test;

import kim.eren.code_practices.eor_oop_book.behavioral.visitor.concrete.DefaultVisitor;
import kim.eren.code_practices.eor_oop_book.behavioral.visitor.concrete.DivVisitor;
import kim.eren.code_practices.eor_oop_book.behavioral.visitor.concrete.SpanVisitor;

public class VisitorPatternTest {

	private Body b;
	private Visitor v;

	@Before
	public void init() {
		b = new Body("html element body");
		v = new DefaultVisitor();
	}

	@Test
	public void test_body_elements_from_one_visitor() {
		b.addBodyParts(new Div("div1"));
		b.addBodyParts(new Span("span1"));
		b.addBodyParts(new Span("span2"));
		b.addBodyParts(new Div("div2"));
		b.accept(v);
	}

	@Test
	public void test_div_visiting() {
		Div d = new Div("test_div_visiting");
		Visitor divVisitor = new DivVisitor();
		d.accept(divVisitor);
	}

	@Test
	public void test_span_visiting() {
		Span s = new Span("test_span_visiting");
		Visitor spanVisitor = new SpanVisitor();
		s.accept(spanVisitor);
	}

}
