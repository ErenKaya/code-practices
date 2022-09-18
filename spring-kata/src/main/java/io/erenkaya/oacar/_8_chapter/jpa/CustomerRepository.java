package io.erenkaya.oacar._8_chapter.jpa;

import io.erenkaya.oacar._8_chapter.jpa.entities.Customer;

public interface CustomerRepository {

	public Customer getCustomerByName(String name);

	public void save(Customer customer);

}
