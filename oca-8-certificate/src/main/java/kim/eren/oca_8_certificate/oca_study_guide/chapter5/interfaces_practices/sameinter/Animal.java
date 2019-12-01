package kim.eren.oca_8_certificate.oca_study_guide.chapter5.interfaces_practices.sameinter;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Animal implements Runnable, Moveable {
	private String a = "20";

	@Override
	public void canRun() {
		System.out.println("Moving around");
	}

	private void localMethodTriggerFromInstance(){
		System.out.println("triggered");
	}

	public static void main(String[] args) {
		Animal a = (Animal)new Animal();
		a.localMethodTriggerFromInstance();
		Moveable m =  a;
		Runnable r = a;

		// if you cast a object to parent interface you still seen object methods in
		// reflection
		// as you can see on the below java interface method default accessor is public
		for (Method method : m.getClass().getMethods()) {
			System.out.print(method.getName() + " ");
			System.out.println(Modifier.toString(method.getModifiers()));
		}

		// as you can see on the below java interface variables are default accessor
		// public static final you can use interfaces as a constants but its not
		// recommended on forum and community
		for (Field field : Moveable.class.getDeclaredFields()) {
			System.out.print(field.getName() + " ");
			System.out.println(Modifier.toString(field.getModifiers()));
		}

		r.canRun();
		m.canRun();
	}

	@Override
	public void selam() {

	}

}
