package io.erenkaya.oacar.domain;

import java.util.Date;

public interface BusService {

	public Rental rentABus(Customer customer, Bus car, Date rentDateBegin, Date rentDateEnd);
}
