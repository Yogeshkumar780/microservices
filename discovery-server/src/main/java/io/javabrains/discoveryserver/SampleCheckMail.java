package io.javabrains.discoveryserver;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class SampleCheckMail {
	
	
	
	public static void main(String[] args) throws IOException {
        System.out.println("Inside SampleCheckMail.main");
        String mailBody = "";
                            StringBuilder contentBuilder = new StringBuilder();
                     String line;
                     
                     mailBody +="<p>Hi,<br></p>"+"<p>Below is the Web Automation report:<br><br></p>"+"<style type='text/css'>"+
                                          ".tg  {border-collapse:collapse;border-spacing:0;border-color:#999;}"+
                                          ".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px"+ "5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#999;color:#444;background-color:#F7FDFA;}"+
                                          ".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px"+ "5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#999;color:#fff;background-color:#92DAEA;}"+
                                          ".tg .tg-9hbo{font-weight:bold;vertical-align:top}"+
                                          ".tg .tg-yw4l{vertical-align:top}"+
                                          "</style>";
                     mailBody += "<br>";
                     mailBody += "<h3><b>Click on the link to see the detailed report :</b>";
                     mailBody +="<span style='color:blue'><a href=''><b> AutomationReport</b></a></span></h3>"; 
                     mailBody += "<br><br>";
        mailBody += "<br><br><br>";
        mailBody+="Thanks,";
        mailBody+="<br>";
        mailBody+="QA Team";

        
        
        String mailSubject = "Web Automation Report : "+Calendar.getInstance().getTime();
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587"); 
        javax.mail.Session session = javax.mail.Session.getInstance(props,
                     new javax.mail.Authenticator() {
                            protected PasswordAuthentication getPasswordAuthentication() {
                                   return new PasswordAuthentication("khurshid.alam.testmine@gmail.com", "Testmine");
                            }
                     });
        MimeMessage message = new MimeMessage(session);
        
        try {
               try {
                     System.out.println("inside try");
                     message.setFrom(new InternetAddress("khurshid.alam.testmine@gmail.com", "no-reply-Automation"));                
                     InternetAddress[] iAdressArray_to = InternetAddress.parse("khurshidin@gmail.com");
                     message.setRecipients(Message.RecipientType.TO,iAdressArray_to); 
                     message.setSubject(mailSubject);
                     message.setContent(mailBody, "text/html; charset=utf-8");
                     // Create the message part 
                     MimeBodyPart messageBodyPart = new MimeBodyPart();
 
                     // Fill the message
                     messageBodyPart.setText(mailBody,"UTF-8","html");
 
                     Multipart multipart = new MimeMultipart();
                     multipart.addBodyPart(messageBodyPart);
 
                     // Put parts in message
                     message.setContent(multipart);
                     System.out.println("before transport");

                     
                     
                     Transport.send(message);
                     System.out.println("Message has been sent successfully ............");
               } catch (AddressException e) {
               e.printStackTrace();
        } catch (MessagingException e) {
               e.printStackTrace();
        }
        } catch (UnsupportedEncodingException e) {
               e.printStackTrace();
        }

 }


	

}
