package com.worknomads.worknomads.services.employee;

import com.worknomads.worknomads.dao.EmployeeRepository;
import com.worknomads.worknomads.dtos.EmployeeDTO;
import com.worknomads.worknomads.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServices implements IEmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public EmployeeDTO getEmployeeByWalletAddress(String walletAddress) {

        var employee = this.employeeRepository.findById(walletAddress);

        if (!employee.isPresent()) return null;

        return new EmployeeDTO(
                employee.get().getEmployeeName(),
                employee.get().getSurname(),
                employee.get().getAddress(),
                employee.get().getCountryOfResidence(),
                employee.get().getEmail(),
                employee.get().getPhoneNum(),
                employee.get().getWalletAddress()
        );
    }

    @Override
    public void createEmployee(EmployeeDTO employeeDTO) {
        this.employeeRepository.save(new Employee(
                employeeDTO.getEmployeeName(),
                employeeDTO.getEmployeeSur(),
                employeeDTO.getAddress(),
                employeeDTO.getCountryOfResidence(),
                employeeDTO.getEmail(),
                employeeDTO.getPhoneNum(),
                employeeDTO.getEmployeeWalletAddress()));
    }

    @Override
    public void deleteEmployee(String walletAddress) {
        this.employeeRepository.deleteById(walletAddress);
    }

    @Override
    public void updateEmployee(EmployeeDTO employeeDTO) {
        this.employeeRepository.save(new Employee(
                employeeDTO.getEmployeeName(),
                employeeDTO.getEmployeeSur(),
                employeeDTO.getAddress(),
                employeeDTO.getCountryOfResidence(),
                employeeDTO.getEmail(),
                employeeDTO.getPhoneNum(),
                employeeDTO.getEmployeeWalletAddress()));
    }
}
