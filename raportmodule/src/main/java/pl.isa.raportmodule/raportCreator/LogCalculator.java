package pl.isa.raportmodule.raportCreator;

import pl.isa.raportmodule.domain.AdminPreferences;
import pl.isa.raportmodule.domain.Log;
import pl.isa.raportmodule.repository.AdminPreferencesRepository;
import pl.isa.raportmodule.repository.LogRepository;

import javax.inject.Inject;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class LogCalculator {
    @Inject
    LogRepository logRepository;
    @Inject
    AdminPreferencesRepository adminPreferencesRepository;

    public void sendRaport(String raport, String address){
        Properties properties = System.getProperties();
        properties.setProperty("aspmx.l.google.com", "localhost");
        Session session = Session.getDefaultInstance(properties);
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(address));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(address()));
            message.setSubject("Weekly Raport" + LocalDateTime.now().toString());
            message.setText(raport);
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    public void buildRaport() {
        List<AdminPreferences> adminPreferencesList = adminPreferencesRepository.getAdminPreferences();

        for (AdminPreferences adminPreferences : adminPreferencesList) {
            List<Log> logs;
            StringBuilder raport = new StringBuilder();
            String email = adminPreferences.getEmail();
            String preferences = adminPreferences.getPreferences();
            if (preferences.contains("logged-in")) {
                logs = logRepository.getSpecifiedLogs("logged-in");
                raport.append("Logins amount: ");
                raport.append(logs.size());
                raport.append(" \n");
            } else if (preferences.contains("login-error")) {
                logs = logRepository.getSpecifiedLogs("login-error");
                raport.append("Login errors amount: ");
                raport.append(logs.size());
                raport.append(" \n");
            } else if (preferences.contains("register-error")) {
                logs = logRepository.getSpecifiedLogs("register-error");
                raport.append("Register errors amount: ");
                raport.append(logs.size());
                raport.append(" \n");
            } else if (preferences.contains("user-registered")) {
                logs = logRepository.getSpecifiedLogs("user-registered");
                raport.append("New accounts amount: ");
                raport.append(logs.size());
                raport.append(" \n");
            } else if (preferences.contains("searching-manually")) {
                logs = logRepository.getSpecifiedLogs("searching-manually");
                raport.append("Manual searching amount: ");
                raport.append(logs.size());
                raport.append(" \n");
            } else if (preferences.contains("searching-form")) {
                logs = logRepository.getSpecifiedLogs("searching-form");
                raport.append("Searching by form amount: ");
                raport.append(logs.size());
                raport.append(" \n");
            } else if (preferences.contains("cars-displayed")) {
                logs = logRepository.getSpecifiedLogs("cars-displayed");
                raport.append("Cars database access amount: ");
                raport.append(logs.size());
                raport.append(" \n");
            } else if (preferences.contains("car-added")) {
                logs = logRepository.getSpecifiedLogs("car-added");
                raport.append("New cars in database: ");
                raport.append(logs.size());
                raport.append(" \n");
            } else if (preferences.contains("atena-session-not-found")) {
                logs = logRepository.getSpecifiedLogs("atena-session-not-found");
                raport.append("Wrong atena session codes amount: ");
                raport.append(logs.size());
                raport.append(" \n");
            }

            sendRaport(raport.toString(), adminPreferences.getEmail());


        }
    }

}

