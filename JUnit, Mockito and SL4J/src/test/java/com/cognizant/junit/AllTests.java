package com.cognizant.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Exercise 2: Test Suites and Categories
 * 
 * Groups all test classes together into a single test suite.
 * When this suite class is run, all grouped tests will run sequentially.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    EvenCheckerTest.class,
    ExceptionThrowerTest.class,
    PerformanceTesterTest.class,
    OrderedTests.class
})
public class AllTests {
    // This class remains empty. It only serves as a holder for the annotations.
}
