package com.mostbet.triggerCampaign.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    @Bean
    public Queue triggerCampaignQueue(
            @Value(value = "${amqp.rabbit.queue.trigger_campaign.queue_name}") String queueName
    ) {
        return new Queue(queueName, false);
    }

    @Bean
    public TopicExchange exchange(
            @Value(value = "${amqp.rabbit.queue.trigger_campaign.exchange_name}") String exchangeName
    ) {
        return new TopicExchange(exchangeName);
    }

    @Bean
    public Binding binding(
            Queue queue,
            TopicExchange exchange,
            @Value(value = "${amqp.rabbit.queue.trigger_campaign.routing_key}") String routingKey
    ) {
        return BindingBuilder.bind(queue).to(exchange).with(routingKey);
    }

    @Bean
    public Jackson2JsonMessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }
}