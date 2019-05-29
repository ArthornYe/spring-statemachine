package com.souche.spring.statemachine;

import com.souche.spring.statemachine.configs.orders.OrderEventEnum;
import com.souche.spring.statemachine.configs.orders.OrderStateEnum;
import com.souche.spring.statemachine.configs.parents.ParentEventEnum;
import com.souche.spring.statemachine.configs.parents.ParentStateEnum;
import com.souche.spring.statemachine.events.SignContractEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;

@SpringBootApplication
public class SpringStatemachineApplication implements CommandLineRunner {

	@Autowired
	private StateMachine<OrderStateEnum, OrderEventEnum> stateMachine;

	@Autowired
	private StateMachine<ParentStateEnum, ParentEventEnum> parentStateMachine;

	public static void main(String[] args) {
		SpringApplication.run(SpringStatemachineApplication.class, args);
		//这里装载事件
	}

	@Override
	public void run(String... args) throws Exception {
		//parentStateMachine.start();

		stateMachine.start();

		Message<OrderEventEnum> eventMessage=MessageBuilder
				.withPayload(OrderEventEnum.SIGN_CONTRACT_EVENT)
				.setHeader("_header",new SignContractEvent()).build();

		stateMachine.sendEvent(eventMessage);
		stateMachine.sendEvent(OrderEventEnum.PAY_DEPOSIT_PART_EVENT);

/*		stateMachine.sendEvent(OrderEventEnum.SIGN_CONTRACT_EVENT);
		stateMachine.sendEvent(OrderEventEnum.PAY_DEPOSIT_PART_EVENT);*/
	}


}
