package ru.hotel.management.hotel.control.service

import org.bson.types.ObjectId
import org.springframework.stereotype.Service
import ru.hotel.management.hotel.control.domain.dto.EmployeeDTO
import ru.hotel.management.hotel.control.mapper.EmployeeMapper
import ru.hotel.management.hotel.control.repository.EmployeeRepository
import java.lang.IllegalArgumentException

@Service
class EmployeeService(
        val repository: EmployeeRepository,
        val mapper: EmployeeMapper
) {
    fun findEmployee(id: String): EmployeeDTO {
        val userOptional = repository.findById(ObjectId(id));
        if (userOptional.isEmpty) {
            throw IllegalArgumentException(String.format("Couldn't find employee with id: %s ", id))
        }
        return mapper.toEmployeeDTO(userOptional.get())
    }

    fun createEmployee(dto: EmployeeDTO): EmployeeDTO {
        return mapper.toEmployeeDTO(repository.save(mapper.toEmployee(dto)))
    }

    fun updateEmployee(id: String, dto: EmployeeDTO): EmployeeDTO {
        val userOptional = repository.findById(ObjectId(id));
        if (userOptional.isEmpty) {
            throw IllegalArgumentException(String.format("Couldn't find employee with id: %s ", id))
        }
        return mapper.toEmployeeDTO(repository.save(userOptional.get()))
    }

    fun deleteEmployee(id: String) {
        val userOptional = repository.findById(ObjectId(id));
        if (userOptional.isEmpty) {
            throw IllegalArgumentException(String.format("Couldn't find employee with id: %s ", id))
        }
        repository.deleteById(ObjectId(id))
    }
}