
package com.njq.nongfadai.junit4_11;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Copyright 2017 lcfarm All Rights Reserved 
 *  请添加类/接口的说明：使用Suit Runner,可以一次性执行多个Runner中的@Test方法,忽略加了@Ignore方法的单元测试.
 * @Package: com.njq.nongfadai 
 * @author: Jerrik   
 * @date: Jul 13, 2017 2:15:29 PM
 */
@RunWith(Suite.class)
@SuiteClasses(value = { AssertTester.class })
public class SuitTester {
	/**
	 * output:
	 *  before 13554774675
		testException方法()
		tearDown
		before 13554774675
		testNotFound方法()
		tearDown
		before 13554774675
		testA方法()
		tearDown
	 */
}
