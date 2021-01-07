package ru.hotel.management.hotel.control.mapper

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import ru.hotel.management.hotel.control.domain.Employee
import ru.hotel.management.hotel.control.domain.dto.EmployeeDTO

@Mapper(componentModel = "spring")
interface EmployeeMapper {
    @Mapping(target = "id", expression = "java(ObjectId.get())")
    fun toEmployee(dto: EmployeeDTO): Employee
}