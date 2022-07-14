package com.module.JPA.service;

import com.module.JPA.entity.Employee;
import com.module.JPA.entity.dto.EmployeeDTO;
import com.module.JPA.repository.EmployeeRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private ModelMapper modelMapper;
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
    public List<EmployeeDTO> findByDepartmentName(String name){
        List<Employee> employees = employeeRepo.findByDepartmentName(name);
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        for (int i=0; i<employees.size(); i++){
            EmployeeDTO employeeDTO = new EmployeeDTO();
            modelMapper.map(employees.get(i), employeeDTO);
//            employeeDTO.setId(employees.get(i).getId());
//            employeeDTO.setName(employees.get(i).getName());
//            employeeDTO.setEmail(employees.get(i).getEmail());

            employeeDTOList.add(employeeDTO);
        }
        return employeeDTOList;
    }

    // Get all employees have same salary
    public List<EmployeeDTO> findEmpBySalary(Double salary){
        List<Employee> employees = employeeRepo.findEmpBySalary(salary);
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        for (int i=0; i<employees.size(); i++){
            EmployeeDTO employeeDTO = new EmployeeDTO();
            modelMapper.map(employees.get(i),employeeDTO);
//            employeeDTO.setId(employees.get(i).getId());
//            employeeDTO.setName(employees.get(i).getName());
//            employeeDTO.setEmail(employees.get(i).getEmail());
            employeeDTOList.add(employeeDTO);
        }
        return employeeDTOList;
    }



}
