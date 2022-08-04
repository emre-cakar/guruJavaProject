package com.guru.help;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

public class Mail {
	private String toMail, subject, body;
	private Config config = new Config();
	private String filename;

	public Mail() {
	}

	public Mail(String toMail, String subject, String body) {
		this.toMail = toMail;
		this.subject = subject;
		this.body = body;
	}

	public void sendMail() {
		Properties props = System.getProperties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.ssl.trust", config.mailHost);
		props.put("mail.smtp.user", config.mailUser);
		props.put("mail.smtp.password", config.mailPassword);
		props.put("mail.smtp.port", config.mailPort);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smpt.ssl.enable", "true");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");
		props.put("mail.smpt.quitwait", "false");
		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(config.mailUser));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(toMail));
			message.setSubject(subject);
			if (filename!=null) {
				BodyPart messageBodyPart = new MimeBodyPart();
				messageBodyPart.setText(body);
				Multipart multipart = new MimeMultipart();
				multipart.addBodyPart(messageBodyPart);
				messageBodyPart = new MimeBodyPart();
				DataSource source = new FileDataSource(filename);
				messageBodyPart.setDataHandler(new DataHandler(source));
				messageBodyPart.setFileName(filename);
				multipart.addBodyPart(messageBodyPart);
				message.setContent(multipart);
			}else {
				message.setText(body);
			}
			Transport transport = session.getTransport("smtp");
			transport.connect(config.mailHost, config.mailUser, config.mailPassword);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (AddressException ae) {
			ae.printStackTrace();
		} catch (MessagingException me) {
			me.printStackTrace();
		}
	}

	public String getToMail() {
		return toMail;
	}

	public void setToMail(String toMail) {
		this.toMail = toMail;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

}
