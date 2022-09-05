package io.erenkaya.oacar._5_chapter.jdbctemplate.domain;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

public class JDBCCustomerRepositoryImpl implements CustomerRepository {

	private JdbcTemplate template;

	@Inject
	public JDBCCustomerRepositoryImpl(DataSource dataSource) {
		super();
		this.template = new JdbcTemplate(dataSource);
	}

	@Override
	public Customer getCustomerByName(String name) {
		ResultSetExtractor<Customer> customerExtractor = new CustomerExtractor();
		String sql = "select id,name,firstname,age from customer where name=?";
		return template.query(sql, customerExtractor, name);
	}

	@Override
	public void save(Customer customer) {
		String sql = "insert into customer (name,firstname,age) values(?,?,?)";
		template.update(sql, customer.getName(), customer.getFirstname(), customer.getAge());

	}
}
