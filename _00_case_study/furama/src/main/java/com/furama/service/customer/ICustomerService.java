package com.furama.service.customer;

import com.furama.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageble);

    void save(Customer customer);

    Optional<Customer> findById(Integer id);

    void update(Customer customer);

    void remove(Customer customer);

    Page<Customer> searchByName(String customerName, Pageable pageble);
}
