package com.lwm.logtest.config.aop.warn;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BindingAdvice {

	public Object bindingPrint() {
		
		return null;
	}
}
