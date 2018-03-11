package pl.isa.raportmodule.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.isa.raportmodule.raportCreator.LogCalculator;
import pl.isa.raportmodule.repository.AdminPreferencesRepository;
import pl.isa.raportmodule.repository.LogRepository;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.*;
import javax.inject.Inject;

@Singleton
@Startup
@LocalBean
public class TimerSessionBean {
    @Inject
    LogRepository logRepository;
    @Inject
    AdminPreferencesRepository adminPreferencesRepository;
    @Resource
    TimerService timerService;


    private Logger logger = LoggerFactory.getLogger(TimerSessionBean.class);

//    @PostConstruct
//    private void init() {
//        timerService.createCalendarTimer(new ScheduleExpression().dayOfWeek("*").second("0"));
//    }

    @Schedule(hour = "*", minute = "*/2", second = "0", persistent = false)
    public void execute(Timer timer) {
        LogCalculator logCalculator = new LogCalculator();
        logger.info(logCalculator.buildRaport(logRepository, adminPreferencesRepository));
            logger.info("raport send");
    }

}