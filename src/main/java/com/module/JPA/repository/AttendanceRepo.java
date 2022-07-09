package com.module.JPA.repository;

import com.module.JPA.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;


public interface AttendanceRepo extends JpaRepository<Attendance, Long> {

    //Native Query to get attendance for specific employee
    @Query(value = "select * from Attendance att where att.Employee_ID =?1", nativeQuery = true)
    public List<Attendance> getEmpAttendanceByID(Long id);

    public List<Attendance> findByDate(LocalDate date);

    public List<Attendance> findByStatus(Boolean status);
}
