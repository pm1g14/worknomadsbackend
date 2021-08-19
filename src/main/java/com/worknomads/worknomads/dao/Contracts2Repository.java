package com.worknomads.worknomads.dao;

import com.worknomads.worknomads.models.Contract;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Contracts2Repository extends CrudRepository<Contract, Integer> {

    @Query("SELECT c.address FROM Contract c WHERE c.business_partner_wallet_address  = :business_partner_walletAddress")
    List<String> findByBusinessPartnerWalletAddress(@Param("business_partner_walletAddress") String business_partner_walletAddress);
}
