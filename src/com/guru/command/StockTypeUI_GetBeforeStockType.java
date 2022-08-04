package com.guru.command;

import com.guru.view.StockTypeUI;

public class StockTypeUI_GetBeforeStockType implements Command {
	private StockTypeUI stockTypeUI;
	public StockTypeUI_GetBeforeStockType(StockTypeUI stockTypeUI) {
		this.stockTypeUI=stockTypeUI;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		stockTypeUI.setStockTypeModel(stockTypeUI.getStockTypeModel().beforNextStockType("before",stockTypeUI.getStockTypeModel().getId())); 
		stockTypeUI.writeStockType();	

	}
}
