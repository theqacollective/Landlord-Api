package com.qa.landlordgateway.testMain.entitiesTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.landlordgateway.entity.LandlordBuilder;
import com.qa.landlordgateway.testMain.Constants;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LandlordBuilderTest {
	
	@Autowired
	private LandlordBuilder landlordBuilder;

	@Before
	public void getBuilder() {
		this.landlordBuilder = landlordBuilder.getLandlord();
		assertThat(landlordBuilder).isNotNull();
	}

	@After
	public void resetBuilder() {
		this.landlordBuilder = landlordBuilder.getLandlord();
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
