package com.souche.spring.statemachine;

import com.souche.spring.statemachine.configs.orders.OrderEventEnum;
import com.souche.spring.statemachine.events.IOrderEvent;
import com.souche.spring.statemachine.events.PayDepositPartEvent;
import com.souche.spring.statemachine.events.SignContractEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringStatemachineApplication implements CommandLineRunner {

	@Autowired
	private IOrderEvent iOrderEvent;

	public static void main(String[] args) {
		SpringApplication.run(SpringStatemachineApplication.class, args);
		//这里装载事件
	}

	@Override
	public void run(String... args) throws Exception {
		SignContractEvent signContractEvent=new SignContractEvent();
		signContractEvent.setOrderCode("89000001212");
		signContractEvent.setDepta("123456");
		signContractEvent.setOrderEventType(OrderEventEnum.SIGN_CONTRACT_EVENT);
		iOrderEvent.submitEvent(signContractEvent);

		PayDepositPartEvent payDepositPartEvent=new PayDepositPartEvent();
		payDepositPartEvent.setOrderCode("89000001212");
		payDepositPartEvent.setPaidMoney(1000L);
		payDepositPartEvent.setOrderEventType(OrderEventEnum.PAY_DEPOSIT_PART_EVENT);
		iOrderEvent.submitEvent(payDepositPartEvent);
	}


}
