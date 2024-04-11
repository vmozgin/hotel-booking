package com.example.hotelbooking.controller;

import com.example.hotelbooking.entity.HotelEntity;
import com.example.hotelbooking.mapper.HotelMapper;
import com.example.hotelbooking.model.HotelRequest;
import com.example.hotelbooking.model.HotelResponse;
import com.example.hotelbooking.service.HotelService;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hotel")
@RequiredArgsConstructor
public class HotelController {

	private final HotelService hotelService;
	private final HotelMapper hotelMapper;

	@GetMapping("/{id}")
	public ResponseEntity<HotelResponse> getById(@PathVariable UUID id) {
		return ResponseEntity.ok(hotelMapper.hotelEntityToHotelResponse(hotelService.findById(id)));
	}

	@PostMapping
	public ResponseEntity<HotelResponse> create(@RequestBody HotelRequest request) {
		HotelEntity newHotel = hotelService.create(hotelMapper.hotelRequestToHotelEntity(request));
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(hotelMapper.hotelEntityToHotelResponse(newHotel));
	}

	@PutMapping("/{id}")
	public ResponseEntity<HotelResponse> update(@PathVariable UUID id, @RequestBody HotelRequest request) {
		HotelEntity hotelForUpdate = hotelMapper.hotelRequestToHotelEntity(request);
		hotelForUpdate.setId(id);

		return ResponseEntity.ok(hotelMapper.hotelEntityToHotelResponse(hotelService.update(hotelForUpdate)));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable UUID id) {
		hotelService.deleteById(id);

		return ResponseEntity.ok().build();
	}

	@GetMapping
	public ResponseEntity<List<HotelResponse>> getAll() {
		return ResponseEntity.ok(hotelService.findAll().stream()
				.map(hotelMapper::hotelEntityToHotelResponse)
				.collect(Collectors.toList()));
	}
}
