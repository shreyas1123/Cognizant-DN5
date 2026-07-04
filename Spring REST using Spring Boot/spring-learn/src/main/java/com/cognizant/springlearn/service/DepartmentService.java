package com.cognizant.springlearn.service;

import com.cognizant.springlearn.Department;
import com.cognizant.springlearn.dao.DepartmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Hands-on 3: Department Service class
 */
@Service
public class DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    public ArrayList<Department> getAllDepartments() {
        return departmentDao.getAllDepartments();
    }
}
