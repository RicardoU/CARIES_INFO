package com.unbosque.info.util;
import javax.mail.*; 
import javax.mail.internet.InternetAddress; 
import javax.mail.internet.MimeMessage; 
import java.util.Properties; 

/*********************************************** 
/* JavaMail SSL + Authentication - Example Code 
/************************************************/ 
public class Mailer 
{ 

        

    public void sendMail(String server, String userName, String password, String fromAddress, String toAddress, String cc, String bcc, boolean htmlFormat, String subject, String body) 
    { 
     
        Properties properties = System.getProperties(); 
        properties.put("mail.smtps.host", server); 
        properties.put("mail.smtps.auth", "true"); 
        Session ses  = Session.getInstance(properties); 

        ses.setDebug(true); 

        try{ 
         
            MimeMessage msg = new MimeMessage(ses); 
     
            msg.setFrom(new InternetAddress(fromAddress)); 
     
            if (toAddress != null) 
            { 
               msg.addRecipients(Message.RecipientType.TO, toAddress); 
            } 
     
            if (cc != null) 
            { 
                msg.setRecipients(Message.RecipientType.CC 
                        ,InternetAddress.parse(cc, false)); 
            } 
     
            if (bcc != null) 
            { 
                msg.setRecipients(Message.RecipientType.BCC 
                        ,InternetAddress.parse(bcc, false)); 
            } 
     
            if (htmlFormat) 
            { 
                msg.setContent(body, "text/html"); 
            } 
            else 
            { 
                msg.setContent(body, "text/plain"); 
            } 
     
            msg.setSubject(subject); 
            msg.saveChanges(); 
     
            Transport tr = ses.getTransport("smtps"); 
            tr.connect(server,userName, password); 
            tr.sendMessage(msg, msg.getAllRecipients()); 
            tr.close(); 
        } 
         
        catch(MessagingException e) 
        { 
            e.printStackTrace(); 
        } 
         
         

    } 
} 