package com.guru.command;

import com.guru.controller.StockShowUIController;
import com.guru.view.MainFrameUI;
import com.guru.view.StockShowUI;

public class MainFrame_StockShowUICommand implements Command{
	private final MainFrameUI mainFrame;
	private StockShowUIController stockShowUIController;
	
	public MainFrame_StockShowUICommand(MainFrameUI mainFrame) {
		this.mainFrame=mainFrame;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		StockShowUI stockShowUI=new StockShowUI(mainFrame);
		mainFrame.getDp().add(stockShowUI).setVisible(true);
		stockShowUI.toFront();
		stockShowUIController=new StockShowUIController(stockShowUI);
		stockShowUIController.execute();
		
	}
}
