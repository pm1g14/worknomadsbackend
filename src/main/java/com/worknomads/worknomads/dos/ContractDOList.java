package com.worknomads.worknomads.dos;

import java.util.Collections;
import java.util.List;

public class ContractDOList {

    private final List<ContractDO> contractList;

    public ContractDOList(List<ContractDO> contractList) {
        this.contractList = contractList;
    }

    public List<ContractDO> getContractList() {
        return Collections.unmodifiableList(contractList);
    }
}
