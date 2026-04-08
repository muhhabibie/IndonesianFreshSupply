package com.IFS.inventory_service.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.support.converter.DefaultJackson2JavaTypeMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public MessageConverter jsonMessageConverter() {
        Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter();
        
        // Membuat "Penerjemah" untuk mengatasi perbedaan nama paket (Package)
        DefaultJackson2JavaTypeMapper typeMapper = new DefaultJackson2JavaTypeMapper();
        typeMapper.setTrustedPackages("*"); // Izinkan paket dari luar
        
        // Beritahu sistem: "Jika ada label dari OMS, tolong anggap itu model milik Inventory"
        Map<String, Class<?>> idClassMapping = new HashMap<>();
        idClassMapping.put("com.IFS.oms_service.model.Order", com.IFS.inventory_service.model.Order.class);
        typeMapper.setIdClassMapping(idClassMapping);
        
        converter.setJavaTypeMapper(typeMapper);
        return converter;
    }
}