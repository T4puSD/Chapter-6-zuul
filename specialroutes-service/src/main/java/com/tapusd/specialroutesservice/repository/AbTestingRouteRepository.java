package com.tapusd.specialroutesservice.repository;

import com.tapusd.specialroutesservice.model.AbTestingRoute;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbTestingRouteRepository extends CrudRepository<AbTestingRoute, String>{
    public AbTestingRoute findByServiceName(String serviceName);
}