package ru.hotel.management.central.kafka

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.stereotype.Service
import org.springframework.util.concurrent.ListenableFuture
import ru.hotel.management.central.domain.dto.BookedRoomDTO

@Service
class BookingProducer(private val kafkaTemplate: KafkaTemplate<String, BookedRoomDTO>) {
    fun sendMessage(topic: String, key: String, dto: BookedRoomDTO): ListenableFuture<SendResult<String, BookedRoomDTO>> {
        return kafkaTemplate.send(topic, key, dto)
    }
}