package ru.hotel.management.central.domain

import lombok.*
import java.io.Serializable

@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
class Hotel(val id: Long, val name: String, val country: String, val roomCount: Int) : Serializable {
}