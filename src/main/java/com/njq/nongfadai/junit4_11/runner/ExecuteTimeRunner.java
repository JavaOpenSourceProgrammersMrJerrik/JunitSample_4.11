
package com.njq.nongfadai.junit4_11.runner;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

/**
 * Copyright 2017 lcfarm All Rights Reserved 
 *  请添加类/接口的说明：执行时间Runner
 * @Package: com.njq.nongfadai.junit4_11.runner 
 * @author: Jerrik   
 * @date: Jul 14, 2017 7:52:52 PM
 */
public class ExecuteTimeRunner extends BlockJUnit4ClassRunner {

    public ExecuteTimeRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }
    
    static ThreadLocal<Long> startTime = new ThreadLocal<Long>();

    
    @Override
    protected Statement withBefores(FrameworkMethod method, Object target, Statement statement) {
    	Statement state = super.withBefores(method, target, statement);
    	return new Statement() {
			@Override
			public void evaluate() throws Throwable {
				startTime.set(System.currentTimeMillis());
				state.evaluate();
			}
		};
    }
    
    @Override
    protected Statement withAfters(FrameworkMethod method, Object target, Statement statement) {
    	Statement state = super.withAfters(method, target, statement);
    	return new Statement() {
			@Override
			public void evaluate() throws Throwable {
				state.evaluate();
				if(method.getAnnotation(ExecuteTime.class) != null){
					System.out.println("elapsed time is: " + (System.currentTimeMillis()-startTime.get()) + "ms");
				}
			}
		};
    }
}

