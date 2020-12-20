package ru.hotel.management.hotel.control.domain

import lombok.Builder
import lombok.Getter
import lombok.Setter
import java.time.Instant

@Getter
@Setter
@Builder
class HotelFacilities(
        var id: Long,

        var name: String,

        var description: String,

        var createdDateTime: Instant,

        var updatedDateTime: Instant
)
