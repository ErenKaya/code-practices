package io.erenkaya.oacar._9_chapter.dynamic_class.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import io.erenkaya.oacar.domain.Customer;
import io.erenkaya.oacar.domain.CustomerRepository;

public class CustomerRepositoryImpl implements CustomerRepository {

	private List<Customer> customerList = new ArrayList<Customer>();

	public CustomerRepositoryImpl() {
		this.customerList.add(new Customer("Test", 23, "Eren", 0));
		this.customerList.add(new Customer("Kaya", 23, "Derya", 1));
	}

	@Override
	public Customer getCustomerByName(String name) {
		Optional<Customer> customer = customerList.stream().filter(c -> c.getName().equals(name)).findFirst();
		if (customer.isPresent()) {
			return customer.get();
		} else {
			return null;
		}
	}

	@Override
	public void save(Customer customer) {
		this.customerList.add(customer);
	}

}
