package com.qa.landlordGateway.testMain.entitiesTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.landlordGateway.entity.Landlord;
import com.qa.landlordGateway.testMain.Constants;


@RunWith(SpringRunner.class)
@SpringBootTest
public class LandlordTest {
	@Test
	public void superConstructorTest() {
		Landlord landlord = new Landlord();
		assertThat(landlord).isNotNull();
	}
	@Test
	public void fullConstructorTest() {
		Landlord landlord = new Landlord(Constants.getNaString(), Constants.getNaString(), Constants.getNaString(),
				Constants.getNaString());
		assertThat(landlord.matches(Constants.getDefaultBuilderLandlord()));
	}
	@Test
	public void getterTest(){
		assertNull(Constants.getNullLandlord().getFirstName());
		assertNull(Constants.getNullLandlord().getLastName());
		assertNull(Constants.getNullLandlord().getPhoneNumber());
		assertNull(Constants.getNullLandlord().getEmail());
	}
	@Test
	public void setttertest() {
		Landlord testLandlord = Constants.getNullLandlord();
		testLandlord.setFirstName(Constants.getNaString());
		testLandlord.setLastName(Constants.getNaString());
		testLandlord.setPhoneNumber(Constants.getNaString());
		testLandlord.setEmail(Constants.getNaString());
		assertThat(testLandlord.matches(Constants.getConstructedLandlord()));
	}
}
