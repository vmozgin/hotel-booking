package com.example.hotelbooking.mapper;

import com.example.hotelbooking.entity.HotelEntity;
import com.example.hotelbooking.model.HotelRequest;
import com.example.hotelbooking.model.HotelResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface HotelMapper {

	HotelRequest hotelEntityToHotel(HotelEntity source);

	HotelEntity hotelRequestToHotelEntity(HotelRequest source);

	HotelResponse hotelEntityToHotelResponse(HotelEntity source);
}
