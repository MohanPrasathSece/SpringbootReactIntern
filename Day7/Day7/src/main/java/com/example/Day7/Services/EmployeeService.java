package com.example.Day7.Services;


import com.example.Day7.Models.RegisterDetails;
import com.example.Day7.Models.UserDetailsDto;
import com.example.Day7.Repository.RegisterDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;




















@Service
public class EmployeeService {

    @Autowired
    RegisterDetailsRepository registerDetailsRepository;

    // Get all employees
    public List<RegisterDetails> getMethod() {
        return registerDetailsRepository.findAll();
    }

    // Get employee by ID
    public RegisterDetails getEmployeeById(int empId) {
        return registerDetailsRepository.findById(empId).orElse(new RegisterDetails());
    }


    public String addEmployee(RegisterDetails employee) {
        registerDetailsRepository.save(employee);
        return "Employee Added Successfully";
    }


    public String updateEmployee(int empId, RegisterDetails updatedEmployee) {
        RegisterDetails user = registerDetailsRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("No Such User Present"));
        user.setName(updatedEmployee.getName());
        user.setEmail(updatedEmployee.getEmail());
        user.setPassword(updatedEmployee.getPassword());
        user.setUserName(updatedEmployee.getUserName());

        registerDetailsRepository.save(user);
        return "Employee Updated Successfully";
    }


    public String deleteEmployeeById(int empID) {
        registerDetailsRepository.deleteById(empID);
        return "Employee Deleted Successfully";
    }

    public List<RegisterDetails> getEmployeesByRole(String roleName) {
        return registerDetailsRepository.findByRoles_RoleName(roleName);
    }
}

