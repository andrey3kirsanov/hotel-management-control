package ru.hotel.management.hotel.control.controller

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import ru.hotel.management.hotel.control.domain.dto.TaskDTO
import ru.hotel.management.hotel.control.service.TaskService

@Controller
@RequestMapping("/api/tasks")
class TaskController(
        val taskService: TaskService
) {

    @GetMapping("/{id}")
    fun findTask(@PathVariable("id") id: String): ResponseEntity<TaskDTO> {
        return ResponseEntity.ok(taskService.findTask(id))
    }

    @PostMapping
    fun createTask(@RequestBody dto: TaskDTO): ResponseEntity<TaskDTO> {
        return ResponseEntity.ok(taskService.createTask(dto))
    }

    @PutMapping("/{id}")
    fun updateTask(@PathVariable("id") id: String,
                   @RequestBody dto: TaskDTO): ResponseEntity<TaskDTO> {
        return ResponseEntity.ok(taskService.updateTask(id, dto))
    }

    @DeleteMapping("/{id}")
    fun deleteTask(@PathVariable("id") id: String): ResponseEntity<Void> {
        taskService.deleteTask(id)
        return ResponseEntity.ok().build<Void>()
    }
}
