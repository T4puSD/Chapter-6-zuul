package com.tapusd.licensing.services;

import java.util.List;
import java.util.Random;

import com.tapusd.licensing.clients.OrganizationRestTemplateClient;
import com.tapusd.licensing.config.ServiceConfig;
import com.tapusd.licensing.model.License;
import com.tapusd.licensing.model.Organization;
import com.tapusd.licensing.repository.LicenseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LicenseService {
    @Autowired
    private LicenseRepository licenseRepository;

    @Autowired
    private ServiceConfig config;

    @Autowired
    private OrganizationRestTemplateClient organizationRestClient;


    public License getLicense(Long organizationId, Long licenseId){
        License license = licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId);
        if(license != null) license.withComment(config.getExampleProperty());
        // System.out.println(config.getExampleProperty());
        return license;
    }

    public License getLicenseWithOrg(Long organizationId, Long licenseId){
        License license = licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId);
        if(license == null) return null;
        Organization org = organizationRestClient.getOrganization(organizationId);

        return license
            .withOrganizationName(org.getName())
            .withContactName(org.getContactName())
            .withContactEmail(org.getContactEmail())
            .withContactPhone(org.getContactPhone())
            .withComment(config.getExampleProperty());

        // return license
        //     .withOrganizationName("xyxx")
        //     .withContactName("permanent")
        //     .withContactEmail("xyz@domain.com")
        //     .withContactPhone("23982302")
        //     .withComment(config.getExampleProperty());
    }

    public List<License> getLicenseByOrg(Long organizationId){
        return licenseRepository.findByOrganizationId(organizationId);
    }

    public void saveLicense(License license){
        license.withLicenseId(new Random().nextLong());
        licenseRepository.save(license);
    }

    public void updateLicense(License license){
        licenseRepository.save(license);
      }
  
      public void deleteLicense(License license){
          licenseRepository.deleteById( license.getLicenseId());
      }
    
}