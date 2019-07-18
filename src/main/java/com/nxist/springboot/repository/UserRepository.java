package com.nxist.springboot.repository;

import com.nxist.springboot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 继承JpaRepository（泛型中第一个参数是实体类名，第二个参数是主键类型），来完成对数据库的操作
 * @Author: xym760
 * @Date: 2019/7/18 16:47
 * @Description:
 */
public interface UserRepository extends JpaRepository<User,Integer> {
}
