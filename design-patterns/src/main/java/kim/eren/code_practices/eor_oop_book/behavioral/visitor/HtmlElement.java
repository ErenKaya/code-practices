package kim.eren.code_practices.eor_oop_book.behavioral.visitor;

public abstract class HtmlElement {

	private String name;

	public HtmlElement(String name) {
		super();
		this.name = name;
	}

	abstract void accept(Visitor visitor);

	public String getName() {
		return name;
	}

}
