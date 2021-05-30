package utils;
import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Mail {

	@SuppressWarnings("restriction")
	public static void Sendmail(String User, String pass, String to_mail, String Subject, String path ) {
		 final String username = User;
		    final String password = pass;

		    Properties props = new Properties();
		    props.put("mail.smtp.auth", true);
		    props.put("mail.smtp.starttls.enable", true);
		    props.put("mail.smtp.host", "smtp.gmail.com");
		    props.put("mail.smtp.port", "587");

		    Session session = Session.getInstance(props,
		            new javax.mail.Authenticator() {
		                protected PasswordAuthentication getPasswordAuthentication() {
		                    return new PasswordAuthentication(username, password);
		                }
		            });

		    try {

		        Message message = new MimeMessage(session);
		        message.setFrom(new InternetAddress(User));
		        message.setRecipients(Message.RecipientType.TO,
		                InternetAddress.parse(to_mail));
		        message.setSubject(Subject);
		        message.setText("Here is my first automation report");

		        MimeBodyPart messageBodyPart = new MimeBodyPart();

		        Multipart multipart = new MimeMultipart();

		        messageBodyPart = new MimeBodyPart();
		        String file = path;
		        String fileName = "Test Result Report";
		        messageBodyPart.setText("Here is my first automation report");
		        DataSource source = new FileDataSource(file);
		        messageBodyPart.setDataHandler(new DataHandler(source));
		        messageBodyPart.setFileName(fileName);
		        multipart.addBodyPart(messageBodyPart);

		        message.setContent(multipart);

		        System.out.println("Sending");

		        Transport.send(message);

		        System.out.println("Done");

		    } catch (MessagingException e) {
		        e.printStackTrace();
		    }
	}
	
	public static void main(String[] args) {
		Sendmail("chaitalirajput45@gmail.com","1234","chaitalirajput45@gmail.com",
				"My 1st Automation email!!", 
				"C:\\Users\\Admin\\eclipse-workspace\\Advanced_framework_with_BDD\\test-output\\Spark\\ExtentSpark.html");
	}
	}


