package local.demo.microservices.customer.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import local.demo.microservices.customer.model.CustomerType;
import lombok.Value;

@Value
public class CustomerResponse{
	private UUID uuid;
	private String name;
	private String mail;
	private LocalDateTime lastUpdated;
	private Boolean active;
	private BigDecimal amount;
	private CustomerType type;
}
