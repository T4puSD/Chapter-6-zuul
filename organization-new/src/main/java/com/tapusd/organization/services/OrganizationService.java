package com.tapusd.organization.services;

import java.util.Optional;

import com.tapusd.organization.models.Organization;
import com.tapusd.organization.repository.OrganizationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationService {
    @Autowired
    private OrganizationRepository orgRepository;

    public Organization getOrg(Long organizationId){
        Optional<Organization> data =  orgRepository.findById(organizationId);
        Organization org = null;
        if(data.isPresent()){
            org = data.get();
            org.setContactName("NEW:: " + org.getContactName());
        }
        return org;
    }

    public void saveOrg(Organization org){
        orgRepository.save(org);
    }

    public void updateOrg(Organization org){
        orgRepository.save(org);
    }

    public void deleteOrg(Organization org){
        orgRepository.delete(org);
    }
}