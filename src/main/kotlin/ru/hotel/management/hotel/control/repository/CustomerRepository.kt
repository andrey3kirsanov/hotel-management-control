package ru.hotel.management.hotel.control.repository

import org.springframework.data.mongodb.repository.MongoRepository
import ru.hotel.management.hotel.control.domain.Customer

interface CustomerRepository : MongoRepository<Customer, Long>