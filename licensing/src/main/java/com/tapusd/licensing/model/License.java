package com.tapusd.licensing.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "licenses")
public class License {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long licenseId;
    private Long organizationId;
    private String productName;
    private String licenseType;
    private Integer licenseMax;
    private Integer licenseAllocated;
    private String comment = "no comment";

    @Transient
    private String organizationName ="";
  
    @Transient
    private String contactName ="";
  
    @Transient
    private String contactPhone ="";
  
    @Transient
    private String contactEmail ="";

    public Long getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(Long id) {
        this.licenseId = id;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }

    public Integer getLicenseMax() {
        return licenseMax;
    }

    public void setLicenseMax(Integer licenseMax) {
        this.licenseMax = licenseMax;
    }

    public Integer getLicenseAllocated() {
        return licenseAllocated;
    }

    public void setLicenseAllocated(Integer licenseAllocated) {
        this.licenseAllocated = licenseAllocated;
    }

    public String getComment(){
        return this.comment;
    }

    public void setComment(String comment){
        this.comment = comment;
    }

    public String getOrganizationName() {
        return organizationName;
      }
    
      public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
      }
    
      public String getContactName() {
        return contactName;
      }
    
      public void setContactName(String contactName) {
        this.contactName = contactName;
      }
    
      public String getContactPhone() {
        return contactPhone;
      }
    
      public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
      }
    
      public String getContactEmail() {
        return contactEmail;
      }
    
      public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
      }
    

    public License withLicenseId(Long id){
        this.licenseId = id;
        return this;
    }

    public License withOrganizationId(Long organizationId){
        this.organizationId = organizationId;
        return this;
    }
    
    public License withProductName(String productName){
        this.productName = productName;
        return this;
    }

    public License withLicenseType(String licenseType){
        this.licenseType = licenseType;
        return this;
    }

    public License withLicenseMax(Integer licenseMax){
        this.licenseMax = licenseMax;
        return this;
    }

    public License withLicenseAllocated(Integer licenseAllocated){
        this.licenseAllocated = licenseAllocated;
        return this;
    }
	public License withComment(String coment) {
        this.comment = coment;
        return this;
    }
    
    public License withOrganizationName(String organizationName){
        this.setOrganizationName(organizationName);
        return this;
      }
    
      public License withContactName(String contactName){
        this.setContactName(contactName);
        return this;
      }
    
      public License withContactPhone(String contactPhone){
        this.setContactPhone(contactPhone);
        return this;
      }
    
      public License withContactEmail(String contactEmail){
        this.setContactEmail(contactEmail);
        return this;
      }


    
}