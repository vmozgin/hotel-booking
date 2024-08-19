package com.example.hotelbooking.model.room;

import java.util.List;
import java.util.UUID;
import lombok.Data;

@Data
public class RoomResponse {

	private UUID id;
	private String name;
	private String description;
	private Integer number;
	private Integer maxPeoplesCount;
	private List<UnavailableDates> unavailableDates;
	private UUID hotelId;
}
