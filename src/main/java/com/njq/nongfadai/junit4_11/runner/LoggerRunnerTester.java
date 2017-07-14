
package com.njq.nongfadai.junit4_11.runner;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

/**
 * Copyright 2017 lcfarm All Rights Reserved 
 *  请添加类/接口的说明：
 * @Package: com.njq.nongfadai.junit4_11.runner 
 * @author: Jerrik   
 * @date: Jul 14, 2017 8:00:54 PM
 */
@RunWith(LoggerRunner.class)
public class LoggerRunnerTester {

	@Test
	@TestLogger(log = "自己测试一下,没毛病.")
	public void testLoggerRunner(){
		assertNotNull("okay");
	}
}


