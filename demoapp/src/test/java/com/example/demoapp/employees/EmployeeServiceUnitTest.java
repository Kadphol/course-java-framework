package com.example.demoapp.employees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeServiceUnitTest {

    @Test
    public void getById() {
        //Arrange
        EmployeeService employeeService = new EmployeeService();
        //Act
        EmployeeResponse result = employeeService.getById(1);
        //Assert
        assertEquals(1, result.getId());
        assertEquals("Mock name", result.getName());
    }
}
