package ru.hotel.management.hotel.control.domain

import lombok.Data
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Data
@Document("tasks")
data class Task (
        @Id
        val id: ObjectId = ObjectId.get(),

        val name: String,

        val description: String,

        val createdDateTime: Instant,

        val updatedDateTime: Instant,

        val hotelId: Long,

        val roomId: Long
)