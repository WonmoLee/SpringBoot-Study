package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

//스프링 로딩될 때
public class IoCContainer {
	
	public <T> T invokeAnnotation(T instance) {
		
		//어노테이션 스캔
		Method[] methods = instance.getClass().getDeclaredMethods();

		for (Method m : methods) {
			if (m.isAnnotationPresent(NumCheck.class)) {
				Field f[] = instance.getClass().getFields();
				
				try {
					int num1 = f[0].getInt(instance);
					int num2 = f[1].getInt(instance);
					
					System.out.println(num1);
					System.out.println(num2);
					
					if (num1 - num2 < 0) {
						System.out.println("금액이 부족합니다");
						return null;
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return instance;
	}
}
