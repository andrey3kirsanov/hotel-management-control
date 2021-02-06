package ru.hotel.management.hotel.control.mapper

import org.mapstruct.Mapper
import ru.hotel.management.hotel.control.domain.message.HotelPush
import ru.hotel.management.hotel.control.domain.Hotel

@Mapper(componentModel = "spring")
interface HotelMapper {
    fun toHotel(dto: HotelPush): Hotel
}