package com.tapusd.specialroutesservice.controllers;

import com.tapusd.specialroutesservice.model.AbTestingRoute;
import com.tapusd.specialroutesservice.services.AbTestingRouteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1/route/")
public class SpecialRoutesServiceController {

    @Autowired
    AbTestingRouteService routeService;

    @GetMapping(value = "abtesting/{serviceName}")
    public AbTestingRoute abtestings(@PathVariable("serviceName") String serviceName){
        return routeService.getRoute(serviceName);
    }

    @PostMapping(value = "/abtesting")
    public void saveAbTestingRoutes(@RequestBody AbTestingRoute route){
        routeService.saveAbTestingRoute(route);
    }
    
}