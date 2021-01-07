package ru.hotel.management.hotel.control.domain.dto

import lombok.Getter
import lombok.Setter
import ru.hotel.management.hotel.control.domain.enums.UserRole

@Getter
@Setter
class EmployeeDTO (
    val username: String,

    val password: String,

    val firstName: String,

    val lastName: String,

    val role: UserRole,

    val hotelId: Long
)