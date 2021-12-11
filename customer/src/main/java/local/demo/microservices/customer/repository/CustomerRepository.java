package local.demo.microservices.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import local.demo.microservices.customer.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
}
