package com.tapusd.specialroutesservice.services;

import com.tapusd.specialroutesservice.exception.NoRouteFound;
import com.tapusd.specialroutesservice.model.AbTestingRoute;
import com.tapusd.specialroutesservice.repository.AbTestingRouteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AbTestingRouteService {
    
    @Autowired
    AbTestingRouteRepository abTestingRouteRepository;

    public AbTestingRoute getRoute(String serviceName){
        AbTestingRoute route = abTestingRouteRepository.findByServiceName(serviceName);

        if(route == null){
            throw new NoRouteFound();
        }

        return route;
    }

    public Iterable<AbTestingRoute> getAll(){
        return abTestingRouteRepository.findAll();
    }

    public void saveAbTestingRoute(AbTestingRoute route){
        abTestingRouteRepository.save(route);
    }

    public void updateRouteAbTestingRoute(AbTestingRoute route){
        abTestingRouteRepository.save(route);
    }

    public void deleteRoute(AbTestingRoute route){
        abTestingRouteRepository.delete(route);
    }
}