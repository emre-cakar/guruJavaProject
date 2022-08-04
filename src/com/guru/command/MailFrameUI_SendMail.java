package com.guru.command;

import java.beans.PropertyVetoException;

import com.guru.help.Help;
import com.guru.view.MailFrameUI;

public class MailFrameUI_SendMail implements Command{
	private MailFrameUI mailFrameUI;
	public MailFrameUI_SendMail(MailFrameUI mailFrameUI) {
		this.mailFrameUI=mailFrameUI;
	}

	@Override
	public void execute() {
		
		if (mailFrameUI.getTfMailAdress().getText().isEmpty()) {
			Help.showMsg("Mail adres alanı boş bırakılamaz");
			mailFrameUI.getTfMailAdress().requestFocusInWindow();
		}else{
			mailFrameUI.getMail().setToMail(mailFrameUI.getTfMailAdress().getText());
			mailFrameUI.getMail().setSubject(mailFrameUI.getTfMailSubject().getText());
			mailFrameUI.getMail().setBody(mailFrameUI.getTaMailBody().getText());
			mailFrameUI.getMail().sendMail();
		    Help.showMsg("Mail Gönderilmiştir.");
		    try {
				mailFrameUI.setClosed(true);
			} catch (PropertyVetoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
	
}
