package com.worknomads.worknomads.services.businesspartner;

import com.worknomads.worknomads.dtos.BusinessPartnerDTO;

import java.util.List;

public interface IBusinessPartnerService {
    BusinessPartnerDTO getBusinessPartnerByWalletAddress(String walletAddress);
    List<BusinessPartnerDTO> getAll();
    void createBusinessPartner(BusinessPartnerDTO businessDetailsDTO);
    void deleteBusinessPartner(String walletAddress);
    void updateBusinessPartner(BusinessPartnerDTO businessPartnerDTO);
}
