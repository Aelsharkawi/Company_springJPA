package com.module.JPA.repository;

import com.module.JPA.entity.Attendance;
import com.module.JPA.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    //Native Query to get Employees related to specific department
    @Query(value = "select * from employee emp where emp.department_name=?1", nativeQuery = true)
    List<Employee> findByDepartmentName(String name);

    //Native Query to get employees with salary
    @Query(value = "select * from employee emp where emp.salary=?",nativeQuery = true)
    List<Employee> findEmpBySalary(Double salary);


}
