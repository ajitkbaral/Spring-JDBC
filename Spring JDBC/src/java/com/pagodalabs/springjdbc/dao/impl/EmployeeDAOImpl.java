/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pagodalabs.springjdbc.dao.impl;

import com.pagodalabs.springjdbc.dao.EmployeeDAO;
import com.pagodalabs.springjdbc.entity.Employee;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Dell
 */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public EmployeeDAOImpl(){
    }

    @Override
    public List<Employee> showAll() {
        String sql="SELECT * FROM employee";
        return jdbcTemplate.query(sql, new RowMapper<Employee>() {

            @Override
            public Employee mapRow(ResultSet rs, int i) throws SQLException {
                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                return employee;
            }
        });
    }

    @Override
    public int insert(Employee employee) {
        String sql = "INSERT INTO employee(name) VALUES(?)";
        return jdbcTemplate.update(sql, new Object[]{employee.getName()});
    }

    @Override
    public Employee getById(int id) {
        String sql = "SELECT name FROM employee WHERE id = ?";
        return jdbcTemplate.query(sql, new Object[]{id}, new ResultSetExtractor<Employee>() {

            @Override
            public Employee extractData(ResultSet rs) throws SQLException, DataAccessException {
                if(rs.next()){
                    Employee employee = new Employee();
                employee.setName(rs.getString("name"));
                
                return employee;
                }
                return null;
            }
        });
    }
    
}
