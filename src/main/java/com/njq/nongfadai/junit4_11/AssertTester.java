
package com.njq.nongfadai.junit4_11;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Copyright 2017 lcfarm All Rights Reserved 
 *  请添加类/接口的说明：
 * @Package: com.njq.nongfadai 
 * @author: Jerrik   
 * @date: Jul 13, 2017 10:29:12 AM
 */
public class AssertTester {

	@Before
	public void setUp(){
		System.out.println("before 13554774675");
	}
	
	@Test
	//@Ignore
	public void testA(){
		System.out.println("testA方法()");
		assertEquals("呵呵",true, true);
		assertEquals(true, true);
		assertEquals(3, 3);
		assertArrayEquals(new String[]{"hello"}, new String[]{"hello","world"});
	}
	
	@Test
	public void testAssertTrue(){
		assertTrue(false);
	}
	
	@Test
	public void testNotFound(){
		System.out.println("testNotFound方法()");
		assertNotEquals(3, 4);
		assertTrue("not true",3<4);
		assertFalse(false);
		assertNull(null);
		assertNotNull(11);
	}
	
	@Test(expected = Exception.class)
	//@Test
	public void testException(){
		System.out.println("testException方法()");
		int index = 1/0;
		System.out.println(index);
	}
	
	@Test(timeout = 5000)//毫秒
	public void testTimeout(){
		for(;;){
		}
	}
	
	@After
	public void tearDown(){
		System.out.println("tearDown");
	}
}

