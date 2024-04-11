package com.example.hotelbooking.model.hotel;

import java.util.UUID;
import lombok.Data;

@Data
public class HotelResponse {

	private UUID id;
	private String name;
	private String title;
	private String city;
	private Long distanceFromCenter;
	private Integer rating;
	private Integer ratingCount;
}
