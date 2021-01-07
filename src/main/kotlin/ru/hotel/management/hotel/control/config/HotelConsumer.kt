package ru.hotel.management.hotel.control.config

import mu.KotlinLogging
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import ru.hotel.management.hotel.control.domain.dto.HotelPush
import ru.hotel.management.hotel.control.mapper.HotelMapper
import ru.hotel.management.hotel.control.repository.HotelRepository
import java.util.function.Consumer

private val logging = KotlinLogging.logger {  }

@Configuration
class HotelConsumer(
        val repository: HotelRepository,
        val mapper: HotelMapper
) {
    @Bean
    fun saveHotels(): Consumer<HotelPush>? {
        return Consumer<HotelPush> { input ->
            repository.save(mapper.toHotel(input))
        }
    }
}
