package ru.hotel.management.central.domain.dto

import lombok.*
import java.util.*

@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
class BookedRoomDTO(val id: UUID, val price: Int) {
}