package com.worknomads.worknomads.dao;

import com.worknomads.worknomads.dos.ContractDO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContractsRepository extends MongoRepository<Boolean, ContractDO> {

    Boolean createContract(ContractDO contractDO);

}
