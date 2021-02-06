package ru.hotel.management.hotel.control.domain.message

import lombok.Getter
import lombok.Setter
import java.time.Instant

@Getter
@Setter
class HotelFacilityPush(
        var id: Long,

        var name: String,

        var description: String,

        var createdDateTime: Instant,

        var updatedDateTime: Instant
)