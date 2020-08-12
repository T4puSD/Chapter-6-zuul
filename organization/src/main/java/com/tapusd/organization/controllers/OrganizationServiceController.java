package com.tapusd.organization.controllers;

import com.tapusd.organization.models.Organization;
import com.tapusd.organization.repository.OrganizationRepository;
import com.tapusd.organization.services.OrganizationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1/organizations")
public class OrganizationServiceController {

    @Autowired
    private OrganizationService orgService;

    @Autowired
    private OrganizationRepository repo;

    
    @GetMapping("/")
	public Iterable<Organization> home(){
		return repo.findAll();
    }
    
    @GetMapping("/{organizationId}")
    public Organization getOrganization(@PathVariable("organizationId") Long organizationId){
        System.out.println("Organization service called");
        return orgService.getOrg(organizationId);
    }

    @PutMapping("/{organizationId}")
    public void updateOrganization(@PathVariable("organizationId") Long organizationId, @RequestBody Organization org){
        orgService.updateOrg(org);
    }

    @PostMapping("/")
    public void saveOrganization(@RequestBody Organization org){
        orgService.saveOrg(org);
    }

    @DeleteMapping("/{organizationId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrganization(@PathVariable("organizatinoId") Long organizatinoId, @RequestBody Organization org){
        orgService.deleteOrg(org);
    }
    
}