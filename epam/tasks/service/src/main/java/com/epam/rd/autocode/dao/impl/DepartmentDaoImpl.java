package com.epam.rd.autocode.dao.impl;

import com.epam.rd.autocode.ConnectionSource;
import com.epam.rd.autocode.dao.DepartmentDao;
import com.epam.rd.autocode.domain.Department;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao {
    private static final String SELECT_DEPARTMENT_BY_ID = "SELECT * FROM DEPARTMENT WHERE id = ?";
    private static final String SELECT_ALL_DEPARTMENTS = "SELECT * FROM DEPARTMENT";
    private static final String INSERT_DEPARTMENT = "INSERT INTO DEPARTMENT(ID, NAME, LOCATION) VALUES (?, ?, ?)";
    private static final String UPDATE_DEPARTMENT = "UPDATE DEPARTMENT SET NAME = ?, LOCATION = ? WHERE ID = ?";
    private static final String DELETE_DEPARTMENT = "DELETE FROM DEPARTMENT WHERE ID = ?";
    @Override
    public Department getById(BigInteger id) {
        Department department = null;
        try (Connection connection = ConnectionSource.instance().createConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_DEPARTMENT_BY_ID)) {

            statement.setLong(1, id.longValue());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                department = createDepartment(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return department;
    }

    private Department createDepartment(ResultSet resultSet) throws SQLException {
        return new Department(BigInteger.valueOf(resultSet.getLong("ID")),
                resultSet.getString("NAME"),
                resultSet.getString("LOCATION"));
    }

    @Override
    public List<Department> getAll() {
        List<Department> departments = new ArrayList<>();
        try (Connection connection = ConnectionSource.instance().createConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_DEPARTMENTS)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                departments.add(createDepartment(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departments;
    }

    @Override
    public Department save(Department department) {
        if (getById(department.getId()) != null) {
            updateDepartment(department);
        } else {
            insertDepartment(department);
        }
        return department;
    }

    private void updateDepartment(Department department) {
        try (Connection connection = ConnectionSource.instance().createConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_DEPARTMENT)) {
            statement.setString(1, department.getName());
            statement.setString(2, department.getLocation());
            statement.setLong(3, department.getId().longValue());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertDepartment(Department department) {
        try (Connection connection = ConnectionSource.instance().createConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_DEPARTMENT)) {
            statement.setLong(1, department.getId().longValue());
            statement.setString(2, department.getName());
            statement.setString(3, department.getLocation());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Department department) {
        try (Connection connection = ConnectionSource.instance().createConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_DEPARTMENT)) {
            statement.setLong(1, department.getId().longValue());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
