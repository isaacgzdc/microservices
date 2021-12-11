package local.demo.microservices.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import local.demo.microservices.customer.dto.CustomerRequest;
import local.demo.microservices.customer.dto.CustomerResponse;
import local.demo.microservices.customer.model.Customer;
import local.demo.microservices.customer.service.CustomerService;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

	private final CustomerService service;

	@Autowired
	public CustomerController(CustomerService service) {
		this.service = service;
	}

	@GetMapping
	public List<Customer> getAll() {
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Customer get(@PathVariable Long id) {
		return service.findById(id).orElseGet(() -> new Customer());
	}
	
	@PostMapping("/add")
	public CustomerResponse add(@RequestBody CustomerRequest customer) {
		Customer response = service.save(customer);
		return service.transform(response);
	}

	@PutMapping("/update/{id}")
	public CustomerResponse upate(@RequestBody CustomerRequest request, @PathVariable Long id) {

		return service.findById(id).map(customer -> {
			return service.transform(customer);
		}).orElseGet(()->{
			return new CustomerResponse(null, null, null, null, null, null, null);
		});
		
	}

	@DeleteMapping("/customer/delete/{id}")
	void delete(@PathVariable Long id) {
		service.deleteById(id);
	}

}
