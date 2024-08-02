package com.example.hotelbooking.controller;

import com.example.hotelbooking.StringTestUtils;
import com.example.hotelbooking.entity.HotelEntity;
import com.example.hotelbooking.model.hotel.HotelRequest;
import com.example.hotelbooking.repository.HotelRepository;
import net.javacrumbs.jsonunit.JsonAssert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


public class HotelControllerTest extends AbstractControllerTest {

	@Autowired
	private HotelRepository hotelRepository;

	@Test
	public void whenCreateHotel_thenReturnSuccess() throws Exception{
		HotelRequest request = new HotelRequest(
				"test_name1",
				"test_title1",
				"test_city1",
				3000L);

		var response = mockMvc.perform(MockMvcRequestBuilders.post("/api/hotel")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request)))
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andReturn()
				.getResponse();

		String actualResponse = response.getContentAsString();
		String expectedResponse = StringTestUtils.readStringFromResource("controller/response/create-hotel-response.json");

		JsonAssert.assertJsonEquals(expectedResponse, actualResponse);
	}

	@Test
	public void whenUpdateHotel_thenReturnSuccess() throws Exception{
		HotelEntity entity = new HotelEntity(
				null,
				"test_name1",
				"test_title1",
				"test_city1",
				3000L,
				null,
				null
		);
		var existedHotel = hotelRepository.save(entity);

		HotelRequest request = new HotelRequest(
				"test_updated_name1",
				"test_updated_title1",
				"test_updated_city1",
				299L);

		var response = mockMvc.perform(MockMvcRequestBuilders.put("/api/hotel/{id}", existedHotel.getId())
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(request)))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn()
				.getResponse();

		String actualResponse = response.getContentAsString();
		String expectedResponse = StringTestUtils.readStringFromResource("controller/response/update-hotel-response.json");

		JsonAssert.assertJsonEquals(expectedResponse, actualResponse);
	}

}
