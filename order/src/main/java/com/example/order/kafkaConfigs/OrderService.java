package com.example.order.kafkaConfigs;

import com.example.order.constants.Constants;
import com.example.order.entity.Order;
import com.example.order.repository.OrderRepository;
import com.example.order.util.Utils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final OrderRepository orderRepository;

    public void produceOrder(Order order) {
        orderRepository.save(order);
        /*ObjectMapper objectMapper = new ObjectMapper();
        String orderJsonString = null;
        try {
            orderJsonString = objectMapper.writeValueAsString(order);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }*/

        kafkaTemplate.send(Constants.ORDER_TOPIC, Utils.toJson(order));
        log.info("Send topic: "+ Constants.ORDER_TOPIC+" Order: \n" + Utils.toJson(order));
    }

}
