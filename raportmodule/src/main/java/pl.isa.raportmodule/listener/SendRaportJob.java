package pl.isa.raportmodule.listener;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import pl.isa.raportmodule.raportCreator.LogCalculator;
import pl.isa.raportmodule.repository.AdminPreferencesRepository;
import pl.isa.raportmodule.repository.LogRepository;

import javax.inject.Inject;

public class SendRaportJob implements Job {
    @Inject
    LogRepository logRepository;
    @Inject
    AdminPreferencesRepository adminPreferencesRepository;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LogCalculator logCalculator = new LogCalculator();
        String raport = logCalculator.buildRaport(logRepository, adminPreferencesRepository);
    }
}
