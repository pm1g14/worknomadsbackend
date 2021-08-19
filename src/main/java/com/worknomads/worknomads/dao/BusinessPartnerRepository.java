package com.worknomads.worknomads.dao;

import com.worknomads.worknomads.models.BusinessPartner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessPartnerRepository extends CrudRepository<BusinessPartner, String> {
}
