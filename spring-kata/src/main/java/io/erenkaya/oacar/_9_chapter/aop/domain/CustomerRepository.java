package io.erenkaya.oacar._9_chapter.aop.domain;

import io.erenkaya.oacar._9_chapter.aop.domain.entities.Customer;

public interface CustomerRepository {

	public Customer getCustomerByName(String name);

	public void save(Customer customer);

}
