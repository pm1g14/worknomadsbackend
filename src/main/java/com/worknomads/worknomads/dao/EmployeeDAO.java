package com.worknomads.worknomads.dao;

import com.worknomads.worknomads.dtos.EmployeeDTO;

import java.util.List;

public interface EmployeeDAO {

    EmployeeDTO findById(String walletAddress);

    List<EmployeeDTO> getAll();

    void save(EmployeeDTO employeeDTO);

    void deleteEmployeeById(String walletAddress);

    void updateEmployee(EmployeeDTO employeeDTO);
}
