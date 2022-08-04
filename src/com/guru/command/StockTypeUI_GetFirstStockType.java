package com.guru.command;

import com.guru.view.StockTypeUI;

public class StockTypeUI_GetFirstStockType implements Command{
	private StockTypeUI stockTypeUI;
	public StockTypeUI_GetFirstStockType(StockTypeUI stockTypeUI) {
		this.stockTypeUI=stockTypeUI;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		stockTypeUI.setStockTypeModel(stockTypeUI.getStockTypeModel().beforNextStockType("first",0)); 
		stockTypeUI.writeStockType();	
	}
}
