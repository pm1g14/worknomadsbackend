package com.worknomads.worknomads.services.businesspartner.impl;

import com.worknomads.worknomads.dao.BusinessPartnerDAO;
import com.worknomads.worknomads.dtos.BusinessPartnerDTO;
import com.worknomads.worknomads.services.businesspartner.IBusinessPartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessPartnerService implements IBusinessPartnerService {

    @Autowired
    private BusinessPartnerDAO dao;

    @Override
    public BusinessPartnerDTO getBusinessPartnerByWalletAddress(String walletAddress) {
        return dao.getBusinessPartnerByWalletAddress(walletAddress);
    }

    @Override
    public List<BusinessPartnerDTO> getAll() {
        return dao.getAll();
    }

    @Override
    public void createBusinessPartner(BusinessPartnerDTO bpDto) {
        dao.createBusinessPartner(bpDto);
    }

    @Override
    public void deleteBusinessPartner(String walletAddress) {
        dao.deleteBusinessPartner(walletAddress);
    }

    @Override
    public void updateBusinessPartner(BusinessPartnerDTO bpDto) {
        dao.updateBusinessPartner(bpDto);
    }
}
