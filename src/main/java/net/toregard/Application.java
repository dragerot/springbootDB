package net.toregard;


import net.toregard.model.CV;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.JacksonJsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

//@Configuration
//@EnableAutoConfiguration
//@EnableJpaRepositories
//@ComponentScan
//@EnableAutoConfiguration
@SpringBootApplication
public class Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args)  {
        SpringApplication.run(Application.class, args);
//        new SpringApplicationBuilder(Application.class)
//                .bannerMode(Banner.Mode.CONSOLE)
//                .run(args);
    }

    @Bean
    public StringRedisSerializer stringRedisSerializer() {
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        return stringRedisSerializer;
    }

    @Bean
    public JacksonJsonRedisSerializer<CV> jacksonJsonRedisJsonSerializer() {
        JacksonJsonRedisSerializer<CV> jacksonJsonRedisJsonSerializer = new JacksonJsonRedisSerializer<>(CV.class);
        return jacksonJsonRedisJsonSerializer;
    }

    @Bean
    public RedisTemplate<String, CV> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        final RedisTemplate<String,CV> redisTemplate = new RedisTemplate<String, CV>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(stringRedisSerializer());
        redisTemplate.setValueSerializer(jacksonJsonRedisJsonSerializer());
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }


}
