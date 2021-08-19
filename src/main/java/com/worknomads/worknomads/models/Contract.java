package com.worknomads.worknomads.models;

//import javax.persistence.*;

import javax.persistence.*;

@Entity
@Table(name = "Contracts")
public class Contract {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String contract_expiry;
    private String gross_salary;
    private String remote_location;
    private String payment_installments;
    private String payment_term;
    private String balance_unit;
    private String address;
    private String employee_wallet_address;
    private String business_partner_wallet_address;

    protected Contract() {}

    public Contract(String contractExpiry, String grossSalary, String remoteLocation, String paymentInstallments, String paymentTerm, String balanceUnit, String address, String employee_wallet_address, String business_partner_wallet_address) {
        this.contract_expiry = contractExpiry;
        this.gross_salary = grossSalary;
        this.remote_location = remoteLocation;
        this.payment_installments = paymentInstallments;
        this.payment_term = paymentTerm;
        this.balance_unit = balanceUnit;
        this.address = address;
        this.employee_wallet_address = employee_wallet_address;
        this.business_partner_wallet_address = business_partner_wallet_address;
    }

    public Integer getId() {
        return id;
    }

    public String getContractExpiry() {
        return contract_expiry;
    }

    public String getGrossSalary() {
        return gross_salary;
    }

    public String getRemoteLocation() {
        return remote_location;
    }

    public String getPaymentInstallments() {
        return payment_installments;
    }

    public String getPaymentTerm() {
        return payment_term;
    }

    public String getBalanceUnit() {
        return balance_unit;
    }

    public String getAddress() {
        return address;
    }

    public String getEmployee_walletAddress() {
        return employee_wallet_address;
    }

    public String getBusiness_partner_walletAddress() {
        return business_partner_wallet_address;
    }
}
