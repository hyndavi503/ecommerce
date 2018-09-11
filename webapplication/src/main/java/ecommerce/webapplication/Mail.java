package ecommerce.webapplication;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;


@Component
public class Mail {
	
	
	public void sendingMail(String email,String name) {
		
		
		try {
		String host="smtp.gmail.com";
		String user="hackingpro2016@gmail.com";
		String pass="2016naveen";
		String to="naveengupta3074@gmail.com";
		String from="hackingpro2016@gmail.com";
		String subject="This is a simple emssage";
		String messageText="your is test email";
		
		boolean sessionDebug=false;
		
		Properties properties=System.getProperties();
		
		properties.put("mail.smtp.starttls.enable","true");
		properties.put("mail.smtp.host",host);
		properties.put("mail.smtp.port","587");
		properties.put("mail.smtp.auth","true");
		properties.put("mail.smtp.starttls.required","true");
		
		java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		
		Session mailSession=Session.getDefaultInstance(properties,null);
		mailSession.setDebug(sessionDebug);
		Message msg=new MimeMessage(mailSession);
		
			msg.setFrom(new InternetAddress(from));
			
			InternetAddress address=(new InternetAddress(to));
			msg.setRecipient(Message.RecipientType.TO, address);
			msg.setSubject(subject);
			msg.setSentDate(new Date());
			msg.setText(messageText);
			
			Transport transport=mailSession.getTransport("smtp");
			transport.connect(host, user, pass);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
			System.out.println("Message Sent successfully");
			
			
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}