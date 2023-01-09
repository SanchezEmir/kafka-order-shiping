package com.example.order.controller;

import com.example.order.entity.Order;
import com.example.order.kafkaConfigs.OrderService;
import com.example.order.util.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/create-order")
    public String saveAndProduceOrder(@RequestBody Order order) {
        orderService.produceOrder(order);
        return "Order created successfully";
    }

}
