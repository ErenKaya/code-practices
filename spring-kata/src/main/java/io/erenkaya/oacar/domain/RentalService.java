package io.erenkaya.oacar.domain;

import java.util.Date;

public interface RentalService {

	public Rental rentACar(Customer customer, Car car, Date rentDateBegin, Date rentDateEnd);

}
