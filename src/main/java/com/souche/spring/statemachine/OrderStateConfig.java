package com.souche.spring.statemachine;

import com.souche.spring.statemachine.actions.AbstractAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;

/**
 * 定义了状态节点跳转
 * 第一个config定义初始化当前状态机拥有哪些状态
 * 第二个config定义source，target，和对应触发的event事件
 * 执行 stateMachine.start()方法初始化配置，先加载所有的transactions再加载当前状态机的所有状态
 * 通过and链接多个触发事件
 */
@Configuration
@EnableStateMachine
public class OrderStateConfig extends EnumStateMachineConfigurerAdapter<OrderStateEnum,OrderEventEnum> {

    @Autowired
    private AbstractAction testSignContractAction;

    @Autowired
    private AbstractAction signContractAction;

    @Override
    public void configure(StateMachineStateConfigurer<OrderStateEnum, OrderEventEnum> states) throws Exception {
        states.withStates().initial(OrderStateEnum.WAITPAY).states(EnumSet.allOf(OrderStateEnum.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<OrderStateEnum, OrderEventEnum> transitions) throws Exception {
        transitions.withExternal()
                .source(OrderStateEnum.WAITPAY).target(OrderStateEnum.SIGN_CONTRACT).event(OrderEventEnum.SIGN_CONTRACT_EVENT).action(testSignContractAction).action(signContractAction)
                .and().withExternal().source(OrderStateEnum.SIGN_CONTRACT).target(OrderStateEnum.PAYING).event(OrderEventEnum.PAY_DEPOSIT_PART_EVENT);
    }
}
