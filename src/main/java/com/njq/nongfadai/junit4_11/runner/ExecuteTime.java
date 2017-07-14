
package com.njq.nongfadai.junit4_11.runner;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Copyright 2017 lcfarm All Rights Reserved 
 *  请添加类/接口的说明：统计每个junit方法 执行时间
 * @Package: com.njq.nongfadai.junit4_11.runner 
 * @author: Jerrik   
 * @date: Jul 14, 2017 8:08:52 PM
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExecuteTime {

}

