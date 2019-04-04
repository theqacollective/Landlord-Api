package com.qa.landlordGateway.testMain.serviceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.notNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.landlordGateway.entity.Landlord;
import com.qa.landlordGateway.repository.LandlordRepo;
import com.qa.landlordGateway.service.LandlordService;
import com.qa.landlordGateway.testMain.Constants;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LandlordServiceTest {
	@InjectMocks
	LandlordService landlordService;
	@Mock
	LandlordRepo landlordRepo;

	private List<Landlord> landlordList = new ArrayList<Landlord>();

	@Before
	public void setup() {
		landlordList.add(Constants.getDefaultBuilderLandlord());
		landlordList.add(Constants.getConstructedLandlord());
	}

	@After
	public void deconstruct() {
		landlordList.clear();
	}
	@Test
	public void getAllTest() {
		Mockito.when(landlordRepo.findAll()).thenReturn(landlordList);
		List<Landlord> returnList = landlordService.getLandlords();

		assertThat(returnList.size()).isEqualTo(2);
		assertThat(returnList.get(0)).isEqualToComparingFieldByField(Constants.getDefaultBuilderLandlord());
		assertThat(returnList.get(1)).isEqualToComparingFieldByField(Constants.getConstructedLandlord());
	}
	
	@Test
	public void createLandlordTest() {
		Landlord newLandlord = Constants.getConstructedLandlord();
		Mockito.when(landlordRepo.save((Landlord)notNull())).thenAnswer((Answer<?>) invocation -> {
			landlordList.add(newLandlord);
			return Constants.getNullLandlord();
		});
		assertThat(landlordService.createLandlord(newLandlord).getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(landlordList.size()).isEqualTo(3);
		assertThat(landlordList.get(2)).isEqualToComparingFieldByField(Constants.getConstructedLandlord());
	}
	
	@Test
	public void landlordSearchTest() {
		Landlord searchLandlord = Constants.getConstructedLandlord();
		Mockito.when(landlordRepo.findAll()).thenReturn(landlordList);
		assertThat(landlordService.landlordSearch(searchLandlord).size()).isEqualTo(1);
		assertThat(landlordService.landlordSearch(searchLandlord).get(0)).isEqualToComparingFieldByField(searchLandlord);
	}
}
