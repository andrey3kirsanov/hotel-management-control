package ru.hotel.management.hotel.control.mapper

import org.mapstruct.Mapper
import ru.hotel.management.hotel.control.domain.Customer
import ru.hotel.management.hotel.control.domain.message.CustomerPush

@Mapper(componentModel = "spring")
interface CustomerMapper {
    fun toCustomer(dto: CustomerPush): Customer
}