package com.guru.command;

import javax.swing.JFileChooser;

import com.guru.view.MailFrameUI;

public class MailFrameUI_SelectFile implements Command{
	private MailFrameUI mailFrameUI;

	public MailFrameUI_SelectFile(MailFrameUI mailFrameUI) {
		this.mailFrameUI=mailFrameUI;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		JFileChooser fileChooser=new JFileChooser();
		int response=fileChooser.showSaveDialog(null);
		if(response==JFileChooser.APPROVE_OPTION){
			mailFrameUI.getMail().setFilename(fileChooser.getSelectedFile().getAbsolutePath());
			mailFrameUI.setLblSelectFile(fileChooser.getSelectedFile().getName());
		}
	}
	
	
}
