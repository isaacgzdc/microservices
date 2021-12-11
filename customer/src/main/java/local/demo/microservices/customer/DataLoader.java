package local.demo.microservices.customer;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import local.demo.microservices.customer.model.Customer;
import local.demo.microservices.customer.model.CustomerType;
import local.demo.microservices.customer.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DataLoader implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		log.debug("LOAD INITIAL DATA HERE !!!");

		Customer customer = Customer.builder()
				.name("Fedora")
				.uuid(UUID.randomUUID())
				.lastUpdated(LocalDateTime.of(1980, 2, 13, 14, 20, 47))
				.active(Boolean.TRUE)
				.amount(BigDecimal.TEN)
				.type(CustomerType.DEVELOPER)
				.build();
		
		Customer db = repository.save(customer);
		log.debug(db.toString());
		
		customer = Customer.builder()
				.name("Catalina")
				.uuid(UUID.randomUUID())
				.lastUpdated(LocalDateTime.of(1995, 10, 2, 21, 45, 14))
				.active(Boolean.TRUE)
				.amount(BigDecimal.TEN)
				.type(CustomerType.ARCHITECT)
				.build();
		
		db = repository.save(customer);
		log.debug(db.toString());
		
		customer = Customer.builder()
				.name("Kubernetes")
				.uuid(UUID.randomUUID())
				.lastUpdated(LocalDateTime.of(2001, 7, 20, 6, 15, 22))
				.active(Boolean.FALSE)
				.amount(BigDecimal.ONE)
				.type(CustomerType.DEVELOPER)
				.build();
		
		db = repository.save(customer);
		log.debug(db.toString());
		
	}

}
