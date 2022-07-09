package com.module.JPA.service;

import com.module.JPA.entity.Department;
import com.module.JPA.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    public List<Department> getDepartments(){
        return departmentRepo.findAll();
    }
    public Department insertDep(Department dep) {
        return departmentRepo.save(dep);
    }

    public List<Department> insertDeparts(List<Department> departments){
        return departmentRepo.saveAll(departments);
    }

}
