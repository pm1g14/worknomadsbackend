package com.worknomads.worknomads.dao;

import com.worknomads.worknomads.dtos.BusinessPartnerDTO;

import java.util.List;

public interface BusinessPartnerDAO {

    BusinessPartnerDTO getBusinessPartnerByWalletAddress(String walletAddress);

    List<BusinessPartnerDTO> getAll();

    void deleteBusinessPartner(String walletAddress);

    void createBusinessPartner(BusinessPartnerDTO businessPartner);

    void updateBusinessPartner(BusinessPartnerDTO businessPartner);
}
