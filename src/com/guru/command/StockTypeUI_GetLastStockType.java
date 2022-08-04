package com.guru.command;

import com.guru.view.StockTypeUI;

public class StockTypeUI_GetLastStockType implements Command{
	private StockTypeUI stockTypeUI;
	public StockTypeUI_GetLastStockType(StockTypeUI stockTypeUI) {
		this.stockTypeUI=stockTypeUI;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		stockTypeUI.setStockTypeModel(stockTypeUI.getStockTypeModel().beforNextStockType("last",0)); 
	
		stockTypeUI.writeStockType();	
	}
}
