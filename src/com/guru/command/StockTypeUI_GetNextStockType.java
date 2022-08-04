package com.guru.command;

import com.guru.view.StockTypeUI;

public class StockTypeUI_GetNextStockType implements Command{
	private StockTypeUI stockTypeUI;
	public StockTypeUI_GetNextStockType(StockTypeUI stockTypeUI) {
		this.stockTypeUI=stockTypeUI;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		stockTypeUI.setStockTypeModel(stockTypeUI.getStockTypeModel().beforNextStockType("next",stockTypeUI.getStockTypeModel().getId())); 
		stockTypeUI.writeStockType();	
	}
}
