package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Hands-on 3: Employee REST Controller
 */
@RestController
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public ArrayList<Employee> getAllEmployees() {
        LOGGER.info("START getAllEmployees - Request received");
        ArrayList<Employee> list = employeeService.getAllEmployees();
        LOGGER.info("END getAllEmployees");
        return list;
    }

    @org.springframework.web.bind.annotation.PutMapping("/employees")
    public void updateEmployee(@org.springframework.web.bind.annotation.RequestBody @jakarta.validation.Valid Employee employee) throws com.cognizant.springlearn.service.exception.EmployeeNotFoundException {
        LOGGER.info("START updateEmployee");
        LOGGER.info("Updating employee: {}", employee);
        employeeService.updateEmployee(employee);
        LOGGER.info("END updateEmployee");
    }

    @org.springframework.web.bind.annotation.DeleteMapping("/employees/{id}")
    public void deleteEmployee(@org.springframework.web.bind.annotation.PathVariable int id) throws com.cognizant.springlearn.service.exception.EmployeeNotFoundException {
        LOGGER.info("START deleteEmployee");
        LOGGER.info("Deleting employee with ID: {}", id);
        employeeService.deleteEmployee(id);
        LOGGER.info("END deleteEmployee");
    }
}
