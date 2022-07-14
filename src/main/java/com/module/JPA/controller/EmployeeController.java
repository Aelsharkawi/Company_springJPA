package com.module.JPA.controller;

import com.module.JPA.entity.Employee;
import com.module.JPA.entity.dto.EmployeeDTO;
import com.module.JPA.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("emp")
public class EmployeeController {

    private EmployeeService employeeService;

    // Get all employees
    @GetMapping("employees")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    // get a specific employee be id
    @GetMapping
    public Employee findById(@RequestParam Long id){
        return employeeService.findById(id);
    }

    // save employee
    @PostMapping("saveEmp")
    public void insertEmp(@RequestBody Employee emp) {
         employeeService.insertEmp(emp);
    }
    // save list of employee
    @PostMapping("saveEmpList")
    public void insertEmpList(@RequestBody List<Employee> empList){

        employeeService.insertEmpList(empList);
    }

    //update employee
    @PutMapping("updateEmp")
    public Employee updateEmployeeData(@RequestBody Employee emp){
        return employeeService.updateEmployeeData(emp);
    }

    //Delete employee
    @DeleteMapping("del")
    public void deleteEmp(@RequestParam Long id){
        employeeService.deleteEmp(id);
    }


    // get employees related to specific department
    @GetMapping("department/{name}")
    public List<EmployeeDTO> findByDepartmentName(@PathVariable String name){
        return employeeService.findByDepartmentName(name);
    }

    //http://localhost:8090/emp/empSalary/21000.0
    // Get all employees have same salary
    @GetMapping("empSalary/{salary}")
    public List<EmployeeDTO> findEmpBySalary(@PathVariable Double salary){
        return employeeService.findEmpBySalary(salary);
    }


}
