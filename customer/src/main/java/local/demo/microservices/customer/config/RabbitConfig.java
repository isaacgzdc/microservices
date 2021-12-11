package local.demo.microservices.customer.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
@Configuration
@ConfigurationProperties(prefix = "rabbitmq")
public class RabbitConfig {

	private String queueName;
	private String exchangeName;
	private String routingKeyName;
	
	
	public String getQueueName() {
		return queueName;
	}
	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}
	public String getExchangeName() {
		return exchangeName;
	}
	public void setExchangeName(String exchangeName) {
		this.exchangeName = exchangeName;
	}
	public String getRoutingKeyName() {
		return routingKeyName;
	}
	public void setRoutingKeyName(String routingKeyName) {
		this.routingKeyName = routingKeyName;
	}
	
}
