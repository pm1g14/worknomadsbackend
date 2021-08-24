package com.worknomads.worknomads.services.employee;

import com.worknomads.worknomads.dao.EmployeeDAO;
import com.worknomads.worknomads.dtos.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService{

    @Autowired
    private EmployeeDAO dao;

    @Override
    public EmployeeDTO getEmployeeByWalletAddress(String walletAddress) {
        return dao.findById(walletAddress);
    }

    @Override
    public List<EmployeeDTO> getAll() {
        return dao.getAll();
    }

    @Override
    public void createEmployee(EmployeeDTO employeeDTO) {
        dao.save(employeeDTO);
    }

    @Override
    public void deleteEmployee(String walletAddress) {
        dao.deleteEmployeeById(walletAddress);
    }

    @Override
    public void updateEmployee(EmployeeDTO employeeDTO) {
        dao.updateEmployee(employeeDTO);
    }
}
