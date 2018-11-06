package kim.eren.code_practices.eor_oop_book.behavioral.iterator;

public interface Iterator<T> {
	T next();
	T first();
	boolean isDone();
	T currenItem();
}
