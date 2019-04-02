package com.qa.landlordGateway.testMain.entitiesTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.landlordGateway.entity.LandlordBuilder;
import com.qa.landlordGateway.testMain.Constants;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LandlordBuilderTest {
	
	@Autowired
	private static LandlordBuilder landlordBuilder;

	@Before
	public void getBuilder() {
		this.landlordBuilder = LandlordBuilder.getLandlord();
		assertThat(landlordBuilder).isNotNull();
	}

	@After
	public void resetBuilder() {
		this.landlordBuilder = LandlordBuilder.getLandlord();
		assertThat(landlordBuilder).isNotNull();
	}

	@Test
	public void blankBuild() {
		assertThat(landlordBuilder.landlordBuild().matches(Constants.getDefaultBuilderLandlord()));
	}

	@Test
	public void setterBuild() {
		assertThat(landlordBuilder.firstName(Constants.getTestFirstName()).lastName(Constants.getTestLastName())
				.phoneNumber(Constants.getTestContactNumber()).email(Constants.getTestContactEmail())).isEqualToComparingFieldByField(Constants.getConstructedLandlord());
	}
}
