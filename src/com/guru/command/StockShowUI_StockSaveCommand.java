package com.guru.command;

import com.guru.controller.StockSaveUIController;
import com.guru.view.MainFrameUI;
import com.guru.view.StockSaveUI;
import com.guru.view.StockShowUI;

public class StockShowUI_StockSaveCommand implements Command{
	private final StockShowUI stockShowUI;
	private StockSaveUIController stockSaveUIController;
	
	public StockShowUI_StockSaveCommand(StockShowUI stockShowUI) {
		this.stockShowUI=stockShowUI;
	}
	public void execute() {
		MainFrameUI mf =stockShowUI.getMf();
		mf.getDp().add(new StockSaveUI(mf)).setVisible(true);
		for (StockSaveUI saveUI:mf.getStokSaveList()) {
			saveUI.toFront();
			stockSaveUIController=new StockSaveUIController(saveUI);
			stockSaveUIController.execute();
		}
		
	}
}
