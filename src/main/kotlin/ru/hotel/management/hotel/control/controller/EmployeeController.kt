package ru.hotel.management.hotel.control.controller

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import ru.hotel.management.hotel.control.domain.dto.EmployeeDTO
import ru.hotel.management.hotel.control.service.EmployeeService

@Controller
@RequestMapping("/api/employees")
class EmployeeController(
        val employeeService: EmployeeService
) {

    @GetMapping("/{id}")
    fun findEmployee(@PathVariable("id") id: String): ResponseEntity<EmployeeDTO> {
        return ResponseEntity.ok(employeeService.findEmployee(id))
    }

    @PostMapping
    fun createEmployee(@RequestBody dto: EmployeeDTO): ResponseEntity<EmployeeDTO> {
        return ResponseEntity.ok(employeeService.createEmployee(dto))
    }

    @PutMapping("/{id}")
    fun updateEmployee(@PathVariable("id") id: String,
                   @RequestBody dto: EmployeeDTO): ResponseEntity<EmployeeDTO> {
        return ResponseEntity.ok(employeeService.updateEmployee(id, dto))
    }

    @DeleteMapping("/{id}")
    fun deleteEmployee(@PathVariable("id") id: String): ResponseEntity<Void> {
        employeeService.deleteEmployee(id)
        return ResponseEntity.ok().build<Void>()
    }
}
