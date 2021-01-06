package ru.hotel.management.hotel.control.mapper

import org.mapstruct.Mapper
import ru.hotel.management.hotel.control.domain.Hotel
import ru.hotel.management.hotel.control.domain.dto.HotelPush

@Mapper(componentModel = "spring")
interface HotelMapper {
    fun toHotel(dto: HotelPush): Hotel
}