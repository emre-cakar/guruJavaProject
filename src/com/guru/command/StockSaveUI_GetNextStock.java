package com.guru.command;

import com.guru.view.StockSaveUI;

public class StockSaveUI_GetNextStock implements Command {
	private StockSaveUI stockSaveUI;
	public StockSaveUI_GetNextStock(StockSaveUI stockSaveUI) {
		this.stockSaveUI=stockSaveUI;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		stockSaveUI.setStock(stockSaveUI.getStock().beforNextStock("next",stockSaveUI.getTfCode().getText())); 
		stockSaveUI.writeStockCode();
		stockSaveUI.getTfCode().setFocusable(false);
		stockSaveUI.getTfCode().setEnabled(false);
	}
}
