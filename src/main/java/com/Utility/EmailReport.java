package com.Utility;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

import com.BasePackage.Base_Class;
import com.aventstack.extentreports.ExtentReports;

public class EmailReport extends Base_Class{
	
    public  void sendEmailWithAttachment(String reportFileLocation) throws MessagingException, IOException {
        
    	
    	Base_Class bc=	new Base_Class();
    	 List<Object> emaildet = (List<Object>) bc.sendReportData();
    	 
    	 String HOST = (String) emaildet.get(5) ;
    	 System.out.println("HOST" +HOST);
    	 String FROM = (String) emaildet.get(0);
    	 String TO = (String) emaildet.get(2) ;
    	 String[] TOList = TO.split(",");
	     InternetAddress[] recipientAddress = new InternetAddress[TOList.length];
	     int counter = 0;
	     for (String recipient : TOList) {
	         recipientAddress[counter] = new InternetAddress(recipient.trim());
	         counter++;
	     }
    	 String FROMNAME = (String) emaildet.get(1);
    	 String SUBJECT = (String) emaildet.get(7);
    	 String SMTP_USERNAME = (String) emaildet.get(3);
    	 String SMTP_PASSWORD = (String) emaildet.get(4);
    	 
    	 String PORT= (String) emaildet.get(6);
    	 Properties props = System.getProperties();
	     props.put("mail.transport.protocol", "smtp");
	     props.put("mail.smtp.port", PORT);
	     props.put("mail.smtp.starttls.enable", "true");
	     props.put("mail.smtp.auth", "true");
	     props.put("mail.smtp.ssl.protocols", "TLSv1.2");
	     
	     Session session = Session.getDefaultInstance(props);
	     MimeMessage msg = new MimeMessage(session);
	     msg.setFrom(new InternetAddress(FROM,FROMNAME));
	   //  msg.setRecipient(Message.RecipientType.TO, new InternetAddress(TO));
	     msg.setRecipients(Message.RecipientType.TO, recipientAddress);
	    // msg.addRecipients()
	     msg.setSubject(SUBJECT);
	  //   msg.setContent(BODY,"text/html");
	     Multipart multipart = new MimeMultipart();

         // Create and add the email body text
         MimeBodyPart textPart = new MimeBodyPart();
         textPart.setText("This is the body of the email.");
         multipart.addBodyPart(textPart);

         // Create and add the attachment
         MimeBodyPart attachmentPart = new MimeBodyPart();
         String filePath = "C:\\Users\\jayam\\git\\Employeeengage\\TestReport\\Automation_Report_02222024_231633.html"; // Replace with the actual file path
         DataSource source = new FileDataSource(reportFileLocation);
         attachmentPart.setDataHandler(new DataHandler(source));
         attachmentPart.setFileName("AutomationReport.html"); // Replace with the desired file name
         multipart.addBodyPart(attachmentPart);

         // Set the content of the message as the Multipart object
         msg.setContent(multipart);
	     Transport transport = session.getTransport();
//	     <span style="font-weight: 400;"></span>
//	     <span style="font-weight: 400;"> </span>
	     try
	     {
	         System.out.println("Sending...");
	     transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);
	         transport.sendMessage(msg, msg.getAllRecipients());
	         System.out.println("Email sent successfully!");
	     }
	     catch (Exception ex) {
	         System.out.println("The email was not sent.");
	         System.out.println("Error message: " + ex.getMessage());
	     }
	     finally
	     {
	    	 transport.close();
	     }
	}

}
