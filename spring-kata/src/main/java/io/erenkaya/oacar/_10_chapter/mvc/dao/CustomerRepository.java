package io.erenkaya.oacar._10_chapter.mvc.dao;

import io.erenkaya.oacar.domain.entities.Customer;

public interface CustomerRepository {

	public Customer getCustomerByName(String name);

	public void save(Customer customer);

}
