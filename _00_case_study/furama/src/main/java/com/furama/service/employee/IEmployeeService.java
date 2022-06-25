package com.furama.service.employee;

import com.furama.model.customer.Customer;
import com.furama.model.employee.EducationDegree;
import com.furama.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IEmployeeService {
    Page<Employee> findAll(Pageable pageble);

    void save(Employee employee);

    Optional<Employee> findById(Integer id);

    void update(Employee employee);

    void remove(Employee employee);

    Page<Employee> searchByName(String employeeName, Pageable pageble);
}
