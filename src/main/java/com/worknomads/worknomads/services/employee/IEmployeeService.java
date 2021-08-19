package com.worknomads.worknomads.services.employee;

import com.worknomads.worknomads.dtos.EmployeeDTO;

public interface IEmployeeService {
    EmployeeDTO getEmployeeByWalletAddress(String walletAddress);
    void createEmployee(EmployeeDTO businessDetailsDTO);
    void deleteEmployee(String walletAddress);
    void updateEmployee(EmployeeDTO employeeDTO);
}