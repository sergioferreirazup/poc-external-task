package br.com.sample.demo.tasks;

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@ExternalTaskSubscription("startTask")
class StartTask implements ExternalTaskHandler {

    private final Logger logger = LoggerFactory.getLogger("StartTask");
    private static final String STATE = "START";

    @Override
    public void execute(ExternalTask task, ExternalTaskService service) {
        logger.info("Running {}", task.getExecutionId());
        VariableMap variables = Variables.createVariables();

        String customerId = "C-".concat(UUID.randomUUID().toString());
        variables.put("customerId", customerId);
        variables.put("score", (int)(Math.random() * 11));
        logger.info("Customer {} with state {}", customerId, STATE);

        service.complete(task, variables);
        logger.info("Finish task {}", task.getExecutionId());
    }
}
