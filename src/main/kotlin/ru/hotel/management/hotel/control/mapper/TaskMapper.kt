package ru.hotel.management.hotel.control.mapper

import org.bson.types.ObjectId
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import ru.hotel.management.hotel.control.domain.Task
import ru.hotel.management.hotel.control.domain.dto.TaskDTO

@Mapper(componentModel = "spring", imports = arrayOf(ObjectId::class))
interface TaskMapper {
    @Mapping(target = "id", expression = "java(ObjectId.get())")
    fun toTask(dto: TaskDTO): Task

    @Mapping(target = "id", expression = "java(task.getId().toString())")
    fun toTaskDTO(task: Task): TaskDTO
}