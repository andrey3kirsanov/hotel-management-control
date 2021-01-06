package ru.hotel.management.hotel.control

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication
@EnableMongoRepositories
class HotelManagementControlApplication
fun main(args: Array<String>) {
    runApplication<HotelManagementControlApplication>(*args)
}
