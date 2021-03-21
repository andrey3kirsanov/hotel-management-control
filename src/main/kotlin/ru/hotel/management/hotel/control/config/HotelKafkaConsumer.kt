package ru.hotel.management.hotel.control.config

import mu.KotlinLogging
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import ru.hotel.management.hotel.control.domain.message.CustomerPush
import ru.hotel.management.hotel.control.domain.message.HotelPush
import ru.hotel.management.hotel.control.mapper.CustomerMapper
import ru.hotel.management.hotel.control.mapper.HotelMapper
import ru.hotel.management.hotel.control.mapper.RoomMapper
import ru.hotel.management.hotel.control.repository.CustomerRepository
import ru.hotel.management.hotel.control.repository.HotelRepository
import ru.hotel.management.hotel.control.repository.RoomRepository
import java.util.function.Consumer

private val logging = KotlinLogging.logger {  }

@Configuration
class HotelConsumer(
        val hotelRepository: HotelRepository,
        val roomRepository: RoomRepository,
        val customerRepository: CustomerRepository,
        val hotelMapper: HotelMapper,
        val roomMapper: RoomMapper,
        val customerMapper: CustomerMapper
) {
    @Bean
    fun saveHotels(): Consumer<HotelPush>? {
        return Consumer<HotelPush> { input ->
            logging.info { "Received hotel information  - $input" }
            val hotelOptional = hotelRepository.findById(input.id)
            if (hotelOptional.isPresent) {
                hotelRepository.deleteById(input.id)
                hotelRepository.insert(hotelMapper.toHotel(input))
            } else {
                hotelRepository.insert(hotelMapper.toHotel(input))
            }

            roomRepository.saveAll(roomMapper.toRoomList(input.rooms))
        }
    }

    @Bean
    fun saveCustomers(): Consumer<CustomerPush>? {
        return Consumer<CustomerPush> { input ->
            logging.info { "Received customer information - $input" }
            val customerOptional = customerRepository.findById(input.id)
            if (customerOptional.isPresent) {
                customerRepository.deleteById(input.id)
                customerRepository.insert(customerMapper.toCustomer(input))
            } else {
                customerRepository.insert(customerMapper.toCustomer(input))
            }
        }
    }
}
