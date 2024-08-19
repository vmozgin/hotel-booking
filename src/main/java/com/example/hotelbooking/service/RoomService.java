package com.example.hotelbooking.service;

import com.example.hotelbooking.entity.RoomEntity;
import com.example.hotelbooking.entity.UnavailableDatesEntity;
import com.example.hotelbooking.exception.EntityNotFoundException;
import com.example.hotelbooking.repository.RoomRepository;
import java.text.MessageFormat;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomService {

	private final RoomRepository roomRepository;
	private final HotelService hotelService;

	public RoomEntity findById(UUID id) {
		return roomRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(
						MessageFormat.format("Комната с id = {0} не найдена", id))
				);
	}

	public RoomEntity create(RoomEntity entity) {
		var hotel = hotelService.findById(entity.getHotel().getId());
		entity.setHotel(hotel);

		for (UnavailableDatesEntity date : entity.getUnavailableDates()) {
			date.setRoom(entity);
		}

		return roomRepository.save(entity);
	}

	public RoomEntity update(RoomEntity entity) {
		RoomEntity existedEntity = findById(entity.getId());
		existedEntity.setName(entity.getName());
		existedEntity.setDescription(entity.getDescription());
		existedEntity.setNumber(entity.getNumber());
		existedEntity.setHotel(entity.getHotel());
		if (entity.getUnavailableDates() != null) {
			existedEntity.setUnavailableDates(entity.getUnavailableDates());
		}

		return roomRepository.save(existedEntity);
	}

	public void deleteById(UUID id) {
		roomRepository.deleteById(id);
	}
}
