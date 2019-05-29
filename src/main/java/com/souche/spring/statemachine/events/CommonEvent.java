package com.souche.spring.statemachine.events;

import com.souche.spring.statemachine.configs.orders.OrderEventEnum;
import lombok.Data;

import java.util.UUID;

/**
 * @autor yeqiaozhu.
 * @date 2019-05-29
 */
@Data
public abstract class CommonEvent {
    final String eventId = UUID.randomUUID().toString();
    private String orderCode;
    private OrderEventEnum orderEventType;
}
