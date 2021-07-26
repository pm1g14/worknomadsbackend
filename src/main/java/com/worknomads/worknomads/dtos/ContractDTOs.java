package com.worknomads.worknomads.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.List;

public final class ContractDTOs {

    @JsonProperty(namespace = "contractList") private final List<RetrievedContractDTO> contractList;

    public ContractDTOs(List<RetrievedContractDTO> contractList) {
        this.contractList = contractList;
    }

    public List<RetrievedContractDTO> getContractList() {
        return Collections.unmodifiableList(contractList);
    }
}
