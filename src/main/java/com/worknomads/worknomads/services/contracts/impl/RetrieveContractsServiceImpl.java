package com.worknomads.worknomads.services.contracts.impl;

import com.worknomads.worknomads.adapters.io.impl.RetrieveContractsIOAdapter;
import com.worknomads.worknomads.dao.RetrieveContractsDAO;
import com.worknomads.worknomads.dos.ContractDOs;
import com.worknomads.worknomads.dos.RetrievedContractDO;
import com.worknomads.worknomads.dtos.ContractDTOs;
import com.worknomads.worknomads.dtos.RetrievedContractDTO;
import com.worknomads.worknomads.services.contracts.RetrieveContractsService;
import ethereum.EthNetworkAPI;
import ethereum.impl.EthNetworkAPIImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class RetrieveContractsServiceImpl implements RetrieveContractsService {

    @Autowired
    private RetrieveContractsDAO dao;

    @Autowired
    private RetrieveContractsIOAdapter ioAdapter;

    private EthNetworkAPI ethNetworkService = new EthNetworkAPIImpl();


    @Override
    public ContractDTOs retrieveContracts(String walletAddress) {
        List<String> addresses = dao.retrieveContractAddressesForWallet(walletAddress);
        List<CompletableFuture<RetrievedContractDO>> contractFutures = new ArrayList<>();
        for (String address: addresses) {
            if (address != null) {
                contractFutures.add(ethNetworkService.getContractDetailsFromAddress(address));
            }
        }
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(
                contractFutures.toArray(new CompletableFuture[contractFutures.size()])
        );
        List<RetrievedContractDO> contracts = allFutures.thenApply((
                v -> contractFutures.stream().map(CompletableFuture::join).collect(Collectors.toList())
        )).join();

        Optional<ContractDTOs> contractDTOsOpt = ioAdapter.mapDOtoDTO(new ContractDOs(contracts));
        return contractDTOsOpt.orElse(null);
    }

    @Override
    public RetrievedContractDTO retrieveContract(String cid, String eid) {
        //TODO to be replaced by a DAO call to the db
        return null;
    }

}
