package com.worknomads.worknomads.services.contracts.impl;

import com.worknomads.worknomads.adapters.InputAdapter;
import com.worknomads.worknomads.dao.StoreContractDAO;
import com.worknomads.worknomads.dos.ContractDO;
import com.worknomads.worknomads.dtos.ContractDTO;
import com.worknomads.worknomads.services.contracts.CreateContractService;
import ethereum.EthNetworkAPI;
import ethereum.impl.EthNetworkAPIImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class CreateContractServiceImpl implements CreateContractService {

    private EthNetworkAPI ethNetworkService = new EthNetworkAPIImpl();

    @Autowired
    private StoreContractDAO dao;


    @Autowired
    private InputAdapter<ContractDTO, ContractDO> adapter;


    @Override
    public boolean createContract(ContractDTO contract, String cid) throws ExecutionException, InterruptedException {
        var contractDO = adapter.mapDTOtoDO(contract);
        return ethNetworkService.createAndPublishContract(contractDO, cid)
                .thenApply(receipt -> dao.storeContractDetails(contractDO, receipt.toString())).get();

    }
}
