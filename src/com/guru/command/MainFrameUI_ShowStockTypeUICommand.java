package com.guru.command;

import com.guru.controller.StockTypeUIController;
import com.guru.view.MainFrameUI;
import com.guru.view.StockTypeUI;

public class MainFrameUI_ShowStockTypeUICommand implements Command {
	private final MainFrameUI mainFrame;
	private StockTypeUIController stockTypeUIController;
	
	public MainFrameUI_ShowStockTypeUICommand(MainFrameUI mainFrame) {
		this.mainFrame=mainFrame;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		StockTypeUI stockTypeUI=new StockTypeUI();
		mainFrame.getDp().add(stockTypeUI).setVisible(true);
		stockTypeUI.toFront();
		stockTypeUIController=new StockTypeUIController(stockTypeUI);
		stockTypeUIController.execute();
	}
}
