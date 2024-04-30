package br.com.sample.demo.tasks;

import br.com.sample.demo.data.BitcoinRate;
import br.com.sample.demo.integration.Integration;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ExternalTaskSubscription("integrationTask")
class IntegrationTask implements ExternalTaskHandler {

    private final Integration integration;
    private final Logger logger = LoggerFactory.getLogger("IntegrationTask");

    IntegrationTask(Integration integration) {
        this.integration = integration;
    }

    @Override
    public void execute(ExternalTask task, ExternalTaskService service) {
        logger.info("Running {}", task.getExecutionId());
//        BitcoinRate bitcoinRate = this.integration.getBitcoinRate();
        String customerId = task.getVariable("customerId");
//        logger.info("BitcoinRate: {} to Customer: {}", bitcoinRate.getData().getRateUsd(), customerId);
        service.complete(task);
        logger.info("Finish task {}", task.getExecutionId());
    }
}
