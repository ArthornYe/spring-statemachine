package com.souche.spring.statemachine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@SpringBootApplication
public class SpringStatemachineApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringStatemachineApplication.class, args);
		//这里装载事件

		Future<String> feature=Executors.newFixedThreadPool(10).submit(()->{
			System.out.println("执行了");
			String test=null;
			test.charAt(1);
			return "helloworld";
		});
		try {
			feature.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		Future<Object> future=Executors.newFixedThreadPool(10).submit(new Callable<Object>() {
			@Override
			public Object call() throws Exception {
				String test=null;
				test.charAt(1);
				return null;
			}
		});
		try {
			future.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

	@Autowired
	private StateMachine<OrderStateEnum,OrderEventEnum> stateMachine;

	@Override
	public void run(String... args) throws Exception {
		stateMachine.start();
		stateMachine.sendEvent(OrderEventEnum.SIGN_CONTRACT_EVENT);
		stateMachine.sendEvent(OrderEventEnum.PAY_DEPOSIT_PART_EVENT);
	}


}
