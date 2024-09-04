package com.demo.ems_backend.service;

import java.util.List;

import com.demo.ems_backend.dto.EmployeeDto;

public interface EmployeeService {
  EmployeeDto createEmployee(EmployeeDto employeeDto);
  EmployeeDto getEmployeeById(Long employeeId);
  List<EmployeeDto> getAllEmployees();
}
