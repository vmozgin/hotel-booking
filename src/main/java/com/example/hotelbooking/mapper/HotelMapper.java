package com.example.hotelbooking.mapper;

import com.example.hotelbooking.entity.HotelEntity;
import com.example.hotelbooking.model.hotel.HotelRequest;
import com.example.hotelbooking.model.hotel.HotelResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface HotelMapper {

	HotelRequest hotelEntityToHotel(HotelEntity source);

	HotelEntity hotelRequestToHotelEntity(HotelRequest source);

	HotelResponse hotelEntityToHotelResponse(HotelEntity source);
}
