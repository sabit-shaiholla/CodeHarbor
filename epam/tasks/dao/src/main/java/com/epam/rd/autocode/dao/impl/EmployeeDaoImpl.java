package com.epam.rd.autocode.dao.impl;

import com.epam.rd.autocode.ConnectionSource;
import com.epam.rd.autocode.dao.EmployeeDao;
import com.epam.rd.autocode.domain.Department;
import com.epam.rd.autocode.domain.Employee;
import com.epam.rd.autocode.domain.FullName;
import com.epam.rd.autocode.domain.Position;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeDaoImpl implements EmployeeDao {
    private static final String SELECT_EMPLOYEE_BY_ID = "SELECT * FROM EMPLOYEE WHERE id = ?";
    private static final String SELECT_ALL_EMPLOYEES = "SELECT * FROM EMPLOYEE";
    private static final String INSERT_EMPLOYEE = "INSERT INTO EMPLOYEE(ID, FIRSTNAME, LASTNAME, MIDDLENAME, POSITION, HIREDATE, SALARY, MANAGER, DEPARTMENT) "
                                                +" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_EMPLOYEE = "UPDATE EMPLOYEE SET "
                                                + "FIRSTNAME = ?, LASTNAME = ?, MIDDLENAME = ?, "
                                                + "POSITION = ?, HIREDATE = ?, SALARY = ?, "
                                                + "MANAGER = ?, DEPARTMENT = ? "
                                                + "WHERE ID = ?";
    private static final String DELETE_EMPLOYEE = "DELETE FROM EMPLOYEE WHERE ID = ?";
    private static final String SELECT_EMPLOYEES_BY_DEPARTMENT = "SELECT * FROM EMPLOYEE WHERE DEPARTMENT = ?";
    private static final String SELECT_EMPLOYEES_BY_MANAGER = "SELECT * FROM EMPLOYEE WHERE MANAGER = ?";
    @Override
    public Optional<Employee> getById(BigInteger id) {
        Optional<Employee> employee = Optional.empty();
        try (Connection connection = ConnectionSource.instance().createConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID)) {

            statement.setLong(1, id.longValue());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                employee = Optional.of(createEmployee(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    private Employee createEmployee(ResultSet resultSet) throws SQLException {
        return new Employee(BigInteger.valueOf(resultSet.getLong("id")),
                getEmployeeFullName(resultSet),
                Position.valueOf(resultSet.getString("POSITION").toUpperCase()),
                resultSet.getDate("HIREDATE").toLocalDate(),
                resultSet.getBigDecimal("SALARY"),
                BigInteger.valueOf(resultSet.getLong("MANAGER")),
                BigInteger.valueOf(resultSet.getLong("DEPARTMENT")));
    }

    private FullName getEmployeeFullName(ResultSet resultSet) throws SQLException {
        return new FullName(resultSet.getString("FIRSTNAME"),
                resultSet.getString("LASTNAME"),
                resultSet.getString("MIDDLENAME"));
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = ConnectionSource.instance().createConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_EMPLOYEES)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                employees.add(createEmployee(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public Employee save(Employee employee) {
        if (getById(employee.getId()).isPresent()) {
            updateEmployee(employee);
        } else {
            insertEmployee(employee);
        }
        return employee;
    }

    private void updateEmployee(Employee employee) {
        try (Connection connection = ConnectionSource.instance().createConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEE)) {
            statement.setString(1, employee.getFullName().getFirstName());
            statement.setString(2, employee.getFullName().getLastName());
            statement.setString(3, employee.getFullName().getMiddleName());
            statement.setString(4, employee.getPosition().name());
            statement.setDate(5, java.sql.Date.valueOf(employee.getHired()));
            statement.setBigDecimal(6, employee.getSalary());
            statement.setLong(7, employee.getManagerId().longValue());
            statement.setLong(8, employee.getDepartmentId().longValue());
            statement.setLong(9, employee.getId().longValue());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertEmployee(Employee employee) {
        try (Connection connection = ConnectionSource.instance().createConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_EMPLOYEE)) {
            statement.setLong(1, employee.getId().longValue());
            statement.setString(2, employee.getFullName().getFirstName());
            statement.setString(3, employee.getFullName().getLastName());
            statement.setString(4, employee.getFullName().getMiddleName());
            statement.setString(5, employee.getPosition().name());
            statement.setDate(6, java.sql.Date.valueOf(employee.getHired()));
            statement.setBigDecimal(7, employee.getSalary());
            statement.setLong(8, employee.getManagerId().longValue());
            statement.setLong(9, employee.getDepartmentId().longValue());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Employee employee) {
        try (Connection connection = ConnectionSource.instance().createConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEE)) {
            statement.setLong(1, employee.getId().longValue());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> getByDepartment(Department department) {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = ConnectionSource.instance().createConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_EMPLOYEES_BY_DEPARTMENT)) {
            statement.setLong(1, department.getId().longValue());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                employees.add(createEmployee(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public List<Employee> getByManager(Employee employee) {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = ConnectionSource.instance().createConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_EMPLOYEES_BY_MANAGER)) {
            statement.setLong(1, employee.getId().longValue());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                employees.add(createEmployee(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
