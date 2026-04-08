package com.IFS.oms_service.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.queue.inventory}")
    private String inventoryQueue;

    @Value("${rabbitmq.queue.payment}")
    private String paymentQueue;

    // --- 1. KONFIGURASI DEAD LETTER (Jaring Pengaman) ---
    
    @Bean
    public FanoutExchange deadLetterExchange() {
        return new FanoutExchange("ifs.deadletter.exchange");
    }

    @Bean
    public Queue deadLetterQueue() {
        return new Queue("ifs.deadletter.queue", true);
    }

    @Bean
    public Binding deadLetterBinding() {
        return BindingBuilder.bind(deadLetterQueue()).to(deadLetterExchange());
    }

    // --- 2. ANTREAN UTAMA DENGAN FITUR DLQ ---

    @Bean
    public Queue inventoryQueue() {
        return QueueBuilder.durable(inventoryQueue)
                // Jika pesan gagal/rejected, kirim ke Exchange ini
                .withArgument("x-dead-letter-exchange", "ifs.deadletter.exchange") 
                .build();
    }

    @Bean
    public Queue paymentQueue() {
        return QueueBuilder.durable(paymentQueue)
                .withArgument("x-dead-letter-exchange", "ifs.deadletter.exchange")
                .build();
    }

    // --- 3. EXCHANGE UTAMA & BINDING ---

    @Bean
    public FanoutExchange ifsExchange() {
        return new FanoutExchange(exchange);
    }

    @Bean
    public Binding inventoryBinding() {
        return BindingBuilder.bind(inventoryQueue()).to(ifsExchange());
    }

    @Bean
    public Binding paymentBinding() {
        return BindingBuilder.bind(paymentQueue()).to(ifsExchange());
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}