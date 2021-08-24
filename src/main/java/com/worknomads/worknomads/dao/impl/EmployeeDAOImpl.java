package com.worknomads.worknomads.dao.impl;

import com.worknomads.worknomads.dao.EmployeeDAO;
import com.worknomads.worknomads.dao.EmployeeRepository;
import com.worknomads.worknomads.dtos.EmployeeDTO;
import com.worknomads.worknomads.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public EmployeeDTO findById(String walletAddress) {
        var employee = employeeRepository.findById(walletAddress);
        if (!employee.isPresent()) return null;

        return new EmployeeDTO(
            employee.get().getId(),
            employee.get().getEmployeeName(),
            employee.get().getSurname(),
            employee.get().getAddress(),
            employee.get().getEmail(),
            employee.get().getCountryOfResidence(),
            employee.get().getPhoneNum(),
            employee.get().getWalletAddress());
    }

    @Override
    public List<EmployeeDTO> getAll() {
        var employees = employeeRepository.findAll().iterator();

        var employeeDTOs = new ArrayList<EmployeeDTO>();
        while (employees.hasNext()) {
            var nextEmployee = employees.next();

            employeeDTOs.add(new EmployeeDTO(
                nextEmployee.getId(),
                nextEmployee.getEmployeeName(),
                nextEmployee.getSurname(),
                nextEmployee.getAddress(),
                nextEmployee.getEmail(),
                nextEmployee.getCountryOfResidence(),
                nextEmployee.getPhoneNum(),
                nextEmployee.getWalletAddress()
            ));
        }
        return employeeDTOs;
    }

    @Override
    public void save(EmployeeDTO employeeDTO) {
        if (employeeDTO != null) {
            employeeRepository.save(new Employee(
                employeeDTO.getName(),
                employeeDTO.getSurname(),
                employeeDTO.getAddress(),
                employeeDTO.getCountryOfResidence(),
                employeeDTO.getEmail(),
                employeeDTO.getPhoneNum(),
                employeeDTO.getWalletAddress()));
        }
    }

    @Override
    public void deleteEmployeeById(String walletAddress) {
        employeeRepository.deleteById(walletAddress);
    }

    @Override
    public void updateEmployee(EmployeeDTO employeeDTO) {
        if (employeeDTO != null) {
            employeeRepository.save(new Employee(
                employeeDTO.getName(),
                employeeDTO.getSurname(),
                employeeDTO.getAddress(),
                employeeDTO.getCountryOfResidence(),
                employeeDTO.getEmail(),
                employeeDTO.getPhoneNum(),
                employeeDTO.getWalletAddress()));
        }
    }
}
