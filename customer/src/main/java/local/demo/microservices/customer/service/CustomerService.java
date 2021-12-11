package local.demo.microservices.customer.service;

import java.util.List;
import java.util.Optional;

import local.demo.microservices.customer.dto.CustomerRequest;
import local.demo.microservices.customer.dto.CustomerResponse;
import local.demo.microservices.customer.model.Customer;

public interface CustomerService {
	Customer save(CustomerRequest customer);
	Optional<Customer> findById(Long id);
	List<Customer> findAll();
	CustomerResponse transform(Customer response);
	void deleteById(Long id);
}
