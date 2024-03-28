package com.epam.rd.autocode.service.impl;

import com.epam.rd.autocode.dao.EmployeeDao;
import com.epam.rd.autocode.dao.impl.EmployeeDaoImpl;
import com.epam.rd.autocode.domain.Department;
import com.epam.rd.autocode.domain.Employee;
import com.epam.rd.autocode.service.EmployeeService;
import com.epam.rd.autocode.service.Paging;

import java.util.Comparator;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeDao employeeDao = new EmployeeDaoImpl();
    @Override
    public List<Employee> getAllSortByHireDate(Paging paging) {
        List<Employee> employees = employeeDao.getAll();
        employees.sort(Comparator.comparing(Employee::getHired));
        return getEmployeesSubList(employees, paging);
    }

    private List<Employee> getEmployeesSubList(List<Employee> employees, Paging paging) {
        int fromIndex = (paging.page - 1) * paging.itemPerPage;
        int toIndex = Math.min(fromIndex + paging.itemPerPage, employees.size());
        return employees.subList(fromIndex, toIndex);
    }

    @Override
    public List<Employee> getAllSortBySalary(Paging paging) {
        List<Employee> employees = employeeDao.getAll();
        employees.sort(Comparator.comparing(Employee::getSalary));
        return getEmployeesSubList(employees, paging);
    }

    @Override
    public List<Employee> getAllSortByLastname(Paging paging) {
        List<Employee> employees = employeeDao.getAll();
        employees.sort(Comparator.comparing(e -> e.getFullName().getLastName()));
        int fromIndex = (paging.page - 1) * paging.itemPerPage;
        int toIndex = Math.min(fromIndex + paging.itemPerPage, employees.size());
        return employees.subList(fromIndex, toIndex);
    }

    @Override
    public List<Employee> getAllSortByDepartmentNameAndLastname(Paging paging) {
        List<Employee> employees = employeeDao.getAll();
        employees.sort(Comparator.comparing(e -> e.getFullName().getLastName()));
        employees.sort((e1, e2) -> {
            if (e1.getDepartment() != null && e2.getDepartment() != null) {
                return e1.getDepartment().getName().compareTo(e2.getDepartment().getName());
            } else if (e1.getDepartment() == null) {
                return -1;
            } else {
                return 1;
            }
        });
        return getEmployeesSubList(employees, paging);
    }

    @Override
    public List<Employee> getByDepartmentSortByHireDate(Department department, Paging paging) {
        List<Employee> employees = employeeDao.getByDepartment(department);
        employees.sort(Comparator.comparing(Employee::getHired));
        return getEmployeesSubList(employees, paging);
    }

    @Override
    public List<Employee> getByDepartmentSortBySalary(Department department, Paging paging) {
        List<Employee> employees = employeeDao.getByDepartment(department);
        employees.sort(Comparator.comparing(Employee::getSalary));
        return getEmployeesSubList(employees, paging);
    }

    @Override
    public List<Employee> getByDepartmentSortByLastname(Department department, Paging paging) {
        List<Employee> employees = employeeDao.getByDepartment(department);
        employees.sort(Comparator.comparing(e -> e.getFullName().getLastName()));
        return getEmployeesSubList(employees, paging);
    }

    @Override
    public List<Employee> getByManagerSortByLastname(Employee manager, Paging paging) {
        List<Employee> employees = employeeDao.getByManager(manager);
        employees.sort(Comparator.comparing(e -> e.getFullName().getLastName()));
        return getEmployeesSubList(employees, paging);
    }

    @Override
    public List<Employee> getByManagerSortByHireDate(Employee manager, Paging paging) {
        List<Employee> employees = employeeDao.getByManager(manager);
        employees.sort(Comparator.comparing(Employee::getHired));
        return getEmployeesSubList(employees, paging);
    }

    @Override
    public List<Employee> getByManagerSortBySalary(Employee manager, Paging paging) {
        List<Employee> employees = employeeDao.getByManager(manager);
        employees.sort(Comparator.comparing(Employee::getSalary));
        return getEmployeesSubList(employees, paging);
    }

    @Override
    public Employee getWithDepartmentAndFullManagerChain(Employee employee) {
        return employeeDao.getByIdWithFullChain(employee.getId());
    }

    @Override
    public Employee getTopNthBySalaryByDepartment(int salaryRank, Department department) {
        List<Employee> employees = employeeDao.getByDepartment(department);
        employees.sort(Comparator.comparing(Employee::getSalary).reversed());
        int listIndex = salaryRank - 1;
        int lastIndex = employees.size() - 1;
        return employees.get(Math.min(listIndex, lastIndex));
    }
}
