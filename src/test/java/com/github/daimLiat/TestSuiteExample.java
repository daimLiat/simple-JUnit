 package com.github.daimLiat;

 import org.junit.platform.suite.api.*;

 @Suite
 @SuiteDisplayName("FirstSuite")
 @SelectClasses({
         MagicBallTest.class,
         SubClassTest.class
 })
 public class TestSuiteExample {

 }
