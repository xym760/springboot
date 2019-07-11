package com.nxist.springboot.controller;

import com.nxist.springboot.dao.DepartmentDao;
import com.nxist.springboot.dao.EmployeeDao;
import com.nxist.springboot.entities.Department;
import com.nxist.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    DepartmentDao departmentDao;

    //查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        //将查询结果放到请求域中进行共享
        model.addAttribute("emps", employees);
        //thymeleaf默认就会拼串（classpath:/templates/xxx.html）
        return "emp/list";
    }

    //来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model) {
        //来到添加页面，查出所有的部门，在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    //员工添加
    //SpringMVC自动将请求参数和入参对象的属性进行一一绑定；要求请求参数的名字和javabean入参的对象里面的属性名对应
    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        //添加完后，来到员工列表页面
        System.out.println("保存的员工信息：" + employee);
        employeeDao.save(employee);
        //redirect:表示重定向到一个地址   /代表当前项目路径
        //forward:代表转发到一个地址
        return "redirect:/emps";
    }

    /**
     * 来到修改页面，查出当前员工，在页面回显
     *
     * @return
     */
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        //回到修改页面(直接重用添加页面，把它当做编辑页面使用)
        return "emp/add";
    }

    //员工修改
    @PutMapping("/emp")
    public String updateEmployee(Employee employee) {
        System.out.println("修改的员工数据：" + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //员工删除
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
