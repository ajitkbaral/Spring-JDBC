/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pagodalabs.springjdbc.dao;

import com.pagodalabs.springjdbc.entity.Employee;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface EmployeeDAO {
    
        public List<Employee> showAll();
        public int insert(Employee employee);
        public Employee getById(int id);
}
