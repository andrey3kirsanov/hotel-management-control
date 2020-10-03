package ru.hotel.management.booking.controller

import org.springframework.web.bind.annotation.*
import ru.hotel.management.central.domain.dto.BookedRoomDTO
import ru.hotel.management.central.kafka.BookingProducer

@RestController
@RequestMapping("/api/booking")
class BookingController(bookingProducer: BookingProducer) {

    private val bookingProducer: BookingProducer

    @PostMapping("/book-room")
    fun bookRoom(@RequestBody dto: BookedRoomDTO) {
        bookingProducer.sendMessage("BOOK_ROOM", dto.id.toString(), dto)
    }

    init {
        this.bookingProducer = bookingProducer
    }
}