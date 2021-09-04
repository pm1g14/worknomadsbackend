package com.worknomads.worknomads.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ContractDTOs {

    private final List<RetrievedContractDTO> contracts;

    @JsonCreator
    public ContractDTOs(@JsonProperty("contracts") List<RetrievedContractDTO> contractList) {
        this.contracts = contractList;
    }

    public List<RetrievedContractDTO> getContracts() {
        return Collections.unmodifiableList(contracts);
    }
}
