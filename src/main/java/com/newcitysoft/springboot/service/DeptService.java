package com.newcitysoft.springboot.service;

import com.newcitysoft.springboot.dao.DeptDao;
import com.newcitysoft.springboot.model.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/7/5 10:15
 */
@Service
@CacheConfig(cacheNames = "DeptService")
public class DeptService {

    @Autowired
    DeptDao deptDao;

    @Cacheable
    public List<Dept> getAll() {
        return deptDao.findAll();
    }

    public Dept getById(int id) {
        return deptDao.findOne(id);
    }

    public Dept getByCode(String code) {
        return deptDao.findByCode(code);
    }

    @Async
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public Dept add(Dept dept) {
        return deptDao.save(dept);
    }

    @Async
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public Dept update(Dept dept) {
        return deptDao.saveAndFlush(dept);
    }

    @Async
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public void delete(int id) {
        deptDao.delete(id);
    }
}
