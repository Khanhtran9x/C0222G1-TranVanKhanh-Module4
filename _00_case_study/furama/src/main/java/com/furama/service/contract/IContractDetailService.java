package com.furama.service.contract;

import com.furama.model.contract.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    List<ContractDetail> findAll();
    void save(ContractDetail contractDetail);
}
