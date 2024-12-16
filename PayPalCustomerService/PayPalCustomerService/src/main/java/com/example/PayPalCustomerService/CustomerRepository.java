package com.example.PayPalCustomerService;


import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // No additional methods required for basic CRUD operations
}
