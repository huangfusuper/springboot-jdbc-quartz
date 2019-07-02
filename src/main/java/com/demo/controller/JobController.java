package com.demo.controller;

import com.demo.dataobject.TaskEntity;
import com.demo.service.QuartzService;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

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

    /**
     * 添加一个任务
     * @param job
     */
    @RequestMapping("addDbJob.do")
    @ResponseBody
    public Object addDbJob(TaskEntity job){
        quartzService.addJob(job);
        Map<String,Object> hashMap = new HashMap<String,Object>();
        hashMap.put("code","000");
        hashMap.put("msg","成功");
        return hashMap;
    }

    /**
     * 改变任务状态
     * @param id
     * @param cmd
     */
    @RequestMapping("changeJobStatus.do")
    @ResponseBody
    public Object changeJobStatus(@RequestParam("id") String id,@RequestParam("cmd") String cmd){
        Map<String,Object> hashMap = new HashMap<String,Object>();
        try {
            quartzService.changeJobStatus(id, cmd);
            hashMap.put("code","000");
            hashMap.put("msg","成功");
        } catch (SchedulerException e) {
            e.printStackTrace();
            hashMap.put("code","1000");
            hashMap.put("msg","失败");
        }
        return hashMap;
    }

    /**
     * 更改任务运行周期
     * @param id
     * @param cron
     */
    @RequestMapping("updateJobCron.do")
    @ResponseBody
    public Object updateJobCron(@RequestParam("id") String id,@RequestParam("cron") String cron){
        Map<String,Object> hashMap = new HashMap<String,Object>();
        try {
            quartzService.updateJobCron(id, cron);
            hashMap.put("code","000");
            hashMap.put("msg","成功");
        } catch (SchedulerException e) {
            e.printStackTrace();
            hashMap.put("code","1000");
            hashMap.put("msg","失败");
        }
        return hashMap;
    }

    /**
     * 增加一个任务
     * @param id
     * @return
     */
    @RequestMapping("addTask.do")
    @ResponseBody
    public Object addTask(String id){
        Map<String,Object> hashMap = new HashMap<String,Object>();
        try {
            quartzService.addTask(id);
            hashMap.put("code","000");
            hashMap.put("msg","成功");
        } catch (SchedulerException e) {
            e.printStackTrace();
            hashMap.put("code","1000");
            hashMap.put("msg","失败");
        }
        return hashMap;
    }
    @ResponseBody
    @RequestMapping("pauseJob.do")
    public Object pauseJob(String id){
        Map<String,Object> hashMap = new HashMap<String,Object>();
        try {
            quartzService.pauseJob(id);
            hashMap.put("code","000");
            hashMap.put("msg","成功");
        } catch (SchedulerException e) {
            e.printStackTrace();
            hashMap.put("code","1000");
            hashMap.put("msg","失败");
        }
        return hashMap;
    }

    /**
     * 恢复任务
     * @param id
     */
    @ResponseBody
    @RequestMapping("resumeJob.do")
    public Object resumeJob(String id){
        Map<String,Object> hashMap = new HashMap<String,Object>();
        try {
            quartzService.resumeJob(id);
            hashMap.put("code","000");
            hashMap.put("msg","成功");
        } catch (SchedulerException e) {
            e.printStackTrace();
            hashMap.put("code","1000");
            hashMap.put("msg","失败");
        }
        return hashMap;
    }
    @RequestMapping("runAJobNow.do")
    @ResponseBody
    public Object runAJobNow(String id){
        Map<String,Object> hashMap = new HashMap<String,Object>();
        try {
            quartzService.runAJobNow(id);
            hashMap.put("code","000");
            hashMap.put("msg","成功");
        } catch (SchedulerException e) {
            e.printStackTrace();
            hashMap.put("code","1000");
            hashMap.put("msg","失败");
        }
        return hashMap;
    }

}
