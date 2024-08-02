package com.example.hotelbooking.model.hotel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
