package com.module.JPA.service;

import com.module.JPA.entity.Attendance;
import com.module.JPA.repository.AttendanceRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepo attendanceRepo;
    //Add attendance
    public Attendance addAttendance(Attendance attend){

        attend.setStatus(attend.isStatus());
        attend.setDate(attend.getDate());
        attend.setEmployee(attend.getEmployee());
        return attendanceRepo.save(attend);
    }
    //get attendance of employee
    public List<Attendance> getEmpAttendanceByID(Long id){

        return attendanceRepo.getEmpAttendanceByID(id);
    }

    // to get attendance of day
    public List<Attendance> getAttendanceByDate(LocalDate date){
        final var attendList = attendanceRepo.findByDate(date);
        return attendList;
    }

    // Get attendance by status
    public List<Attendance> findByStatus(Boolean status){
        return attendanceRepo.findByStatus(status);
    }






}
