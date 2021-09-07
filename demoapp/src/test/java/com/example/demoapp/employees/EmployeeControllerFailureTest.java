package com.example.demoapp.employees;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerFailureTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    @DisplayName("error 404, employee id = 1 not found")
    public void case01() {
        //Arrange
        int id = 1;
        //Act
        ResponseEntity<ErrorResponse> result
                = restTemplate.getForEntity("/employees/" +id, ErrorResponse.class);
        //Assert
        assertEquals(404, result.getStatusCodeValue());
//        assertEquals("Employee not found id=1",result.getDetail());
    }
}
