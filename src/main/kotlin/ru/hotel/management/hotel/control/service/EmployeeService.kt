package ru.hotel.management.hotel.control.service

import org.springframework.stereotype.Service
import ru.hotel.management.hotel.control.domain.Employee
import ru.hotel.management.hotel.control.domain.dto.EmployeeDTO
import ru.hotel.management.hotel.control.mapper.EmployeeMapper
import ru.hotel.management.hotel.control.repository.EmployeeRepository

@Service
class EmployeeService(
        val repository: EmployeeRepository,
        val mapper: EmployeeMapper
) {
    fun createUser(dto: EmployeeDTO): Employee {
        return repository.save(mapper.toEmployee(dto))
    }
}