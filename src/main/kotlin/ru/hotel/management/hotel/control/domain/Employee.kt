package ru.hotel.management.hotel.control.domain

import lombok.Data
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import ru.hotel.management.hotel.control.domain.enums.UserRole

@Data
@Document("employees")
data class Employee (
    @Id
    val id: ObjectId = ObjectId.get(),

    val username: String,

    val password: String,

    val firstName: String,

    val lastName: String,

    val role: UserRole,

    val hotelId: Long
)