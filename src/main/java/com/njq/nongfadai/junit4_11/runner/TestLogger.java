
package com.njq.nongfadai.junit4_11.runner;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Copyright 2017 lcfarm All Rights Reserved 
 *  请添加类/接口的说明：
 * @Package: com.njq.nongfadai.junit4_11.runner 
 * @author: Jerrik   
 * @date: Jul 14, 2017 7:59:04 PM
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface TestLogger {
	public String log() default "";
}
