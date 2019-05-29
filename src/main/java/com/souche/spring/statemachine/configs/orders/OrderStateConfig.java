package com.souche.spring.statemachine.configs.orders;

import com.souche.spring.statemachine.actions.AbstractAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.transition.Transition;

import java.util.EnumSet;

/**
 * 定义了状态节点跳转
 * 有限状态机四个要素：状态（state），事件（event），流转（transaction），action（动作）
 * 第一个config定义初始化当前状态机拥有哪些状态
 * 第二个config定义source，target，和对应触发的event事件
 * 执行 stateMachine.start()方法初始化配置，先加载所有的transactions再加载当前状态机的所有状态
 * 通过and链接多个触发事件
 */
@Configuration
@EnableStateMachine
public class OrderStateConfig extends EnumStateMachineConfigurerAdapter<OrderStateEnum,OrderEventEnum> {

    @Autowired
    private AbstractAction payDepositPartAction;

    @Autowired
    private AbstractAction signContractAction;

    @Override
    public void configure(StateMachineStateConfigurer<OrderStateEnum, OrderEventEnum> states) throws Exception {
        states
                .withStates()
                .initial(OrderStateEnum.WAITPAY).states(EnumSet.allOf(OrderStateEnum.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<OrderStateEnum, OrderEventEnum> transitions) throws Exception {
        transitions
                .withExternal()
                .source(OrderStateEnum.WAITPAY).target(OrderStateEnum.SIGN_CONTRACT).event(OrderEventEnum.SIGN_CONTRACT_EVENT).action(signContractAction)
                .and().withExternal()

                //签署合同完成之后支付定金
                .source(OrderStateEnum.SIGN_CONTRACT).target(OrderStateEnum.PAYING).event(OrderEventEnum.PAY_DEPOSIT_PART_EVENT).action(payDepositPartAction);
    }

    @Override
    public void configure(StateMachineConfigurationConfigurer<OrderStateEnum, OrderEventEnum> config) throws Exception {
        config
                .withConfiguration()
                .autoStartup(true)
                .listener(listener());

    }

    @Bean
    public StateMachineListener<OrderStateEnum,OrderEventEnum> listener(){
        return new StateMachineListenerAdapter<OrderStateEnum,OrderEventEnum>() {
            @Override
            public void transition(Transition<OrderStateEnum, OrderEventEnum> transition) {
                if(transition.getTarget().getId() == OrderStateEnum.SIGN_CONTRACT){
                    System.out.println("监听器监听到转移事件正在执行...");
                }
                return;
            }

            @Override
            public void transitionStarted(Transition<OrderStateEnum, OrderEventEnum> transition) {
                if(transition.getTarget().getId() == OrderStateEnum.SIGN_CONTRACT){
                    System.out.println("监听器监听到转移事件开始执行...");
                }
                return;
            }

            @Override
            public void transitionEnded(Transition<OrderStateEnum, OrderEventEnum> transition) {
                if(transition.getTarget().getId() == OrderStateEnum.SIGN_CONTRACT){
                    System.out.println("监听器监听到转移事件结束执行...");
                }
                return;
            }
        };
    }
}
