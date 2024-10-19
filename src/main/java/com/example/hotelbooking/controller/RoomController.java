package com.example.hotelbooking.controller;

import com.example.hotelbooking.entity.RoomEntity;
import com.example.hotelbooking.mapper.RoomMapper;
import com.example.hotelbooking.model.room.RoomRequest;
import com.example.hotelbooking.model.room.RoomResponse;
import com.example.hotelbooking.service.RoomService;
import jakarta.validation.Valid;
import java.util.UUID;
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
@RequestMapping("/api/room")
@RequiredArgsConstructor
public class RoomController {

	private final RoomService roomService;
	private final RoomMapper roomMapper;

	@GetMapping("/{id}")
	public ResponseEntity<RoomResponse> getById(@PathVariable UUID id) {
		return ResponseEntity.ok(roomMapper.roomEntityToRoomResponse(roomService.findById(id)));
	}

	@PostMapping
	public ResponseEntity<RoomResponse> create(@RequestBody @Valid RoomRequest request) {
		var newRoom = roomService.create(roomMapper.roomRequestToRoomEntity(request));
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(roomMapper.roomEntityToRoomResponse(newRoom));
	}

	@PutMapping("/{id}")
	public ResponseEntity<RoomResponse> update(@PathVariable UUID id, @RequestBody @Valid RoomRequest request) {
		var roomForUpdate = roomMapper.roomRequestToRoomEntity(request);
		roomForUpdate.setId(id);

		return ResponseEntity.ok(roomMapper.roomEntityToRoomResponse(roomService.update(roomForUpdate)));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable UUID id) {
		roomService.deleteById(id);

		return ResponseEntity.ok().build();
	}
}
