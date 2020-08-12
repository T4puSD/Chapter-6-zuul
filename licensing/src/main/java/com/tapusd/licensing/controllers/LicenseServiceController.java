package com.tapusd.licensing.controllers;

import java.util.List;

// import com.tapusd.licensing.config.ServiceConfig;
import com.tapusd.licensing.model.License;
import com.tapusd.licensing.services.LicenseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/organizations/{organizationId}/licenses")
public class LicenseServiceController {

    @Autowired
    private LicenseService licenseService;

    // @Autowired
    // private ServiceConfig serviceConfig;

    @GetMapping(value = "/{licenseId}/{clientType}")
    public License getLicenseWithClient(
        @PathVariable("organizationId") Long organizationId,
        @PathVariable("licenseId") Long licenseId,
        @PathVariable("clientType") String clientType
    ){
        // return "Org: " + organizationId + " license: " + licenseId + " cilent type: " + clientType;
        License license = licenseService.getLicense(organizationId, licenseId,clientType);
        if(license == null) return null;
        return license;
    }
    
    @GetMapping("/")
    public List<License> getLicense(@PathVariable("organizationId") Long organizationId){
        return licenseService.getLicenseByOrg(organizationId);
    }

    @GetMapping(value = "/{licenseId}")
    public License getLicenses(@PathVariable("organizationId") Long organizationId,
                                @PathVariable("licenseId") Long licenseId)
    {
        return licenseService.getLicense(organizationId, licenseId);
    }

    @PutMapping("/{licenseId}")
    public String updateLicense(@PathVariable("licenseId") Long licenseId){
        return "This is the put";
    }

    @PostMapping("/")
    public void saveLicense(@RequestBody License license){
        licenseService.saveLicense(license);
    }

    @DeleteMapping("/{licenseId}")
    public String deleteLicense(@PathVariable("licenseId") Long licenseId){
        return "This is delete";
    }
    
}