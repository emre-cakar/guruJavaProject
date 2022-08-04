package com.guru.controller;

import com.guru.command.MailFrameUI_CancelCommand;
import com.guru.command.MailFrameUI_SelectFile;
import com.guru.command.MailFrameUI_SendMail;
import com.guru.help.GeneralListener;
import com.guru.view.MailFrameUI;

public class MailFrameUIController {
	private final MailFrameUI mailFrameUI;
	
	public MailFrameUIController(MailFrameUI mailFrameUI) {
		this.mailFrameUI=mailFrameUI;
	}
	
	public void execute() {
		setListener();
	}
	
	public void setListener() {
		mailFrameUI.getBtnCancel().addActionListener(new GeneralListener(new MailFrameUI_CancelCommand(mailFrameUI)));
		mailFrameUI.getBtnSelectFile().addActionListener(new GeneralListener(new MailFrameUI_SelectFile(mailFrameUI)));
		mailFrameUI.getBtnSend().addActionListener(new GeneralListener(new MailFrameUI_SendMail(mailFrameUI)));
	}
}
