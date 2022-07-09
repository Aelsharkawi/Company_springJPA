package com.module.JPA.controller;

import com.module.JPA.entity.Department;
import com.module.JPA.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("depart")
public class DepartmentController {

    private DepartmentService departmentService;

    @GetMapping("departments")
    public List<Department> getDepartments() {
        return departmentService.getDepartments();
    }

    @PostMapping("saveDep")
    public Department insertDep(@RequestBody Department dep)
    {
        return departmentService.insertDep(dep);
    }
    @PostMapping("saveDeparts")
    public List<Department> insertDeparts(@RequestBody List<Department> departments){
        return departmentService.insertDeparts(departments);
    }


}
