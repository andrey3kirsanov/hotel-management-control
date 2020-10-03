package ru.hotel.management.central.domain.dto

import lombok.*
import ru.hotel.management.central.domain.Hotel

@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
class HotelDTO(val id: Long, val name: String, val country: String, val roomCount: Int) {
    fun convertToModel(dto: HotelDTO): Hotel {
        val hotel = Hotel(dto.id, dto.name, dto.country, dto.roomCount)
        return hotel
    }
}