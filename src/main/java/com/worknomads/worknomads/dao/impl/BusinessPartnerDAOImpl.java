package com.worknomads.worknomads.dao.impl;

import com.worknomads.worknomads.dao.BusinessPartnerDAO;
import com.worknomads.worknomads.dao.BusinessPartnerRepository;
import com.worknomads.worknomads.dtos.BusinessPartnerDTO;
import com.worknomads.worknomads.models.BusinessPartner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BusinessPartnerDAOImpl implements BusinessPartnerDAO {

    @Autowired
    private BusinessPartnerRepository businessPartnerRepository;


    @Override
    public BusinessPartnerDTO getBusinessPartnerByWalletAddress(String walletAddress) {
        var businessPartner = this.businessPartnerRepository.findById(walletAddress);

        return businessPartner.map(businessPartner1 -> new BusinessPartnerDTO(
                businessPartner1.getName(),
                businessPartner1.getAddress(),
                businessPartner1.getEmail(),
                businessPartner1.getPhone(),
                businessPartner1.getWalletAddress(),
                null)).orElse(null);

    }

    @Override
    public List<BusinessPartnerDTO> getAll() {
        var businessPartners = this.businessPartnerRepository.findAll().iterator();

        var businessPartnersDTO = new ArrayList<BusinessPartnerDTO>();
        while (businessPartners.hasNext()) {
            var nextPartner = businessPartners.next();
            var partner = new BusinessPartnerDTO();
            partner.setId(nextPartner.getId());
            partner.setName(nextPartner.getName());
            partner.setEmail(nextPartner.getEmail());
            partner.setAddress(nextPartner.getAddress());
            partner.setPhone(nextPartner.getPhone());
            partner.setWalletAddress(nextPartner.getWalletAddress());
            businessPartnersDTO.add(partner);
        }
        return businessPartnersDTO;
    }

    @Override
    public void deleteBusinessPartner(String walletAddress) {
        this.businessPartnerRepository.deleteById(walletAddress);
    }

    @Override
    public void createBusinessPartner(BusinessPartnerDTO businessPartner) {
        if (businessPartner != null) {
            this.businessPartnerRepository.save(new
                BusinessPartner(
                businessPartner.getName(),
                businessPartner.getAddress(),
                businessPartner.getEmail(),
                businessPartner.getPhone(),
                businessPartner.getWalletAddress()));
        }
    }

    @Override
    public void updateBusinessPartner(BusinessPartnerDTO businessPartner) {
        if (businessPartner != null) {
            this.businessPartnerRepository.save(new
                BusinessPartner(
                businessPartner.getName(),
                businessPartner.getAddress(),
                businessPartner.getEmail(),
                businessPartner.getPhone(),
                businessPartner.getWalletAddress()));
        }
    }
}
