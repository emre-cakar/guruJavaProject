package com.guru.command;

import com.guru.controller.StockSaveUIController;
import com.guru.view.MainFrameUI;
import com.guru.view.StockSaveUI;
import com.guru.view.StockShowUI;

public class StockShowUI_CopySelectedStock implements Command{
	private final StockShowUI stockShowUI;
	StockSaveUIController stockSaveUIController;
	public StockShowUI_CopySelectedStock(StockShowUI stockShowUI) {
		this.stockShowUI=stockShowUI;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		String stockCode= stockShowUI.copySelectedStock();
		if(stockCode!=null) {
			MainFrameUI mf =stockShowUI.getMf();
			StockSaveUI saveUI=new StockSaveUI(mf);

			saveUI.setTfCode(stockCode);
			saveUI.SetFocusOFTfCode();
			saveUI.setTfCode("");
			saveUI.getTfCode().setFocusable(true);
			saveUI.getTfCode().setEnabled(true);
			
			//saveUI.writeStockToComponent(stock);
			mf.getDp().add(saveUI).setVisible(true);
			saveUI.toFront();
			stockSaveUIController=new StockSaveUIController(saveUI);
			stockSaveUIController.execute();
		}
	}
	
	

}
