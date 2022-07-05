package com.furama.controller.rest;

import com.furama.model.contract.AttachService;
import com.furama.model.contract.Contract;
import com.furama.model.contract.DTO.AttachServiceDTO;
import com.furama.service.contract.IAttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/attach-services")
public class AttachServiceRestController {
    @Autowired
    private IAttachServiceService attachServiceService;

    @GetMapping("/contract/{contractId}")
    public ResponseEntity<?> allAttachServicesByContract(@PathVariable Integer contractId) {
        List<AttachService> attachServiceList = attachServiceService.findAll();
        List<AttachServiceDTO> attachServiceDTOList = new ArrayList<>();
        for (AttachService attachService :attachServiceList) {
            AttachServiceDTO attachServiceDTO = new AttachServiceDTO();
            attachServiceDTO.setAttachServiceId(attachService.getAttachServiceId());
            attachServiceDTO.setAttachServiceName(attachService.getAttachServiceName());
            attachServiceDTO.setAttachServiceCost(attachService.getAttachServiceCost());
            attachServiceDTO.setAttachServiceStatus(attachService.getAttachServiceStatus());
            attachServiceDTO.setAttachServiceUnit(attachService.getAttachServiceUnit());
            attachServiceDTO.setContractId(contractId);
            attachServiceDTOList.add(attachServiceDTO);
        }
        if (attachServiceDTOList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(attachServiceDTOList, HttpStatus.OK);
    }
}
