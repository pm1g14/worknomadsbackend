package com.worknomads.worknomads.services.employee;

import com.worknomads.worknomads.controllers.models.EmployeeResponse;
import com.worknomads.worknomads.dtos.EmployeeDTO;
import com.worknomads.worknomads.models.Employee;

import java.util.List;

public interface IEmployeeService {
    EmployeeDTO getEmployeeByWalletAddress(String walletAddress);
    List<EmployeeDTO> getAll();
    void createEmployee(EmployeeDTO businessDetailsDTO);
    void deleteEmployee(String walletAddress);
    void updateEmployee(EmployeeDTO employeeDTO);
}
