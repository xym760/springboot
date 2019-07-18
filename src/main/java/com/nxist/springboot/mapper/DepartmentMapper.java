package com.nxist.springboot.mapper;

import com.nxist.springboot.entities.Department;
import org.apache.ibatis.annotations.*;

/**
 * 指定这是一个操作数据库的mapper
 * @Author: xym760
 * @Date: 2019/7/18 11:41
 * @Description:
 */
//@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    public Department getDeptById(Integer id);

    @Delete("delete form  department where id=#{id}")
    public int deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(department_name) values(#{departmentName})")
    public int insertDept(Department department);

    @Update("update department set department_name=#{departmentName} where id=#{id}")
    public int updateDept(Department department);
}
