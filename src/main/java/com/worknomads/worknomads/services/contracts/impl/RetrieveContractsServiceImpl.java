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
import java.util.List;
import java.util.Optional;

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
        List<RetrievedContractDO> contracts = new ArrayList<>();
        for (String address: addresses) {
            if (address != null) {
                contracts.add(ethNetworkService.getContractDetailsFromAddress(address));
            }
        }

        Optional<ContractDTOs> contractDTOsOpt = ioAdapter.mapDOtoDTO(new ContractDOs(contracts));
        return contractDTOsOpt.orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public RetrievedContractDTO retrieveContract(String cid, String eid) {
        //TODO to be replaced by a DAO call to the db
        return null;
    }

}
