package com.newcitysoft.springboot.controller;

import com.newcitysoft.springboot.entity.Response;
import com.newcitysoft.springboot.model.Dept;
import com.newcitysoft.springboot.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 *
 * RestController 返回json
 * Controller 返回页面
 *
 * @author lixin.tian@renren-inc.com
 * @date 2018/7/5 10:19
 */
@RestController
@RequestMapping("dept")
public class DeptController {

    @Autowired
    DeptService deptService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("deptList", deptService.getAll());

        modelAndView.setViewName("dept/index");

        return modelAndView;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Dept> list() {
        return deptService.getAll();
    }

    @RequestMapping(value = "/add", method = {RequestMethod.POST, RequestMethod.GET})
    public Response add(@Validated Dept dept, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldErrors().get(0);
            return Response.failure(fieldError.getDefaultMessage());
        } else {
            if(deptService.getByCode(dept.getCode()) != null) {
                return Response.failure("该编码的部门已存在！");
            } else {
                Dept add = deptService.add(dept);

                return Response.builder().status(200).msg("增加成功").data(add).build();
            }
        }
    }

    @RequestMapping(value = "/update", method = {RequestMethod.POST, RequestMethod.GET})
    public Response update(@Validated Dept dept, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldErrors().get(0);
            return Response.failure(fieldError.getDefaultMessage());
        } else {
            Dept update = deptService.update(dept);

            return Response.builder().status(200).msg("修改成功").data(update).build();
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Response delete(@RequestParam(name = "id", defaultValue = "0") Integer id) {
        deptService.delete(id);

        return Response.success();
    }
}
