package com.example.hotelbooking.service;

import com.example.hotelbooking.entity.HotelEntity;
import com.example.hotelbooking.exception.EntityNotFoundException;
import com.example.hotelbooking.repository.HotelRepository;
import java.text.MessageFormat;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HotelService {

	private final HotelRepository hotelRepository;

	public List<HotelEntity> findAll() {
		return hotelRepository.findAll();
	}

	public HotelEntity findById(UUID id) {
		return hotelRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(
						MessageFormat.format("Отель с id = {id} не найден", id))
				);
	}

	public HotelEntity create(HotelEntity entity) {
		return hotelRepository.save(entity);
	}

	public HotelEntity update(HotelEntity entity) {
		HotelEntity existedEntity = findById(entity.getId());
		existedEntity.setCity(entity.getCity());
		existedEntity.setTitle(entity.getTitle());
		existedEntity.setName(entity.getName());
		existedEntity.setDistanceFromCenter(entity.getDistanceFromCenter());

		return hotelRepository.save(existedEntity);
	}

	public void deleteById(UUID id) {
		hotelRepository.deleteById(id);
	}
}
