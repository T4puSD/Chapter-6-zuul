package com.tapusd.licensing.services;

import java.util.List;
import java.util.Random;

import com.tapusd.licensing.clients.OrganizationDiscoveryClient;
import com.tapusd.licensing.clients.OrganizationFeignClient;
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
    private OrganizationFeignClient organizationFeignClient;

    @Autowired
    private OrganizationRestTemplateClient organizationRestClient;

    @Autowired
    private OrganizationDiscoveryClient organizationDiscoveryClient;

    public Organization retrieveOrgInfo(Long organizationId, String clientType){
        System.out.println("inside service: " + clientType);
        Organization organization = null;

        switch(clientType){
            case "feign":
                System.out.println("I am using the feign client");
                organization = organizationFeignClient.getOrganization(organizationId);
                break;
            case "rest":
                System.out.println("I am using the rest client");
                organization = organizationRestClient.getOrganization(organizationId);
                break;
            case "discovery":
                System.out.println("I am using the discovery client");
                organization = organizationDiscoveryClient.getOrganization(organizationId);
                break;
            default:
                organization = organizationRestClient.getOrganization(organizationId);
        }

        return organization;
    }


    public License getLicense(Long organizationId, Long licenseId){
        License license = licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId);
        if(license != null) license.withComment(config.getExampleProperty());
        // System.out.println(config.getExampleProperty());
        return license;
    }

    public License getLicense(Long organizationId, Long licenseId, String clientType){
        License license = licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId);
        if(license == null) return null;
        Organization org = retrieveOrgInfo(organizationId, clientType);

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