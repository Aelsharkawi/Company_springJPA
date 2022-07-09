package com.module.JPA.repository;

import com.module.JPA.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department, String> {


}
