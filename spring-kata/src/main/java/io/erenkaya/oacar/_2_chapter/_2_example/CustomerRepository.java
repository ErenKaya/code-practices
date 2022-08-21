package io.erenkaya.oacar._2_chapter._2_example;

public interface CustomerRepository {

	public Customer getCustomerByName(String name);

	public void save(Customer customer);

}
