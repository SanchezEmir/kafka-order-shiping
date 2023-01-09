package com.sanchezemir.shipping.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sanchezemir.shipping.constants.Constants;
import com.sanchezemir.shipping.entity.Shipping;
import com.sanchezemir.shipping.util.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ShippingService {

    @KafkaListener(topics = Constants.ORDER_TOPIC)
    public void getorder(String order) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Shipping shipping = gson.fromJson(order, Shipping.class);
        log.info("Received Order: \n" + Utils.toJson(shipping));
    }

}
