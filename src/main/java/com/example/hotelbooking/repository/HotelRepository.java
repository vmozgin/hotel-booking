package com.example.hotelbooking.repository;

import com.example.hotelbooking.entity.HotelEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<HotelEntity, UUID> {
}
