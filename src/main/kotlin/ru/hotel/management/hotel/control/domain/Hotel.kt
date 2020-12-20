package ru.hotel.management.hotel.control.domain

import lombok.Builder
import lombok.Getter
import lombok.Setter
import java.time.Instant

@Getter
@Setter
@Builder
class Hotel(
        val id: Long,

        val name: String,

        val description: String,

        val createdDateTime: Instant,

        val updatedDateTime: Instant,

        val facilities: List<HotelFacilities>
)
