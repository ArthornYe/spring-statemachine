package com.souche.spring.statemachine.configs.parents;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.guard.Guard;

/**
 * @autor yeqiaozhu.
 * @date 2019-05-23
 */
@Configuration
@EnableStateMachine(name="parentStateMachine")
public class ParentStateConfig extends EnumStateMachineConfigurerAdapter<ParentStateEnum,ParentEventEnum> {

    @Override
    public void configure(StateMachineStateConfigurer<ParentStateEnum, ParentEventEnum> states) throws Exception {
        states.withStates()
                .initial(ParentStateEnum.S1)
                .state(ParentStateEnum.S2)
                .and()
                .withStates()
                    .parent(ParentStateEnum.S2)
                    .initial(ParentStateEnum.S2I)
                    .state(ParentStateEnum.S21)
                    .end(ParentStateEnum.S2F)
                    .and()
                .withStates()
                    .parent(ParentStateEnum.S2)
                    .initial(ParentStateEnum.S3I)
                    .state(ParentStateEnum.S31)
                    .end(ParentStateEnum.S3F);
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<ParentStateEnum, ParentEventEnum> transitions) throws Exception {
        transitions
                .withExternal()
                .source(ParentStateEnum.S1)
                .target(ParentStateEnum.S2)
                .event(ParentEventEnum.E1)
                .guard(guard())
                .action(null)


                .and()
                .withExternal()
                .source(ParentStateEnum.S2)
                .target(ParentStateEnum.S2F)
                .event(ParentEventEnum.E2)
                .action(null);
    }
    @Bean
    public Guard<ParentStateEnum, ParentEventEnum> guard() {
        return new Guard<ParentStateEnum, ParentEventEnum>() {

            @Override
            public boolean evaluate(StateContext<ParentStateEnum, ParentEventEnum> context) {
                return true;
            }
        };
    }


}
