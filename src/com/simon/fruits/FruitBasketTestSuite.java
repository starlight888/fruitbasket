package com.simon.fruits;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({FruitBasketLoadTest.class,FruitBasketCalculateTest.class,
	FruitConstructorTest.class})
public class FruitBasketTestSuite {

}
