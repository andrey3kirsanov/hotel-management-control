package ru.hotel.management.hotel.control.domain.dto

import lombok.Getter
import lombok.Setter
import java.time.Instant

@Getter
@Setter
class TaskDTO (
        val id: String,

        val name: String,

        val description: String,

        val createdDateTime: Instant,

        val updatedDateTime: Instant,

        val hotelId: Long,

        val roomId: Long
)