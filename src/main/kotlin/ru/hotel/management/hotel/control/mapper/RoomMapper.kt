package ru.hotel.management.hotel.control.mapper

import org.mapstruct.Mapper
import ru.hotel.management.hotel.control.domain.Room
import ru.hotel.management.hotel.control.domain.message.RoomPush

@Mapper(componentModel = "spring")
interface RoomMapper {
    fun toRoom(dto: RoomPush): Room

    fun toRoomList(dtos: List<RoomPush>): List<Room>
}