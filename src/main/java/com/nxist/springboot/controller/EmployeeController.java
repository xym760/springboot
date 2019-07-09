package com.nxist.springboot.controller;

import com.nxist.springboot.dao.EmployeeDao;
import com.nxist.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

/**
 * @Author: xym760
 * @Date: 2019/7/9 15:16
 * @Description:
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    //查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        //将查询结果放到请求域中进行共享
        model.addAttribute("emps", employees);
        //thymeleaf默认就会拼串（classpath:/templates/xxx.html）
        return "emp/list";
    }
}
