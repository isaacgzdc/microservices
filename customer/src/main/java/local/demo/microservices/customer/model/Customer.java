package local.demo.microservices.customer.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "customer_mail_unique",columnNames = { "mail" }) )
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	@Id
	@GeneratedValue(generator = "CUSTOMER_SEQ", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="CUSTOMER_SEQ",sequenceName="CUSTOMER_SEQ", allocationSize=1)
	private Long id;
	
	private UUID uuid;
	private String name;
	private String mail;
	private Boolean active;
	private BigDecimal amount;
	private CustomerType type;
	private LocalDateTime lastUpdated;
}
