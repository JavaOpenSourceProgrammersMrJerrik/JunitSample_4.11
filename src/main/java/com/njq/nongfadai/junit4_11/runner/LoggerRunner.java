
package com.njq.nongfadai.junit4_11.runner;

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

/**
 * Copyright 2017 lcfarm All Rights Reserved 
 *  请添加类/接口的说明：
 * @Package: com.njq.nongfadai.junit4_11.runner 
 * @author: Jerrik   
 * @date: Jul 14, 2017 7:52:52 PM
 */
public class LoggerRunner extends BlockJUnit4ClassRunner {

    private static final DateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss_SSS");

    public LoggerRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
    protected Statement methodBlock(FrameworkMethod frameworkMethod) {
    	Method classMethod = frameworkMethod.getMethod();
		TestLogger testLogger = classMethod.getAnnotation(TestLogger.class);
        if (testLogger != null) {
            StringBuilder log = new StringBuilder(format.format(new Date()));
            log.append(" ").append(classMethod.getDeclaringClass().getName())
                    .append("#").append(classMethod.getName()).append(": ")
                    .append(testLogger.log());
            System.out.println("logger->: " + log.toString()); 
        }
        return super.methodBlock(frameworkMethod);
    }
}

