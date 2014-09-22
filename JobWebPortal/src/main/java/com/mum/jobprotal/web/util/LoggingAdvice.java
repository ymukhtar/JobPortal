package com.mum.jobprotal.web.util;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAdvice {
	private static Logger logger=Logger.getLogger(LoggingAdvice.class);
	@Before("execution(* com.mum.jobportal.service.JobPortalService.*(..))")
	public void loggingMethod(JoinPoint joinPoint){
		logger.info(joinPoint.getSignature().getName());
	}
}