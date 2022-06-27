package Sevice;

import java.net.PasswordAuthentication;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import entity.Email;

public class Email_Service {
	public static void send(Email email) throws Exception {
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(email.getFrom(), email.getFrompassword());
			}
		});
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email.getFrom()));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getTo()));
			message.setSubject(email.getSubject());
			message.setText(email.getContent());


			Transport.send(message);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
