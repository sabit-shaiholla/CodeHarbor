package com.epam.rd.autocode.service;

import com.epam.rd.autocode.service.impl.EmployeeServiceImpl;

public class ServiceFactory {

    public EmployeeService employeeService(){
        return new EmployeeServiceImpl();
    }
}
