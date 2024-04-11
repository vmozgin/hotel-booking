package com.example.hotelbooking.model;

import lombok.Data;

@Data
public class HotelRequest {

	private String name;
	private String title;
	private String city;
	private Long distanceFromCenter;
}
