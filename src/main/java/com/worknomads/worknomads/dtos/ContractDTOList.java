package com.worknomads.worknomads.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.List;

public final class ContractDTOList {

    @JsonProperty(namespace = "contractList") private final List<ContractDTO> contractList;

    public ContractDTOList(List<ContractDTO> contractList) {
        this.contractList = contractList;
    }

    public List<ContractDTO> getContractList() {
        return Collections.unmodifiableList(contractList);
    }
}
