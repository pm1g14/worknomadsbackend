package com.worknomads.worknomads.services.businesspartner;

import com.worknomads.worknomads.dao.BusinessPartnerRepository;
import com.worknomads.worknomads.dtos.BusinessPartnerDTO;
import com.worknomads.worknomads.models.BusinessPartner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusinessPartnerService implements IBusinessPartnerService{

    @Autowired
    private BusinessPartnerRepository businessPartnerRepository;

    @Override
    public BusinessPartnerDTO getBusinessPartnerByWalletAddress(String walletAddress) {

        var businessPartner = this.businessPartnerRepository.findById(walletAddress);

        if (!businessPartner.isPresent()) return null;

        return new BusinessPartnerDTO(
                businessPartner.get().getName(),
                businessPartner.get().getAddress(),
                businessPartner.get().getEmail(),
                businessPartner.get().getPhone(),
                businessPartner.get().getWalletAddress(),
                null);
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
    public void createBusinessPartner(BusinessPartnerDTO bpDto) {

        this.businessPartnerRepository.save(new
                BusinessPartner(
                bpDto.getName(),
                bpDto.getAddress(),
                bpDto.getEmail(),
                bpDto.getPhone(),
                bpDto.getWalletAddress()));
    }

    @Override
    public void deleteBusinessPartner(String walletAddress) {
        this.businessPartnerRepository.deleteById(walletAddress);
    }

    @Override
    public void updateBusinessPartner(BusinessPartnerDTO bpDto) {

        this.businessPartnerRepository.save(new
                BusinessPartner(
                bpDto.getName(),
                bpDto.getAddress(),
                bpDto.getEmail(),
                bpDto.getPhone(),
                bpDto.getWalletAddress()));
    }
}
