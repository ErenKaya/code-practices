package io.erenkaya.oacar._5_chapter.jdbctemplate.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class CustomerExtractor implements ResultSetExtractor<Customer> {

	@Override
	public Customer extractData(ResultSet rs) throws SQLException, DataAccessException {
		Customer customer = null;
		if (rs.next()) {
			String name = rs.getString("name"), firstname = rs.getString("firstname");
			int age = rs.getInt("age");
			long id = rs.getLong("id");
			customer = new Customer(name, age, firstname, id);

		}
		if (customer == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return customer;
	}

}
