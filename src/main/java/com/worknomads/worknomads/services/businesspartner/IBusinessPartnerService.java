package com.worknomads.worknomads.services.businesspartner;

import com.worknomads.worknomads.dtos.BusinessPartnerDTO;

public interface IBusinessPartnerService {
    BusinessPartnerDTO getBusinessPartnerByWalletAddress(String walletAddress);
    void createBusinessPartner(BusinessPartnerDTO businessDetailsDTO);
    void deleteBusinessPartner(String walletAddress);
    void updateBusinessPartner(BusinessPartnerDTO businessPartnerDTO);
}
