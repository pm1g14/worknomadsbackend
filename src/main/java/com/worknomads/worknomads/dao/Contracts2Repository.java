package com.worknomads.worknomads.dao;

import com.worknomads.worknomads.models.SmartContract;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Contracts2Repository extends CrudRepository<SmartContract, String> {
    @Query("SELECT c.address FROM SmartContract c WHERE c.business_partner_wallet_address  = :business_partner_wallet_address")
    List<String> findByBusinessPartnerWalletAddress(@Param("business_partner_wallet_address") String business_partner_wallet_address);
}
