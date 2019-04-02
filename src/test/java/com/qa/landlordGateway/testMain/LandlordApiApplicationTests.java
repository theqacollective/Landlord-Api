package com.qa.landlordGateway.testMain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.landlordGateway.LandlordApiApplication;
import com.qa.landlordGateway.MainConstants;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LandlordApiApplicationTests {

	private LandlordApiApplication app;
	private TestSuite suite;
	private Constants constants;
	private MainConstants mainConstants;
	@Before
	public void setup() {
		this.app = new LandlordApiApplication();
		this.suite = new TestSuite();
		this.constants = new Constants();
		this.mainConstants = new MainConstants();
	}
	@Test
	public void contextLoads() {
		String[] args = new String[] {"Hello World"};
		app.main(args);
	}
	

}
