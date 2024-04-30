package br.com.sample.demo.tasks;

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@ExternalTaskSubscription("badTask")
class BadTask implements ExternalTaskHandler {

    private final Logger logger = LoggerFactory.getLogger("BadTask");
    private static final String STATE = "BAD";

    @Override
    public void execute(ExternalTask task, ExternalTaskService service) {
        logger.info("Running {}", task.getExecutionId());
        String customerId = task.getVariable("customerId");
        int score = task.getVariable("score");
        logger.info("Retrieved customer {} with state {} and score {}", customerId, STATE, score);
        service.complete(task);
        logger.info("Finish task {}", task.getExecutionId());
    }
}
