package ru.hotel.management.hotel.control.domain

import lombok.Data
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Data
@Document("hotels")
data class Hotel (
        @Id
        val id: Long,

        val name: String,

        val description: String,

        val createdDateTime: Instant,

        val updatedDateTime: Instant,

        val rooms: List<Room>,

        val facilities: List<HotelFacility>
)