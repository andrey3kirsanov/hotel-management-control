package ru.hotel.management.hotel.control.repository

import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import ru.hotel.management.hotel.control.domain.Employee

interface EmployeeRepository : MongoRepository<Employee, ObjectId>