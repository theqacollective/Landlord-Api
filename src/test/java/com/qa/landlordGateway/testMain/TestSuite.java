
package com.qa.landlordgateway.testMain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.boot.test.context.SpringBootTest;

import com.qa.landlordgateway.testMain.controllerTest.LandlordControllerTest;
import com.qa.landlordgateway.testMain.entitiesTest.LandlordBuilderTest;
import com.qa.landlordgateway.testMain.entitiesTest.LandlordTest;
import com.qa.landlordgateway.testMain.repositoryTest.LandlordRepoTest;
import com.qa.landlordgateway.testMain.serviceTest.LandlordServiceTest;

@RunWith(Suite.class)

@SuiteClasses({ LandlordTest.class, LandlordServiceTest.class, LandlordRepoTest.class,
		LandlordApiApplicationTests.class, LandlordControllerTest.class, LandlordBuilderTest.class })

@SpringBootTest
public class TestSuite {

}
