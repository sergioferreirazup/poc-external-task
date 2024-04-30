package br.com.sample.demo.tasks;

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@ExternalTaskSubscription("endGameTask")
class EndGameTask implements ExternalTaskHandler {

    private final Logger logger = LoggerFactory.getLogger("EndGameTask");
    private static final String STATE = "END";

    @Override
    public void execute(ExternalTask task, ExternalTaskService service) {
        logger.info("Running {}", task.getExecutionId());
        String customerId = task.getVariable("customerId");
        logger.info("Retrieved customer {} with state {}", customerId, STATE);
        service.complete(task);
        logger.info("Finish task {}", task.getExecutionId());
    }
}
