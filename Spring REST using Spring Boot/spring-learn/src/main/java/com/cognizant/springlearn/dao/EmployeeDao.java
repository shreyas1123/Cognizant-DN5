package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Hands-on 3: Employee DAO class
 */
@Repository
public class EmployeeDao {

    private static ArrayList<Employee> EMPLOYEE_LIST;

    @SuppressWarnings("unchecked")
    public EmployeeDao() {
        // Load the employeeList bean from xml config
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        EMPLOYEE_LIST = context.getBean("employeeList", ArrayList.class);
    }

    public ArrayList<Employee> getAllEmployees() {
        return EMPLOYEE_LIST;
    }
}
