package com.qa.landlordGateway.testMain.repositoryTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.landlordGateway.repository.LandlordRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LandlordRepoTest {

		@Autowired
		private LandlordRepo landlordRepo;
		
		@Test
		public void initialisationTest() {
			assertThat(landlordRepo).isNotNull();
		}
		@Test
		public void noDataTest() {
			assertThat(landlordRepo.count()).isEqualTo(0);
		}
}
