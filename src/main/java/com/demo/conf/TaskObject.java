package com.demo.conf;

import com.demo.dataobject.TaskEntity;
import com.demo.util.QuartzUtil;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
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
