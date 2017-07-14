
package com.njq.nongfadai.junit4_11.runner;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

/**
 * Copyright 2017 lcfarm All Rights Reserved 
 *  请添加类/接口的说明：执行时间Runner
 * @Package: com.njq.nongfadai.junit4_11.runner 
 * @author: Jerrik   
 * @date: Jul 14, 2017 8:00:54 PM
 */
@RunWith(ExecuteTimeRunner.class)
public class ExecuteTimeRunnerTest {

	@Test
	@ExecuteTime
	public void testLoggerRunner(){
		try {
			assertNotNull("okay");
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}


