package io.erenkaya.oacar._8_chapter.anno_transaction.domain;

import io.erenkaya.oacar.domain.entities.Customer;

public interface CustomerRepository {

	public Customer getCustomerByName(String name);

	public void save(Customer customer);

}
