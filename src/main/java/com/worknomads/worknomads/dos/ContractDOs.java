package com.worknomads.worknomads.dos;

import java.util.Collections;
import java.util.List;

public class ContractDOs {

    private final List<RetrievedContractDO> contractList;

    public ContractDOs(List<RetrievedContractDO> contractList) {
        this.contractList = contractList;
    }

    public List<RetrievedContractDO> getContractList() {
        return Collections.unmodifiableList(contractList);
    }
}
