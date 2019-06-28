package xyz.xkrivzooh.bytebuddy.samples;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

public class Example1 {

	public static void main(String[] args) throws IllegalAccessException, InstantiationException {
		Class<?> dynamicType = new ByteBuddy()
				.subclass(Object.class)
				.method(ElementMatchers.named("toString"))
				.intercept(FixedValue.value("Hello World!"))
				.make()
				.load(Example1.class.getClassLoader())
				.getLoaded();

		System.out.println(dynamicType.newInstance().toString().equals("Hello World!"));
	}
}
