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
import io.micrometer.core.instrument.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.protocol.exceptions.TransactionException;
import org.web3j.tx.exceptions.ContractCallException;

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
    private Logger logger = LoggerFactory.getLogger(RetrieveContractsServiceImpl.class);


    @Override
    public ContractDTOs retrieveContracts(String walletAddress) {
        List<String> addresses;

        if (StringUtils.isEmpty(walletAddress))
            addresses = dao.retrieveAllContractAddresses();
        else
            addresses = dao.retrieveContractAddressesForWallet(walletAddress);

        List<RetrievedContractDO> contracts = new ArrayList<>();
        for (String address: addresses) {
            if (address != null) {
                try {
                    RetrievedContractDO retrievedContract = ethNetworkService.getContractDetailsFromAddress(address);
                    contracts.add(retrievedContract);
                } catch (IllegalArgumentException ex){
                    logger.debug("Contract at address "+ address + " has invalid values. Ignoring...");
                } catch (ContractCallException ex2) {
                    logger.debug("Contract call has failed with:"+ ex2.getMessage());
                } catch (TransactionException ex3) {
                    logger.debug("Transaction has failed for: "+ ex3.getMessage());
                }
            }
        }

        Optional<ContractDTOs> contractDTOsOpt;
        if (contracts.isEmpty())
            contractDTOsOpt = Optional.empty();
        else
            contractDTOsOpt = ioAdapter.mapDOtoDTO(new ContractDOs(contracts));
        return contractDTOsOpt.orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public RetrievedContractDTO retrieveContract(String cid, String eid) {
        //TODO to be replaced by a DAO call to the db
        return null;
    }

}
