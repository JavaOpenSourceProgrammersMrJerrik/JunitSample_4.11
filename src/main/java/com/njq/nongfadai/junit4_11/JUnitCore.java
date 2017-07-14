
package com.njq.nongfadai.junit4_11;

import java.util.ArrayList;
import java.util.List;

import org.junit.internal.JUnitSystem;
import org.junit.internal.RealSystem;
import org.junit.internal.TextListener;
import org.junit.internal.runners.JUnit38ClassRunner;
import org.junit.runner.Computer;
import org.junit.runner.Description;
import org.junit.runner.Request;
import org.junit.runner.Result;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;

import junit.runner.Version;

/**
 * Copyright 2017 lcfarm All Rights Reserved 
 *  请添加类/接口的说明：JUnit 主程序入口 main方法
 * @Package: com.njq.nongfadai 
 * @author: Jerrik   
 * @date: Jul 13, 2017 2:08:13 PM
 */
public class JUnitCore {
	private final RunNotifier fNotifier = new RunNotifier();

	/**
	 * Run the tests contained in the classes named in the <code>args</code>.
	 * If all tests run successfully, exit with a status of 0. Otherwise exit with a status of 1.
	 * Write feedback while tests are running and write
	 * stack traces for all failed tests after the tests all complete.
	 *
	 * @param args names of classes in which to find tests to run
	 */
	public static void main(String... args) {
		runMainAndExit(new RealSystem(), args);
	}

	/**
	 * Runs main and exits
	 */
	private static void runMainAndExit(JUnitSystem system, String... args) {
		Result result = new JUnitCore().runMain(system, args);
		System.exit(result.wasSuccessful() ? 0 : 1);
	}

	/**
	 * Run the tests contained in <code>classes</code>. Write feedback while the tests
	 * are running and write stack traces for all failed tests after all tests complete. This is
	 * similar to {@link #main(String[])}, but intended to be used programmatically.
	 *
	 * @param computer Helps construct Runners from classes
	 * @param classes Classes in which to find tests
	 * @return a {@link Result} describing the details of the test run and the failed tests.
	 */
	public static Result runClasses(Computer computer, Class<?>... classes) {
		return new JUnitCore().run(computer, classes);
	}

	/**
	 * Run the tests contained in <code>classes</code>. Write feedback while the tests
	 * are running and write stack traces for all failed tests after all tests complete. This is
	 * similar to {@link #main(String[])}, but intended to be used programmatically.
	 *
	 * @param classes Classes in which to find tests
	 * @return a {@link Result} describing the details of the test run and the failed tests.
	 */
	public static Result runClasses(Class<?>... classes) {
		return new JUnitCore().run(defaultComputer(), classes);
	}

	/**
	 * @param system
	 * @args args from main()
	 */
	private Result runMain(JUnitSystem system, String... args) {
		system.out().println("JUnit version " + Version.id());
		List<Class<?>> classes = new ArrayList<Class<?>>();
		List<Failure> missingClasses = new ArrayList<Failure>();
		for (String each : args) {
			try {
				classes.add(Class.forName(each));
			} catch (ClassNotFoundException e) {
				system.out().println("Could not find class: " + each);
				Description description = Description.createSuiteDescription(each);
				Failure failure = new Failure(description, e);
				missingClasses.add(failure);
			}
		}
		RunListener listener = new TextListener(system);
		addListener(listener);
		Result result = run(classes.toArray(new Class[0]));
		for (Failure each : missingClasses) {
			result.getFailures().add(each);
		}
		return result;
	}

	/**
	 * @return the version number of this release
	 */
	public String getVersion() {
		return Version.id();
	}

	/**
	 * Run all the tests in <code>classes</code>.
	 *
	 * @param classes the classes containing tests
	 * @return a {@link Result} describing the details of the test run and the failed tests.
	 */
	public Result run(Class<?>... classes) {
		return run(Request.classes(defaultComputer(), classes));
	}

	/**
	 * Run all the tests in <code>classes</code>.
	 *
	 * @param computer Helps construct Runners from classes
	 * @param classes the classes containing tests
	 * @return a {@link Result} describing the details of the test run and the failed tests.
	 */
	public Result run(Computer computer, Class<?>... classes) {
		return run(Request.classes(computer, classes));
	}

	/**
	 * Run all the tests contained in <code>request</code>.
	 *
	 * @param request the request describing tests
	 * @return a {@link Result} describing the details of the test run and the failed tests.
	 */
	public Result run(Request request) {
		return run(request.getRunner());
	}

	/**
	 * Run all the tests contained in JUnit 3.8.x <code>test</code>. Here for backward compatibility.
	 *
	 * @param test the old-style test
	 * @return a {@link Result} describing the details of the test run and the failed tests.
	 */
	public Result run(junit.framework.Test test) {
		return run(new JUnit38ClassRunner(test));
	}

	/**
	 * Do not use. Testing purposes only.
	 */
	public Result run(Runner runner) {
		Result result = new Result();
		RunListener listener = result.createListener();
		fNotifier.addFirstListener(listener);
		try {
			fNotifier.fireTestRunStarted(runner.getDescription());
			runner.run(fNotifier);
			fNotifier.fireTestRunFinished(result);
		} finally {
			removeListener(listener);
		}
		return result;
	}

	/**
	 * Add a listener to be notified as the tests run.
	 *
	 * @param listener the listener to add
	 * @see org.junit.runner.notification.RunListener
	 */
	public void addListener(RunListener listener) {
		fNotifier.addListener(listener);
	}

	/**
	 * Remove a listener.
	 *
	 * @param listener the listener to remove
	 */
	public void removeListener(RunListener listener) {
		fNotifier.removeListener(listener);
	}

	static Computer defaultComputer() {
		return new Computer();
	}

}
