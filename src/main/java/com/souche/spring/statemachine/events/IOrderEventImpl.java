package com.souche.spring.statemachine.events;

import com.souche.spring.statemachine.configs.orders.OrderEventEnum;
import com.souche.spring.statemachine.configs.orders.OrderStateEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Service;

/**
 * @autor yeqiaozhu.
 * @date 2019-05-30
 */
@Service
public class IOrderEventImpl implements IOrderEvent {

    @Autowired
    private StateMachine<OrderStateEnum, OrderEventEnum> stateMachine;

   /* @Autowired
	private StateMachine<ParentStateEnum, ParentEventEnum> parentStateMachine;
*/
    @Override
    public void submitEvent(CommonEvent event) {

        stateMachine.start();

        Message<OrderEventEnum> eventMessage= MessageBuilder
                .withPayload(event.getOrderEventType())
                .setHeader("_header",event).build();

        stateMachine.sendEvent(eventMessage);
    }
}
