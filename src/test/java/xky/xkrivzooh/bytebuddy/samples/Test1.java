package xky.xkrivzooh.bytebuddy.samples;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;
import org.junit.Assert;
import org.junit.Test;

public class Test1 {

	@Test
	public void test() {
		try {
			Class<?> dynamicType = new ByteBuddy()
					.subclass(Object.class)
					.method(ElementMatchers.named("toString"))
					.intercept(FixedValue.value("Hello World!"))
					.make()
					.load(Test1.class.getClassLoader())
					.getLoaded();

			assertThat(dynamicType.newInstance().toString(), is("Hello World!"));
		}
		catch (Exception e) {
			Assert.fail();
		}
	}
}
