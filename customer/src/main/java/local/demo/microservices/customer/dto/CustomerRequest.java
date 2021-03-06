package local.demo.microservices.customer.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import local.demo.microservices.customer.model.CustomerType;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
public class CustomerRequest{
	private String name;
	private String mail;
	private LocalDateTime lastUpdated;
	private BigDecimal amount;
	private CustomerType type;
}
