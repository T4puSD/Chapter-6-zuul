package com.tapusd.licensing.repository;

import java.util.List;

import com.tapusd.licensing.model.License;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long> {
    public List<License> findByOrganizationId(Long organizationId);
    public License findByOrganizationIdAndLicenseId(Long organizationId, Long licenseId);
}