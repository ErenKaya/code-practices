package kim.eren.code_practices.tpoint.nulldp;

public class NullCustomer extends AbstractCustomer {

	@Override
	public String getName() {
		return "Not available in customer db";
	}

	@Override
	public boolean isNill() {
		return true;
	}

}
