package com.demo.controller;

import com.demo.dataobject.TaskEntity;
import com.demo.service.QuartzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 皇甫
 */
@Controller
public class JobController {
    @Autowired
    private QuartzService quartzService;

    @RequestMapping("findAll.html")
    public ModelAndView findAll(ModelAndView modelAndView){
        List<TaskEntity> all = quartzService.findAll();
        modelAndView.addObject("all", all);
        modelAndView.setViewName("/quartzs");
        return modelAndView;
    }
}
