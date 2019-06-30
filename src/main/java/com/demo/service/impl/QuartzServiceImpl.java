package com.demo.service.impl;

import com.demo.dao.TaskDao;
import com.demo.dataobject.TaskEntity;
import com.demo.service.QuartzService;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 皇甫
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class QuartzServiceImpl implements QuartzService {
    @Autowired
    private TaskDao taskDao;
    @Autowired
    private Scheduler scheduler;
    private final String STOP = "STOP";
    private final String START = "START";

    /**
     * 查询所有
     * @return
     */
    @Override
    public List<TaskEntity> findAll() {
        return taskDao.findAll();
    }

    /**
     * 数据库添加一个任务
     * @param taskEntity
     */
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
    @Override
    public void addJob(TaskEntity taskEntity) {
        taskDao.save(taskEntity);
    }

    /**
     * 数据库根据Id查询一个任务详情
     * @param id
     * @return
     */
    @Override
    public TaskEntity findOneById(String id) {
        return taskDao.findById(id).get();
    }

    /**
     * 停止开始运行任务
     * @param jobId
     * @param cmd 操作类型  stop停止  start开始
     */
    @Override
    public void changeJobStatus(String jobId, String cmd) throws SchedulerException {
        TaskEntity oneById = findOneById(jobId);
        if(oneById == null){
            return;
        }
        //停止
        if(STOP.equals(cmd)){
            //定位任务
            JobKey jobKey = JobKey.jobKey(oneById.getJobName(), oneById.getJobGroup());
            //停止任务
            oneById.setJobStatus(TaskEntity.STATUS_NOT_RUNNING);
            scheduler.deleteJob(jobKey);
        }else if(START.equals(cmd)){
            //开始一个任务
            oneById.setJobStatus(TaskEntity.STATUS_RUNNING);
            //重新开始  添加一个任务
            addJob(oneById);

        }else{
            return;
        }
        //将修改信息保存再数据库
        taskDao.save(oneById);
    }

    /**
     * 修改任务运行信息 cron
     * @param id
     * @param cron
     */
    @Override
    public void updateJobCron(String id, String cron) throws SchedulerException {
        TaskEntity job = findOneById(id);
        if(job == null){
            return;
        }
        //开始修改运行周期
        job.setCronExpression(cron);

        //判断任务是否再运行中 如果是运行中就执行job修改 如果没有运行则只执行修改数据库即可
        if(TaskEntity.STATUS_RUNNING.equals(job.getJobStatus())){
            //精确任务
            TriggerKey triggerKey = TriggerKey.triggerKey(job.getJobName(), job.getJobGroup());
            //获取这个任务的触发器
            CronTrigger trigger = (CronTrigger)scheduler.getTrigger(triggerKey);
            //设置新的定时器
            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
            //给触发器绑定新的定时任务
            trigger = trigger.getTriggerBuilder()
                    .withSchedule(cronScheduleBuilder)
                    .withIdentity(triggerKey)
                    .build();
            //绑定定时器和触发器
            scheduler.rescheduleJob(triggerKey, trigger);

        }
    }

    @Override
    public void addTask(TaskEntity taskEntity) {

    }

    @Override
    public void pauseJob(TaskEntity taskEntity) {

    }

    @Override
    public void resumeJob(TaskEntity taskEntity) {

    }

    @Override
    public void runAJobNow(TaskEntity taskEntity) {

    }
}
