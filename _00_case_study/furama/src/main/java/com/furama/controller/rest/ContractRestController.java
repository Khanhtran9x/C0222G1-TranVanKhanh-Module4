package com.furama.controller.rest;

import com.furama.model.contract.Contract;
import com.furama.model.contract.ContractDetail;
import com.furama.model.service.Service;
import com.furama.repository.contract.IContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/contracts")
public class ContractRestController {
    @Autowired
    private IContractRepository contractRepository;

    @GetMapping
    public ResponseEntity<?> allContracts(@RequestParam(name = "page", defaultValue = "0") int page) {
        Sort sort = Sort.by("contractId").ascending();
        Page<Contract> contractList = contractRepository.findAll(PageRequest.of(page, 5, sort));
        if (contractList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contractList, HttpStatus.OK);
    }

    @GetMapping("/{id}/contract-details")
    public ResponseEntity<?> allContractDetailById(@PathVariable Integer id) {
        Set<ContractDetail> contractDetails = contractRepository.findById(id).get().getContractDetails();
        if (contractDetails.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contractDetails, HttpStatus.OK);
    }
}
