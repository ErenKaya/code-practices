package kim.eren.code_practices.tpoint.nulldp;

public class RealCustomer extends AbstractCustomer {

	public RealCustomer(String name) {
		super();
		super.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean isNill() {
		return false;
	}

}
