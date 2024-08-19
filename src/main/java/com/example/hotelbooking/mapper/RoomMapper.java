package com.example.hotelbooking.mapper;

import com.example.hotelbooking.entity.RoomEntity;
import com.example.hotelbooking.model.room.RoomRequest;
import com.example.hotelbooking.model.room.RoomResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoomMapper {

	@Mapping(target = "hotel.id", source = "hotelId")
	RoomEntity roomRequestToRoomEntity(RoomRequest roomRequest);

	@Mapping(target = "hotelId", source = "hotel.id")
	RoomResponse roomEntityToRoomResponse(RoomEntity roomEntity);
}
