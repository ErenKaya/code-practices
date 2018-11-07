package kim.eren.code_practices.eor_oop_book.behavioral.iterator.first_example;

public class CPArrayList<T> extends CPAbstractList<T> {

	private T[] employee;
	private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

	public CPArrayList() {
		super();
		this.employee = (T[]) DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T get(long current) {
		// TODO Auto-generated method stub
		return null;
	}

}
