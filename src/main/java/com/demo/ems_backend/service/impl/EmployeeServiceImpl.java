package com.demo.ems_backend.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.demo.ems_backend.dto.EmployeeDto;
import com.demo.ems_backend.entity.Employee;
import com.demo.ems_backend.exceptions.ResourceNotFoundException;
import com.demo.ems_backend.mapper.EmployeeMapper;
import com.demo.ems_backend.repository.EmployeeRepository;
import com.demo.ems_backend.service.EmployeeService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
   private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee=EmployeeMapper.mapToEmployee(employeeDto);
        Employee savEmployee=   employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savEmployee);
    }


    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
     Employee savedEmployee=   employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee not Found with the given id "+employeeId) );
     return EmployeeMapper.mapToEmployeeDto(savedEmployee);

    }


    @Override
    public List<EmployeeDto> getAllEmployees() {
       List<Employee> employees= employeeRepository.findAll();
       return employees.stream().map((employee)->EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
   
        
    }
}
