package com.qa.landlordGateway.testMain.controllerTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.qa.landlordGateway.controllers.LandlordController;
import com.qa.landlordGateway.entity.Landlord;
import com.qa.landlordGateway.entity.LandlordBuilder;
import com.qa.landlordGateway.service.LandlordService;
import com.qa.landlordGateway.testMain.Constants;

@RunWith(SpringRunner.class)
@WebMvcTest(LandlordController.class)
@AutoConfigureWebMvc
public class LandlordControllerTest {

	private MockMvc mockMvc;
	@MockBean
	private LandlordService service;
	@MockBean
	private LandlordBuilder builder;
	@MockBean
	RestTemplateBuilder rtb;

	private Landlord testLandlord;

	@Before
	public void setUp() {
		this.testLandlord = Constants.getConstructedLandlord();
	}

	@Test
	public void testLandlordCreation() throws Exception {
		assertEquals(service.createLandlord(testLandlord),"Landlord Created");
		
	}

	@Test
	public void testGetAllLandlords() throws Exception {
		List<Landlord> MOCKED_LANDLORDS = new ArrayList<Landlord>();
		MOCKED_LANDLORDS.add(testLandlord);
		when(service.getLandlords()).thenReturn(MOCKED_LANDLORDS);
		assertEquals(1,service.getLandlords().size());
	}

	@Test
	public void testLandlordSearch() throws Exception {
		List<Landlord> MOCKED_LANDLORDS = new ArrayList<Landlord>();
		MOCKED_LANDLORDS.add(testLandlord);
		MOCKED_LANDLORDS.add(Constants.getDefaultBuilderLandlord());

		Mockito.when(service.landlordSearch((Landlord) notNull())).thenReturn(
				MOCKED_LANDLORDS.stream().filter(x -> x.matches(testLandlord)).collect(Collectors.toList()));
		Constants.OBJECT_MAPPER.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
	}

	public MockMvc getMockMvc() {
		return mockMvc;
	}

	public void setMockMvc(MockMvc mockMvc) {
		this.mockMvc = mockMvc;
	}

}
