
package com.qa.landlordGateway.testMain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.boot.test.context.SpringBootTest;

import com.qa.landlordGateway.testMain.controllerTest.LandlordControllerTest;
import com.qa.landlordGateway.testMain.entitiesTest.LandlordBuilderTest;
import com.qa.landlordGateway.testMain.entitiesTest.LandlordTest;
import com.qa.landlordGateway.testMain.repositoryTest.LandlordRepoTest;
import com.qa.landlordGateway.testMain.serviceTest.LandlordServiceTest;

@RunWith(Suite.class)

@SuiteClasses({ LandlordTest.class, LandlordServiceTest.class, LandlordRepoTest.class,
		LandlordApiApplicationTests.class, LandlordControllerTest.class, LandlordBuilderTest.class })

@SpringBootTest
public class TestSuite {

}
