package com.demo.conf;

import com.demo.dataobject.TaskEntity;
import com.demo.util.QuartzUtil;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 任务对象  我们需要通过此方法来反射执行任务类
 * @author 皇甫
 */
@DisallowConcurrentExecution
public class TaskObject implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        TaskEntity job = (TaskEntity)context.getJobDetail().getJobDataMap().get("job");
        QuartzUtil.invokeMethod(job);
    }
}
