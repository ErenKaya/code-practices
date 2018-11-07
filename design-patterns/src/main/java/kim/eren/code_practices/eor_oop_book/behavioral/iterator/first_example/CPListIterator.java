package kim.eren.code_practices.eor_oop_book.behavioral.iterator.first_example;

public class CPListIterator<T> implements CPIterator<T> {

	private final CPList<T> aList;
	public long current;

	public CPListIterator(CPList<T> aList) {
		super();
		this.aList = aList;
		current = 0;
	}

	@Override
	public void first() {
		current = 0;

	}

	@Override
	public void next() {
		current++;

	}

	@Override
	public boolean isDone() {
		return current >= this.aList.count();
	}

	@Override
	public T currentItem() {
		if (isDone()) {
			throw new ArrayIndexOutOfBoundsException();
		} else {
			return this.aList.get(this.current);
		}
	}

}
