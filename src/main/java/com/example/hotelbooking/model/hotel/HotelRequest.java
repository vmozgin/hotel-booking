package com.example.hotelbooking.model.hotel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class HotelRequest {

	@NotBlank
	private String name;
	@NotBlank
	private String title;
	@NotBlank
	private String city;
	@NotNull
	private Long distanceFromCenter;
}
