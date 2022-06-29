package com.phone.repository;

import com.phone.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IPhoneRepository extends JpaRepository<Phone, Integer> {
}
