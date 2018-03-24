package pl.isa.raportmodule.raportCreator;

import pl.isa.raportmodule.domain.AdminPreferences;
import pl.isa.raportmodule.domain.Log;
import pl.isa.raportmodule.repository.AdminPreferencesRepository;
import pl.isa.raportmodule.repository.LogRepository;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class LogCalculator {
//    @Inject
//    LogRepository logRepository;
//    @Inject
//    AdminPreferencesRepository adminPreferencesRepository;

    private void sendRaport(String raport, String address) {
        String originAddress = "yellowautopartsfinder@gmail.com";
        String password = "JeeAutoParts";
        String host = "smtp.gmail.com";
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", true); // added this line
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", originAddress);
        props.put("mail.smtp.password", password);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", true);
        Session session = Session.getInstance(props, null);
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(originAddress));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(address));
            message.setSubject("Weekly Raport " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
            message.setText(raport);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, originAddress, password);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    public String buildRaport(LogRepository logRepository, AdminPreferencesRepository adminPreferencesRepository) {
        List<AdminPreferences> adminPreferencesList = adminPreferencesRepository.getAdminPreferences();
        StringBuilder raport = new StringBuilder();
        for (AdminPreferences adminPreferences : adminPreferencesList) {
            List<Log> logs = logRepository.getLogs();

            for(Log log : logs){
                if(log.getLocalDateTime().isBefore(LocalDateTime.now().minusDays(7))){
                    logs.remove(log);
                    continue;
                }
            }

            List<Log> specifiedLogs;

            String preferences = adminPreferences.getPreferences();
            if (preferences.contains("logged-in")) {
                specifiedLogs = filterLogs(logs, "logged-in");
                raport.append("Logins amount: ");
                raport.append(specifiedLogs.size());
                raport.append(" \n");
            }
            if (preferences.contains("logged-out")) {
                specifiedLogs = filterLogs(logs,"logged-out");
                raport.append("Logouts amount: ");
                raport.append(specifiedLogs.size());
                raport.append(" \n");
            }
            if (preferences.contains("login-error")) {
                specifiedLogs = filterLogs(logs,"login-error");
                raport.append("Login errors amount: ");
                raport.append(specifiedLogs.size());
                raport.append(" \n");
            }
            if (preferences.contains("register-error")) {
                specifiedLogs = filterLogs(logs,"register-error");
                raport.append("Register errors amount: ");
                raport.append(specifiedLogs.size());
                raport.append(" \n");
            }
            if (preferences.contains("user-registered")) {
                specifiedLogs = filterLogs(logs,"user-registered");
                raport.append("New accounts amount: ");
                raport.append(specifiedLogs.size());
                raport.append(" \n");
            }
            if (preferences.contains("searching-manually")) {
                specifiedLogs = filterLogs(logs,"searching-manually");
                raport.append("Manual searches amount: ");
                raport.append(specifiedLogs.size());
                raport.append(" \n");
            }
            if (preferences.contains("searching-form")) {
                specifiedLogs = filterLogs(logs,"searching-form");
                raport.append("Searches by form amount: ");
                raport.append(specifiedLogs.size());
                raport.append(" \n");
            }
            if (preferences.contains("cars-displayed")) {
                specifiedLogs = filterLogs(logs,"cars-displayed");
                raport.append("Cars database access amount: ");
                raport.append(specifiedLogs.size());
                raport.append(" \n");
            }
            if (preferences.contains("car-added")) {
                specifiedLogs = filterLogs(logs,"car-added");
                raport.append("New cars in database: ");
                raport.append(specifiedLogs.size());
                raport.append(" \n");
            }
            if (preferences.contains("atena-session-not-found")) {
                specifiedLogs = filterLogs(logs,"atena-session-not-found");
                raport.append("Wrong atena session codes amount: ");
                raport.append(specifiedLogs.size());
                raport.append(" \n");
            }


            sendRaport(raport.toString(), adminPreferences.getEmail());


        }
        return raport.toString();
    }

    private List<Log> filterLogs(List<Log> logsList, String filter){
        List<Log> filteredLogs = new ArrayList<>();
        for(Log log : logsList){
            if(log.getMessage().equals(filter))
                filteredLogs.add(log);
        }
        return filteredLogs;
    }

}

