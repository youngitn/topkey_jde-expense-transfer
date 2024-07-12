package com.topkey.jdeexpensetransfer.config;

import java.util.UUID;

import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.topkey.jdeexpensetransfer.converter.GsonExpenseListMessageConverter;

@Configuration
public class RabbitMQConfig {

	@Bean
	public MessageConverter gsonExpenseListMessageConverter() {
		return new GsonExpenseListMessageConverter();
	}

	@Bean
	public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
		SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory);
		factory.setMessageConverter(gsonExpenseListMessageConverter());
		factory.setConsumerTagStrategy(queue -> "travel-expenses-consumer-" + UUID.randomUUID().toString());
		return factory;
	}

	/**
	 * 這邊只示範可以多個ContainerFactory
	 * 可以在consumer method或class指定要用哪個ContainerFactory
	 */
	@Bean
	public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory2(ConnectionFactory connectionFactory) {
		SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory);
		factory.setMessageConverter(gsonExpenseListMessageConverter());
		factory.setConsumerTagStrategy(queue -> "travel-expenses-consumer-" + UUID.randomUUID().toString());
		return factory;
	}

}
