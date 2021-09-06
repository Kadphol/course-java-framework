package com.example.demoapp.employees;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    public EmployeeResponse getById(String id) {
        EmployeeResponse response = new EmployeeResponse();
        response.setId(Integer.parseInt(id));
        response.setName("somkiat");
        return response;
    }
}
