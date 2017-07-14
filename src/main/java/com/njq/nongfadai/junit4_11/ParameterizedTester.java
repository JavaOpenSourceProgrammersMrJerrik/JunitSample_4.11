
package com.njq.nongfadai.junit4_11;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Copyright 2017 lcfarm All Rights Reserved 
 *  请添加类/接口的说明：
 * @Package: com.njq.nongfadai 
 * @author: Jerrik   
 * @date: Jul 13, 2017 2:22:57 PM
 */
@RunWith(Parameterized.class)
public class ParameterizedTester {
	private int paramOne;
	private int paramTwo;
	private int sum;

	public ParameterizedTester(int paramOne, int paramTwo, int sum) {
		this.sum = sum;
		this.paramOne = paramOne;
		this.paramTwo = paramTwo;
	}

	@Parameters
	public static Collection<Integer[]> getTestParameters() {
		return Arrays.asList(new Integer[][] { { 1, 1, 2 }, { 1, 2, 3 }, { 1, 3, 5 } });
	}

	@Test
	public void testParameter() {
		assertEquals(add(paramOne, paramTwo), sum);
	}

	public int add(int a, int b) {
		return a + b;
	}
}
