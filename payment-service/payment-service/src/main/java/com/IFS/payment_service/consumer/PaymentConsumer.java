package com.IFS.payment_service.consumer;

import com.IFS.payment_service.model.Order;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentConsumer {

    // Anotasi ini yang membuat Payment terus "mendengarkan" pesan yang masuk
    @RabbitListener(queues = "${rabbitmq.queue.payment}")
    public void receiveOrder(Order order) {
        System.out.println("=====================================");
        System.out.println("PAYMENT SERVICE Menerima Tagihan!");
        System.out.println("ID Pesanan : " + order.getOrderId());
        System.out.println("Memproses pembuatan Virtual Account...");
        System.out.println("=====================================");
    }
}