package ru.hotel.management.hotel.control.domain.dto

import lombok.Builder
import lombok.Getter
import lombok.Setter
import ru.hotel.management.hotel.control.domain.HotelFacilities
import java.time.Instant

@Getter
@Setter
@Builder
class HotelPush(
        val id: Long,

        val name: String,

        val description: String,

        val createdDateTime: Instant,

        val updatedDateTime: Instant,

        val facilities: List<HotelFacilities>
)
