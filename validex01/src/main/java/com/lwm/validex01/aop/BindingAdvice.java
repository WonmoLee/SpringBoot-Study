package com.lwm.validex01.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//공통관심사 : advice
@Component
@Aspect //AOP 등록완료
public class BindingAdvice {
	
	//@Before, @After, @Around
	@Before("excution(* com.cos.validex01..*Controller.*(..)")
	public Object validationHandler(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		String type = proceedingJoinPoint.getSignature().getDeclaringTypeName();
		String method = proceedingJoinPoint.getSignature().getName();
		
		System.out.println("type : " + type);
		System.out.println("method : " + method);
		
		return proceedingJoinPoint.proceed();
	}
	
}
