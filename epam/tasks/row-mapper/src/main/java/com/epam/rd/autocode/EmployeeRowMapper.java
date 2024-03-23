package com.epam.rd.autocode;

import com.epam.rd.autocode.domain.Employee;
import com.epam.rd.autocode.domain.FullName;
import com.epam.rd.autocode.domain.Position;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class EmployeeRowMapper implements RowMapper<Employee>{

    @Override
    public Employee mapRow(ResultSet resultSet) {
        try {
            BigInteger id = BigInteger.valueOf(resultSet.getInt("ID"));
            String firstName = resultSet.getString("FIRSTNAME");
            String lastName = resultSet.getString("LASTNAME");
            String middleName = resultSet.getString("MIDDLENAME");
            Position position = Position.valueOf(resultSet.getString("POSITION"));
            LocalDate localDate = resultSet.getDate("HIREDATE").toLocalDate();
            BigDecimal salary = resultSet.getBigDecimal("SALARY");

            return new Employee(id,
                    new FullName(firstName, lastName, middleName),
                    position,
                    localDate,
                    salary);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
