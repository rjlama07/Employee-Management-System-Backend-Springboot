package com.demo.ems_backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.ems_backend.dto.EmployeeDto;
import com.demo.ems_backend.entity.Employee;
import com.demo.ems_backend.service.EmployeeService;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    //Build App Employee REST API
    @PostMapping("/createEmployee")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
      try{
    
        EmployeeDto savedEmployee=  employeeService.createEmployee(employeeDto);
        System.out.println("EmployeeController.createEmployee(222)"+employeeDto);
        return new ResponseEntity<>(savedEmployee,HttpStatus.CREATED);
      }
        catch(Exception e){
            System.err.println(e);
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Build getEmployee Rest Api 
    @GetMapping("/getEmployeeById/{id}")

     public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
      EmployeeDto employeeDto =  employeeService.getEmployeeById(employeeId);
      return  ResponseEntity.ok(employeeDto);


     }
    
    
}
