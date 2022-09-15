package io.erenkaya.oacar._8_chapter.xml_mapping;

import io.erenkaya.oacar._8_chapter.entities.Customer;

public interface CustomerRepository {

	public Customer getCustomerByName(String name);

	public void save(Customer customer);

}
