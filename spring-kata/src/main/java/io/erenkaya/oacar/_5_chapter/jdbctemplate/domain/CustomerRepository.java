package io.erenkaya.oacar._5_chapter.jdbctemplate.domain;

public interface CustomerRepository {

	public Customer getCustomerByName(String name);

	public void save(Customer customer);

}
