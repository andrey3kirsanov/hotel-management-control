package ru.hotel.management.central.controller

import org.springframework.data.redis.core.RedisTemplate
import org.springframework.web.bind.annotation.*
import ru.hotel.management.central.domain.Hotel
import ru.hotel.management.central.domain.dto.HotelDTO

@RestController
@RequestMapping("/api/hotel")
class HotelController(redisTemplate: RedisTemplate<Long, Hotel>) {

    private val redisTemplate: RedisTemplate<Long, Hotel>

    @PostMapping
    fun createHotel(@RequestBody dto: HotelDTO) {
        val hotel = dto.convertToModel(dto)
        redisTemplate.opsForValue().set(hotel.id, hotel)
    }

    @GetMapping("/{id}")
    fun getHotel(@PathVariable("id") id: Long) : Hotel? {
        return redisTemplate.opsForValue().get(id)
    }

    @DeleteMapping("/{id}")
    fun deleteHotel(@PathVariable("id") id: Long) {
        redisTemplate.delete(id)
    }

    init {
        this.redisTemplate = redisTemplate
    }
}