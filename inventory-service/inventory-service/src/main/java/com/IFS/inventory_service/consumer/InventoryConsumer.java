package com.IFS.inventory_service.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.IFS.inventory_service.model.Order;

@Service
public class InventoryConsumer {

    @RabbitListener(queues = "${rabbitmq.queue.inventory}")
    public void receiveOrder(Order order) {
        System.out.println("=====================================");
        System.out.println("INVENTORY SERVICE: Mencoba memproses pesanan...");
        System.out.println("ID Pesanan : " + order.getOrderId());
        
        // SIMULASI ERROR: Kita paksa aplikasi ini gagal
        System.err.println("CRITICAL ERROR: Koneksi Database Terputus!");
        throw new RuntimeException("Gagal konek database stok!");
    }
}