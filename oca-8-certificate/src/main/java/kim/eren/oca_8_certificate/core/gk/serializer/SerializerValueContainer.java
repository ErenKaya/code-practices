package kim.eren.oca_8_certificate.core.gk.serializer;

public class SerializerValueContainer {

	private String value;
	private Class type;

	public String get(Object o, Class type) {
		return o.toString() + type.toString();
	}

}
