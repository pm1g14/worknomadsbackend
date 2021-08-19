package com.worknomads.worknomads.dtos;

public class EmployeeDTO {
    private Integer id;
    private final String employeeName;
    private final String employeeSur;
    private final String address;
    private final String countryOfResidence;
    private final String email;
    private final String phoneNum;
    private final String employeeWalletAddress;

    public EmployeeDTO( String employeeName, String employeeSur, String address, String countryOfResidence, String email, String phoneNum, String employeeWalletAddress) {
        this.employeeName = employeeName;
        this.employeeSur = employeeSur;
        this.address = address;
        this.countryOfResidence = countryOfResidence;
        this.email = email;
        this.phoneNum = phoneNum;
        this.employeeWalletAddress = employeeWalletAddress;
    }

    public Integer getId(){
        return id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeSur() {
        return employeeSur;
    }

    public String getAddress() {
        return address;
    }

    public String getCountryOfResidence() {
        return countryOfResidence;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getEmployeeWalletAddress() {
        return employeeWalletAddress;
    }
}
