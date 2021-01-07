package ru.hotel.management.hotel.control.controller

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import ru.hotel.management.hotel.control.domain.Employee
import ru.hotel.management.hotel.control.domain.dto.EmployeeDTO
import ru.hotel.management.hotel.control.service.EmployeeService

@Controller
@RequestMapping("/api/employee")
class EmployeeController(
        val employeeService: EmployeeService
) {

    @PostMapping
    fun createUser(@RequestBody dto: EmployeeDTO): ResponseEntity<Employee> {
        return ResponseEntity.ok(employeeService.createUser(dto))
    }
}
