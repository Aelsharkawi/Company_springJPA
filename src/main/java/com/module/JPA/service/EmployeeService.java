package com.module.JPA.service;

import com.module.JPA.entity.Employee;
import com.module.JPA.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;
    // get all employees
    public List<Employee> getEmployees() {
        return employeeRepo.findAll();
    }
    // get employee by id
    public Employee findById(Long id){
        return employeeRepo.findById(id).orElseThrow();
    }

    // add new employee
    public void insertEmp(Employee emp){
         employeeRepo.save(emp);
    }

    // add new list of employees
    public void insertEmpList(List<Employee> empList) {
         employeeRepo.saveAll(empList);
    }

    //update employee
    public Employee updateEmployeeData(Employee emp){
       //Employee currentEmp = employeeRepo.getById(emp.getId());
       emp.setName(emp.getName());
       emp.setSalary(emp.getSalary());
       emp.setEmail(emp.getEmail());
       emp.setDepartment(emp.getDepartment());
       return employeeRepo.save(emp);
    }


    // Delete Employee
    public void deleteEmp(Long id) {
        employeeRepo.deleteById(id);
    }


    // get all employees related to department
    public List<Employee> findByDepartmentName(String name){
        return employeeRepo.findByDepartmentName(name);
    }

    // Get all employees have same salary
    public List<Employee> findEmpBySalary(Double salary){
        return employeeRepo.findEmpBySalary(salary);
    }



}
