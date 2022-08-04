package com.guru.command;

import com.guru.controller.MailFrameUIController;
import com.guru.view.MailFrameUI;
import com.guru.view.MainFrameUI;
import com.guru.view.StockShowUI;

public class StockShowUI_SendMail implements Command{
	private StockShowUI stockShowUI;
	private MailFrameUI mailFrameUI;
	private MailFrameUIController mailFrameUIController;
	private MainFrameUI mf;
	public StockShowUI_SendMail(StockShowUI stockShowUI) {
		this.stockShowUI=stockShowUI;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		mf=stockShowUI.getMf();
		mailFrameUI=new MailFrameUI();
		mf.getDp().add(mailFrameUI).setVisible(true);
		mailFrameUI.toFront();
		mailFrameUIController=new MailFrameUIController(mailFrameUI);
		mailFrameUIController.execute();
	}
	

}
