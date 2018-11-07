package kim.eren.code_practices.eor_oop_book.behavioral.iterator.first_example;

public abstract class CPAbstractList<T> implements CPList<T>{

	public  CPIterator<T> createIterator(){
		return new CPListIterator<T>(this);
	}
}
