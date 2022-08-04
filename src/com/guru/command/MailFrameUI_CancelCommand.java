package com.guru.command;

import java.beans.PropertyVetoException;

import com.guru.view.MailFrameUI;

public class MailFrameUI_CancelCommand implements Command{
	private MailFrameUI mailFrameUI;
	
	public MailFrameUI_CancelCommand (MailFrameUI mailFrameUI) {
		this.mailFrameUI=mailFrameUI;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		try {
			mailFrameUI.setClosed(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
