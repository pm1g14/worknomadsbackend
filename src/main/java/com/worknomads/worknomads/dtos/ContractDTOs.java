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

    private final List<RetrievedContractDTO> contractList;

    @JsonCreator
    public ContractDTOs(@JsonProperty("contractList") List<RetrievedContractDTO> contractList) {
        this.contractList = contractList;
    }

    public List<RetrievedContractDTO> getContractList() {
        return Collections.unmodifiableList(contractList);
    }
}
