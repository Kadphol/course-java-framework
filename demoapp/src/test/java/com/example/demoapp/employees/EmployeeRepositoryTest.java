package com.example.demoapp.employees;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    @DisplayName("ค้นหาข้อมูลสำเร็จ id = 1")
    public void case01() {
        // Arrange
        Employee employee100 = new Employee();
        employee100.setName("Mock name");
        employeeRepository.save(employee100);
        // Act
        Optional<Employee> result = employeeRepository.findById(1);
        // Assert
        assertTrue(result.isPresent());
        assertEquals(1, result.get().getId());
        assertEquals("Mock name", result.get().getName());
    }


}