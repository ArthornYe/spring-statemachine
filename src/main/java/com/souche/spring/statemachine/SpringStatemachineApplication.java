package com.souche.spring.statemachine;

import com.souche.spring.statemachine.StateConfigs.OrderStateConfigs.OrderEventEnum;
import com.souche.spring.statemachine.StateConfigs.OrderStateConfigs.OrderStateEnum;
import com.souche.spring.statemachine.StateConfigs.ParentStateConfigs.ParentEventEnum;
import com.souche.spring.statemachine.StateConfigs.ParentStateConfigs.ParentStateEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
		//
		parentStateMachine.start();

		stateMachine.start();
		stateMachine.sendEvent(OrderEventEnum.SIGN_CONTRACT_EVENT);
		stateMachine.sendEvent(OrderEventEnum.PAY_DEPOSIT_PART_EVENT);

		stateMachine.sendEvent(OrderEventEnum.SIGN_CONTRACT_EVENT);
		stateMachine.sendEvent(OrderEventEnum.PAY_DEPOSIT_PART_EVENT);
	}


}
