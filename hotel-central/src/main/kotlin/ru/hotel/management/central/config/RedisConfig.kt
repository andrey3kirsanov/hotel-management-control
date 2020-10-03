package ru.hotel.management.central.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import ru.hotel.management.central.domain.Hotel

@Configuration
class RedisConfig {
    @Bean
    fun redisTemplate(connectionFactory: RedisConnectionFactory?): RedisTemplate<Long, Hotel> {
        val template: RedisTemplate<Long, Hotel> = RedisTemplate<Long, Hotel>()
        template.setConnectionFactory(connectionFactory!!)
        return template
    }

    @Bean
    fun redisConnectionFactory(): JedisConnectionFactory? {
        val config = RedisStandaloneConfiguration("localhost", 6379)
        return JedisConnectionFactory(config)
    }
}