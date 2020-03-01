package kim.eren.oca_8_certificate.core.gk;

import kim.eren.oca_8_certificate.core.gk.model.ModelObjectClone;
import kim.eren.oca_8_certificate.core.gk.model.ParentModelObject;
import kim.eren.oca_8_certificate.core.gk.prop.CustomProp;
import kim.eren.oca_8_certificate.core.gk.serializer.Serializer;
import kim.eren.oca_8_certificate.core.gk.serializer.SerializerValueContainer;

public class ModelObject extends ParentModelObject {

	public String variable1 = "Eren";
	public Integer variable2 = 2;
	public static Serializer XML = new Serializer() {
		ModelObject m = new ModelObject();

		@Override
		public void readInstance(SerializerValueContainer s, StringBuilder sb) {
			s.get(m.variable1, String.class);
			s.get(m.variable2, CustomProp.class);

		}
	};

	public String getVariable() {
		return variable1;
	}

	public Integer getVariable1() {
		return variable2;
	}
}
