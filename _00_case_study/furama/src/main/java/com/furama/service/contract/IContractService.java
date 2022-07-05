package com.furama.service.contract;

import com.furama.model.contract.Contract;
import com.furama.model.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.Set;

public interface IContractService {
    Page<Contract> findAll(Pageable pageble);

    Set<ContractDetail> contractDetailSet();

    void save(Contract contract);

    Optional<Contract> findById(Integer id);

    void update(Contract contract);

    void remove(Contract contract);
}
