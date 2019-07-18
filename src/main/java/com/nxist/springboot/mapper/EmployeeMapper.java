package com.nxist.springboot.mapper;

import com.nxist.springboot.entities.Employee;

/**
 * 此Mapper必须使用@Mapper或者@MapperScan将接口扫描装配到容器中
 * @Author: xym760
 * @Date: 2019/7/18 14:52
 * @Description:
 */
public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public void insertEmp(Employee employee);
}
