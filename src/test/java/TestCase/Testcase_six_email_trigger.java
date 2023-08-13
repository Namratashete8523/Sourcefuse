package TestCase;

import java.awt.AWTException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.testng.annotations.Test;

public class Testcase_six_email_trigger extends TestCase_five_submitdata_DB {
	public String str1="Email Trigger", email_from=" ";
	   String senderPassword = "kbftsalbtanlukll";
	   public TestCase_five_submitdata_DB testfive;
	@Test
	void email_trigger() throws InterruptedException, SQLException, AWTException
	{
	
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_details", "root",
			"Namrata@2029");
	Statement stmt = con.createStatement();
	
if((super.s)!=null)
{
	 // SMTP server configuration
	String host="smtp.gmail.com";
    Properties properties = new Properties();
    properties.put("mail.smtp.host", host);
    properties.put("mail.smtp.port", "587");
    properties.put("mail.smtp.auth", "true");
    properties.put("mail.smtp.starttls.enable", "true");
    
    String recipientEmail = "namratashete51@gmail.com";
    email_from=super.empemail;
    // Email content
    String subject = "Test Email";
    String body = "This is a test email sent from Java.";
    
    // Create a session with authentication
    Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
        protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
            return new javax.mail.PasswordAuthentication( email_from, senderPassword);
        }
    });
    
    // Used to debug SMTP issues
    session.setDebug(true);

    try {
        // Create a default MimeMessage object.
        MimeMessage message = new MimeMessage(session);

        // Set From: header field of the header.
        message.setFrom(new InternetAddress(email_from));

        // Set To: header field of the header.
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));

        // Set Subject: header field
        message.setSubject(subject);

        // Now set the actual message
        message.setText(body);

        System.out.println("sending...");
        // Send message
        
        // Send the message
        Transport.send(message);
        
        System.out.println("Email sent successfully!");
    } catch (MessagingException e) {
        System.out.println("Error sending email: " + e.getMessage());
    }
if((super.s)!=null)
{
String str="update sourcefuse set Emai_status ='"+str1+"' where mob_number='"+super.empmob+"';";	
System.out.println(str);
stmt.executeLargeUpdate(str);
System.out.println("Email trigger status has been change");
}

}
}}