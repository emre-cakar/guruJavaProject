package com.guru.command;

import com.guru.controller.StockSaveUIController;
import com.guru.view.MainFrameUI;
import com.guru.view.StockSaveUI;

public class MainFrameUI_StockSaveCommand implements Command{
	private final MainFrameUI mainFrame;
	private StockSaveUIController stockSaveUIController;
	public MainFrameUI_StockSaveCommand(MainFrameUI mainFrame) {
		this.mainFrame=mainFrame;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		StockSaveUI stockSaveUI=new StockSaveUI(mainFrame);
		mainFrame.getDp().add(stockSaveUI).setVisible(true);
		stockSaveUI.toFront();
		stockSaveUIController=new StockSaveUIController(stockSaveUI);
		stockSaveUIController.execute();

	}

}
