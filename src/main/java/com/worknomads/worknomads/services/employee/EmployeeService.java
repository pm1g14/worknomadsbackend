package com.worknomads.worknomads.services.employee;

import com.worknomads.worknomads.controllers.models.EmployeeResponse;
import com.worknomads.worknomads.dao.EmployeeRepository;
import com.worknomads.worknomads.dtos.EmployeeDTO;
import com.worknomads.worknomads.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements IEmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public EmployeeDTO getEmployeeByWalletAddress(String walletAddress) {

        var employee = this.employeeRepository.findById(walletAddress);

        if (!employee.isPresent()) return null;

        var employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.get().getId());
        employeeDTO.setName(employee.get().getEmployeeName());
        employeeDTO.setSurname(employee.get().getSurname());
        employeeDTO.setAddress(employee.get().getAddress());
        employeeDTO.setEmail(employee.get().getEmail());
        employeeDTO.setCountryOfResidence(employee.get().getCountryOfResidence());
        employeeDTO.setPhoneNum(employee.get().getPhoneNum());
        employeeDTO.setWalletAddress(employee.get().getWalletAddress());

        return employeeDTO;
    }

    @Override
    public List<EmployeeDTO> getAll() {

        var employees = this.employeeRepository.findAll().iterator();

        var actualList = new ArrayList<EmployeeDTO>();
        while (employees.hasNext()) {
            var nextEmployee = employees.next();
            var employee = new EmployeeDTO();
            employee.setId(nextEmployee.getId());
            employee.setName(nextEmployee.getEmployeeName());
            employee.setSurname(nextEmployee.getSurname());
            employee.setAddress(nextEmployee.getAddress());
            employee.setEmail(nextEmployee.getEmail());
            employee.setCountryOfResidence(nextEmployee.getCountryOfResidence());
            employee.setPhoneNum(nextEmployee.getPhoneNum());
            employee.setWalletAddress(nextEmployee.getWalletAddress());

            actualList.add(employee);
        }

        return actualList;
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
