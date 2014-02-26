package aspects;

import backingBeans.Controller;
import anotations.ExceptionHandler;

public aspect ExceptionAspect {

	Object around():execution(@ExceptionHandler * *(..)){
		Object obj = null;
	
		try {
			obj = proceed();
		} catch (Exception e) {
			((Controller) obj).addMessage(e.getMessage());
			e.printStackTrace();
		}
		return obj;

	}
}
