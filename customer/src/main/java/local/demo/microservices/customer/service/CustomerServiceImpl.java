package local.demo.microservices.customer.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import local.demo.microservices.customer.config.RabbitConfig;
import local.demo.microservices.customer.dto.CustomerRequest;
import local.demo.microservices.customer.dto.CustomerResponse;
import local.demo.microservices.customer.model.Customer;
import local.demo.microservices.customer.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

	private final CustomerRepository repository;
	private final AmqpTemplate rabbitTemplate;
	
	@Autowired
	private RabbitConfig rabbitConfig;
	
	@Autowired
	public CustomerServiceImpl(CustomerRepository repository, AmqpTemplate rabbitTemplate, RabbitConfig rabbitConfig) {
		this.repository = repository;
		this.rabbitTemplate = rabbitTemplate;
		this.rabbitConfig = rabbitConfig;
	}

	@Transactional
	public Customer save(CustomerRequest request) {
		log.debug("Save customer: {}", request.getName());
		Customer customer = Customer.builder()
				.uuid(UUID.randomUUID())
				.active(Boolean.TRUE)
				.name(request.getName())
				.mail(request.getMail())
				.build();
		log.debug("Save customer UUI: {}", customer.getUuid());
		Customer newCustomer = repository.save(customer);
		
		rabbitTemplate.convertAndSend(rabbitConfig.getExchangeName(), rabbitConfig.getRoutingKeyName(), newCustomer);
		
		return newCustomer;
	}

	public Optional<Customer> findById(Long id) {
		if(id == null) {
			return Optional.empty();
		}
		log.debug("Find by id : {}", id);
		return repository.findById(id);
	}

	public List<Customer> findAll() {
		log.debug("Find all customers");
		return repository.findAll();
	}

	public CustomerResponse transform(Customer customer) {
		CustomerResponse response = new CustomerResponse(
				customer.getUuid(), 
				customer.getName(),
				customer.getMail(),
				customer.getLastUpdated(),
				customer.getActive(),
				customer.getAmount(),
				customer.getType());
		log.debug("Build response with uuid ({}) from customer with id ({})", response.getUuid().toString(), customer.getId());
		return response;
	}

	@Override
	public void deleteById(Long id) {
		repository.findById(id).ifPresent(c -> repository.delete(c));
		
	}
}
