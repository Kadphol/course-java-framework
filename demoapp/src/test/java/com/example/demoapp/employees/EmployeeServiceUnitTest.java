package com.example.demoapp.employees;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceUnitTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Test
    @DisplayName("Success case")
    public void case01() {
        //Arrange
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Mock");
        when(employeeRepository.findById(1)).thenReturn(Optional.of(employee));
        EmployeeService employeeService = new EmployeeService(employeeRepository);
        //Act
        EmployeeResponse result = employeeService.getById(1);
        //Assert
        assertEquals(1, result.getId());
        assertEquals("Mock", result.getName());
    }

    @Test
    @DisplayName("Fail case : Employee not found")
    public void case02() {
        String message = null;
        when(employeeRepository.findById(100)).thenReturn(Optional.empty());
        EmployeeService employeeService = new EmployeeService(employeeRepository);

        try {
            EmployeeResponse result = employeeService.getById(100);
            fail();
        } catch(EmployeeNotFoundException e) {
            if(!"Employee not found id=100".equals(e.getMessage())) {
                fail("Message fail with = " + e.getMessage());
            }
        }
    }

}
