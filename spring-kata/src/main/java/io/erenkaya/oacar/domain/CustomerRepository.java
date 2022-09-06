package io.erenkaya.oacar.domain;

public interface CustomerRepository {

	public Customer getCustomerByName(String name);

	public void save(Customer customer);

}
