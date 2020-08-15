package com.tapusd.zuulsvr.model;


public class AbTestingRoute {
    
    private Long id;
    private String serviceName;
    private String active;
    private String endpoint;
    private Integer weight;

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "AbTestingRoute [active=" + active + ", endpoint=" + endpoint + ", id=" + id + ", serviceName="
                + serviceName + ", weight=" + weight + "]";
    }
}