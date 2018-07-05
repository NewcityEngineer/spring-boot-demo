package com.newcitysoft.springboot.dao;

import com.newcitysoft.springboot.model.Dept;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/7/2 15:41
 */
public interface DeptDao extends JpaRepository<Dept, Integer> {

    /**
     * 根据部门编码查询部门
     *
     * @param code
     * @return
     */
    Dept findByCode(String code);
}
