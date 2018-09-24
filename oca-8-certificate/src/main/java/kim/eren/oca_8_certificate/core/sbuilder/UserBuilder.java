package kim.eren.oca_8_certificate.core.sbuilder;

public class UserBuilder {

	private User user;

	public UserBuilder() {
		user = new User();
	}

	public static UserBuilder anUser() {
		return new UserBuilder();
	}

	public UserBuilder name(String name) {
		user.setName(name);
		return this;
	}

	public UserBuilder surname(String surname) {
		user.setSurname(surname);
		return this;
	}

	public UserBuilder age(Integer age) {
		user.setAge(age);
		return this;
	}

	public User build() {
		return user;
	}

}
