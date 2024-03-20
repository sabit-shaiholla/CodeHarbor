package com.epam.rd.autocode.dao;

import com.epam.rd.autocode.dao.impl.DepartmentDaoImpl;
import com.epam.rd.autocode.dao.impl.EmployeeDaoImpl;

public class DaoFactory {
    public EmployeeDao employeeDAO() {
        return new EmployeeDaoImpl();
    }

    public DepartmentDao departmentDAO() {
        return new DepartmentDaoImpl();
    }
}
