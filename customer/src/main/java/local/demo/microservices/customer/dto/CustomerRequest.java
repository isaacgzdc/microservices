package local.demo.microservices.customer.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Value;

@Value
public class CustomerRequest{
	private String name;
	private LocalDateTime lastAccess;
	private Boolean active;
	private BigDecimal amount;
}
