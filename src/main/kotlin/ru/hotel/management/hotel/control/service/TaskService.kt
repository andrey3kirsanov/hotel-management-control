package ru.hotel.management.hotel.control.service

import org.bson.types.ObjectId
import org.springframework.stereotype.Service
import ru.hotel.management.hotel.control.domain.dto.TaskDTO
import ru.hotel.management.hotel.control.mapper.TaskMapper
import ru.hotel.management.hotel.control.repository.TaskRepository
import java.lang.IllegalArgumentException

@Service
class TaskService(
        val repository: TaskRepository,
        val mapper: TaskMapper
) {
    fun findTask(id: String): TaskDTO {
        val taskOptional = repository.findById(ObjectId(id));
        if (taskOptional.isEmpty) {
            throw IllegalArgumentException(String.format("Couldn't find task with id: %s ", id))
        }
        return mapper.toTaskDTO(taskOptional.get())
    }

    fun createTask(dto: TaskDTO): TaskDTO {
        return mapper.toTaskDTO(repository.save(mapper.toTask(dto)))
    }

    fun updateTask(id: String, dto: TaskDTO): TaskDTO {
        val taskOptional = repository.findById(ObjectId(id));
        if (taskOptional.isEmpty) {
            throw IllegalArgumentException(String.format("Couldn't find task with id: %s ", id))
        }
        return mapper.toTaskDTO(repository.save(taskOptional.get()))
    }

    fun deleteTask(id: String) {
        val taskOptional = repository.findById(ObjectId(id));
        if (taskOptional.isEmpty) {
            throw IllegalArgumentException(String.format("Couldn't find task with id: %s ", id))
        }
        repository.deleteById(ObjectId(id))
    }
}