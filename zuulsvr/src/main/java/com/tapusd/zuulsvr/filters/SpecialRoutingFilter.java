package com.tapusd.zuulsvr.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.tapusd.zuulsvr.model.AbTestingRoute;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.ProxyRequestHelper;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class SpecialRoutingFilter extends ZuulFilter {
    private final static Logger logger = LoggerFactory.getLogger(SpecialRoutingFilter.class);
    private final static boolean SHOULD_FILTER = true;
    private final static int FILTER_ORDER = 1;

    private ProxyRequestHelper helper = new ProxyRequestHelper();

    @Autowired
    FilterUtils filterUtils;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public boolean shouldFilter() {
        return SHOULD_FILTER;
    }

    @Override
    public String filterType() {
        return FilterUtils.ROUTE_FILTER_TYPE;
    }

    @Override
    public int filterOrder() {
        return FILTER_ORDER;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        logger.debug("Inside Routing Filter with correlation id: {}", filterUtils.getCorrelationId());
        String endpoint = ctx.getRequest().getRequestURI();
        logger.debug("service-id: {}",filterUtils.getServiceId());

        getAbRoutingInfo("organizationservice"); 

        

        return null;

    }
    
    private AbTestingRoute getAbRoutingInfo(String serviceName){
        ResponseEntity<AbTestingRoute> restExchange = null;

        try{
            restExchange = restTemplate.exchange(
                "http://specialroutesservice/v1/route/abtesting/{serviceName}", 
                HttpMethod.GET,null, AbTestingRoute.class, serviceName);

        } catch(HttpClientErrorException ex){
            if(ex.getStatusCode() == HttpStatus.NOT_FOUND){
                throw ex;
            }
        }
        System.out.println(restExchange.getBody());
        return restExchange.getBody();
    }
}