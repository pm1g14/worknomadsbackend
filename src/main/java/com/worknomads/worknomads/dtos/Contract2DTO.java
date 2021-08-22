package com.worknomads.worknomads.dtos;

public class Contract2DTO {
    private final Integer id;
    private final String contractExpiry;
    private final double grossSalary;
    private final String remoteLocation;
    private final int paymentInstallments;
    private final String paymentTerm;
    private final String balanceUnit;
    private final String address;
    private String employee_walletAddress;
    private String business_partner_walletAddress;

    private EmployeeDTO employeeDTO;
    private BusinessPartnerDTO businessPartnerDTO;

    public Contract2DTO(Integer id, String contractExpiry, double grossSalary, String remoteLocation, int paymentInstallments, String paymentTerm, String balanceUnit, String address, String employee_walletAddress, String business_partner_walletAddress) {
        this.id = id;
        this.contractExpiry = contractExpiry;
        this.grossSalary = grossSalary;
        this.remoteLocation = remoteLocation;
        this.paymentInstallments = paymentInstallments;
        this.paymentTerm = paymentTerm;
        this.balanceUnit = balanceUnit;
        this.address = address;
        this.employee_walletAddress = employee_walletAddress;
        this.business_partner_walletAddress = business_partner_walletAddress;
    }

    public String getAddress() {
        return address;
    }

    public Integer getId() {
        return id;
    }

    public String getEmployee_walletAddress() {
        return employee_walletAddress;
    }

    public String getBusiness_partner_walletAddress() {
        return business_partner_walletAddress;
    }
}
