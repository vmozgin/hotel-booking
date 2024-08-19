package com.example.hotelbooking.model.room;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomRequest {

	@NotBlank
	private String name;
	private String description;
	@NotNull
	private Integer number;
	@NotNull
	private Integer maxPeoplesCount;
	private List<UnavailableDates> unavailableDates;
	@NotNull
	private UUID hotelId;
}
