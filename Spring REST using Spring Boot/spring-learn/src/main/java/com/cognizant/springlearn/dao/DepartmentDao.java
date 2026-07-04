package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.Department;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Hands-on 3: Department DAO class
 */
@Repository
public class DepartmentDao {

    private static ArrayList<Department> DEPARTMENT_LIST;

    @SuppressWarnings("unchecked")
    public DepartmentDao() {
        // Load the departmentList bean from xml config
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        DEPARTMENT_LIST = context.getBean("departmentList", ArrayList.class);
    }

    public ArrayList<Department> getAllDepartments() {
        return DEPARTMENT_LIST;
    }
}
