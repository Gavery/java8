package annotation;

import java.lang.reflect.Method;

import org.junit.Test;

/*
 * 重复注解与类型注解
 */
public class annotation {
	@Test
	public void test1() throws NoSuchMethodException, SecurityException {
		Class<annotation> clazz=annotation.class;
		Method m1=clazz.getMethod("show");
		MyAnnotation[] mas=m1.getAnnotationsByType(MyAnnotation.class);
		for(MyAnnotation myAnnotation:mas) {
			System.out.println(myAnnotation.value());
		}
	}
@MyAnnotation("hello")
@MyAnnotation("world")
public void show(@MyAnnotation("abc") String str) {}
}
