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

    @SuppressWarnings("unchecked")
    public void reset() {
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        EMPLOYEE_LIST = context.getBean("employeeList", ArrayList.class);
    }

    public void updateEmployee(Employee employee) throws com.cognizant.springlearn.service.exception.EmployeeNotFoundException {
        for (int i = 0; i < EMPLOYEE_LIST.size(); i++) {
            Employee emp = EMPLOYEE_LIST.get(i);
            if (emp.getId() == employee.getId()) {
                EMPLOYEE_LIST.set(i, employee);
                return;
            }
        }
        throw new com.cognizant.springlearn.service.exception.EmployeeNotFoundException("Employee not found");
    }

    public void deleteEmployee(int id) throws com.cognizant.springlearn.service.exception.EmployeeNotFoundException {
        Employee toRemove = null;
        for (Employee emp : EMPLOYEE_LIST) {
            if (emp.getId() == id) {
                toRemove = emp;
                break;
            }
        }
        if (toRemove != null) {
            EMPLOYEE_LIST.remove(toRemove);
        } else {
            throw new com.cognizant.springlearn.service.exception.EmployeeNotFoundException("Employee not found");
        }
    }
}
