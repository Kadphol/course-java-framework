package com.example.demoapp.employees;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getEmployeeById() {
        // Arrange
        int id = 100;
        // Act
        EmployeeResponse result
                = restTemplate.getForObject("/employees/" + id, EmployeeResponse.class);
        // Assert
        assertEquals(id, result.getId());
        assertEquals("somkiat", result.getName());
    }

    @Test
    public void listEmployee() {
        // Act
        EmployeeResponse[] results
                = restTemplate.getForObject("/employees", EmployeeResponse[].class);
        // Assert
        assertEquals(2, results.length);
        assertEquals(1, results[0].getId());
        assertEquals("somkiat", results[0].getName());
    }

}