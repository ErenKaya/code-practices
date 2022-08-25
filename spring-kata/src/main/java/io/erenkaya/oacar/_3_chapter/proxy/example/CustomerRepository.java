package io.erenkaya.oacar._3_chapter.proxy.example;

public interface CustomerRepository {

	public Customer getCustomerByName(String name);

	public void save(Customer customer);

}
