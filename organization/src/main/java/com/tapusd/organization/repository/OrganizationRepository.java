package com.tapusd.organization.repository;

import com.tapusd.organization.models.Organization;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends CrudRepository<Organization, Long>{
}