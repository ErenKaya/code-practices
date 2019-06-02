package kim.eren.code_practices.tpoint.nulldp;

public class CustomerRepo {

	private String[] customerArray;

	public CustomerRepo(String[] customerArray) {
		this.customerArray = customerArray;

	}

	public AbstractCustomer getCustomer(String name) {
		for (String customer : customerArray) {
			if (name.equalsIgnoreCase(customer)) {
				return new RealCustomer(name);
			}
		}
		return new NullCustomer();
	}
}
