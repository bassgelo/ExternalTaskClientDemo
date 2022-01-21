package com.camunda.example.externaltaskclient;

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.springframework.stereotype.Component;

@Component
@ExternalTaskSubscription("ExternalTaskTest")
public class ExternalTaskTestHandler implements ExternalTaskHandler {

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService){

        System.out.println("Hello World from a Spring Boot external task client");

        VariableMap variables = Variables.createVariables();
        variables.put("message", "Hello World");

        externalTaskService.complete(externalTask, variables);
    }
}
