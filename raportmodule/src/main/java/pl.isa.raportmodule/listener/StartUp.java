package pl.isa.raportmodule.listener;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class StartUp implements ServletContextListener {

    private org.slf4j.Logger logger = LoggerFactory.getLogger(StartUp.class.getName());

    public void contextInitialized(ServletContextEvent e) {
        try {
            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();
            JobDetail jobDetail = newJob(SendRaportJob.class)
                    .withIdentity("sendRaportJob", "group1").build();

            Trigger trigger = newTrigger()
                    .withIdentity("trigger", "group1")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInSeconds(10)
                            .repeatForever())
                    .build();

            scheduler.scheduleJob(jobDetail, trigger);

        } catch (SchedulerException e1) {
            e1.printStackTrace();
        }
    }





    public void contextDestroyed(ServletContextEvent e) {

    }
}