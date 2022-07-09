package com.module.JPA.controller;

import com.module.JPA.entity.Attendance;
import com.module.JPA.service.AttendanceService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("attend")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;
    // Add attendance
    @PostMapping("addAttend")
    public void addAttend(@RequestBody Attendance attendance){
        attendanceService.addAttendance(attendance);
    }

    //to get attendance for specific employee
    @GetMapping("getAttend/{id}")
    public List<Attendance> getAttend(@PathVariable Long id){

        return  attendanceService.getEmpAttendanceByID(id);
    }

    // to get attendance of day
    @GetMapping("empAttend")
    public List<Attendance> getAttendanceByDate(@RequestParam String stringDate) {
        //to convert string to date
        LocalDate date = LocalDate.parse(stringDate);
        return attendanceService.getAttendanceByDate(date);
    }

    // get attendance by status
    @GetMapping("attendStatus")
    public List<Attendance> findByStatus(@RequestParam Boolean status){
        return attendanceService.findByStatus(status);
    }




}