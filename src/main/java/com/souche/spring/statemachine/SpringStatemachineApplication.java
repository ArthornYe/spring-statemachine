package com.souche.spring.statemachine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;

@SpringBootApplication
public class SpringStatemachineApplication implements CommandLineRunner {

	@Autowired
	private StateMachine<OrderStateEnum,OrderEventEnum> stateMachine;

	public static void main(String[] args) {
		SpringApplication.run(SpringStatemachineApplication.class, args);
		//这里装载事件
	}

	@Override
	public void run(String... args) throws Exception {
		stateMachine.start();
		stateMachine.sendEvent(OrderEventEnum.SIGN_CONTRACT_EVENT);
		stateMachine.sendEvent(OrderEventEnum.PAY_DEPOSIT_PART_EVENT);
	}


}
