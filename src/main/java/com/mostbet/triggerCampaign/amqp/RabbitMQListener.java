package com.mostbet.triggerCampaign.amqp;

import com.mostbet.triggerCampaign.operation.event.EventProcessService;
import com.mostbet.triggerCampaign.transport.core.dto.RequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@EnableRabbit
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RabbitMQListener {
    private final EventProcessService eventProcessServiceIml;

    @RabbitListener(
            queues = "${amqp.rabbit.queue.trigger_campaign.queue_name}",
            concurrency = "${amqp.rabbit.queue.trigger_campaign.cnt_consumers}"
    )
    public void processQueue(final RequestDto<? extends RequestDto.Payload> message) {
        eventProcessServiceIml.process(message);
    }
}
