package ru.hotel.management.hotel.control.domain

import lombok.Data
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant
import java.time.LocalDate

@Data
@Document("customers")
class Customer(
        @Id
        var id: Long,

        val firstName: String,

        val lastName: String,

        val dateOfBirth: LocalDate,

        val createdDateTime: Instant,

        val updatedDateTime: Instant,

        var rooms: MutableList<Room>
)
