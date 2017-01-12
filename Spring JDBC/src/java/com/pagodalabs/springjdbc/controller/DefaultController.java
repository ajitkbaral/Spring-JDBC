/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pagodalabs.springjdbc.controller;

import com.pagodalabs.springjdbc.dao.EmployeeDAO;
import com.pagodalabs.springjdbc.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Dell
 */
@Controller
public class DefaultController {
    @Autowired
    private EmployeeDAO employeeDAO;
    
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView defaultPage(ModelMap map){
        ModelAndView mv = new ModelAndView();
        map.addAttribute("employees", employeeDAO.showAll());
        mv.setViewName("default");
        return mv;
    }
    
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(){
        return "index";
    }
    
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(ModelMap map){
        map.addAttribute("employee", employeeDAO.getById(4));
        return "hello";
    }
    
}
