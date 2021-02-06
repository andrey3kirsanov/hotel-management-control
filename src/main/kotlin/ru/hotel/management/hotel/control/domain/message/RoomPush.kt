package ru.hotel.management.hotel.control.domain.message

import lombok.Getter
import lombok.Setter
import ru.hotel.management.hotel.control.domain.enums.RoomStatus
import java.time.Instant

@Getter
@Setter
class RoomPush(
        var id: Long,

        var name: String,

        var description: String,

        var status: RoomStatus,

        var price: Int = 0,

        var availableNumber: Int = 0,

        var bookedNumber: Int = 0,

        var createdDateTime: Instant,

        var updatedDateTime: Instant,

        var bookedDateTime: Instant?,

        var facilities: MutableList<RoomFacilityPush>
)
