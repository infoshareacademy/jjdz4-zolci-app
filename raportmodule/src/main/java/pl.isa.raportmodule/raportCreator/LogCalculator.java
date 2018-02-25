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
            message.setSubject("Weekly Raport " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.mm.yyyy")));
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
            List<Log> logs;

            String email = adminPreferences.getEmail();
            String preferences = adminPreferences.getPreferences();
            if (preferences.contains("logged-in")) {
                logs = logRepository.getSpecifiedLogs("logged-in");
                raport.append("Logins amount: ");
                raport.append(logs.size());
                raport.append(" \n");
            }
            if (preferences.contains("logged-out")) {
                logs = logRepository.getSpecifiedLogs("logged-out");
                raport.append("Logouts amount: ");
                raport.append(logs.size());
                raport.append(" \n");
            }
            if (preferences.contains("login-error")) {
                logs = logRepository.getSpecifiedLogs("login-error");
                raport.append("Login errors amount: ");
                raport.append(logs.size());
                raport.append(" \n");
            }
            if (preferences.contains("register-error")) {
                logs = logRepository.getSpecifiedLogs("register-error");
                raport.append("Register errors amount: ");
                raport.append(logs.size());
                raport.append(" \n");
            }
            if (preferences.contains("user-registered")) {
                logs = logRepository.getSpecifiedLogs("user-registered");
                raport.append("New accounts amount: ");
                raport.append(logs.size());
                raport.append(" \n");
            }
            if (preferences.contains("searching-manually")) {
                logs = logRepository.getSpecifiedLogs("searching-manually");
                raport.append("Manual searching amount: ");
                raport.append(logs.size());
                raport.append(" \n");
            }
            if (preferences.contains("searching-form")) {
                logs = logRepository.getSpecifiedLogs("searching-form");
                raport.append("Searching by form amount: ");
                raport.append(logs.size());
                raport.append(" \n");
            }
            if (preferences.contains("cars-displayed")) {
                logs = logRepository.getSpecifiedLogs("cars-displayed");
                raport.append("Cars database access amount: ");
                raport.append(logs.size());
                raport.append(" \n");
            }
            if (preferences.contains("car-added")) {
                logs = logRepository.getSpecifiedLogs("car-added");
                raport.append("New cars in database: ");
                raport.append(logs.size());
                raport.append(" \n");
            }
            if (preferences.contains("atena-session-not-found")) {
                logs = logRepository.getSpecifiedLogs("atena-session-not-found");
                raport.append("Wrong atena session codes amount: ");
                raport.append(logs.size());
                raport.append(" \n");
            }


            sendRaport(raport.toString(), adminPreferences.getEmail());


        }
        return raport.toString();
    }

}

