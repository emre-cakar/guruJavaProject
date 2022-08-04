package com.guru.command;

import java.awt.event.ComponentEvent;

import com.guru.model.StockType;
import com.guru.view.StockTypeUI;

public class StockTypeUI_setFocucProcess implements Command {
	private StockTypeUI stockTypeUI;
	private StockType stockType;
	
	public StockTypeUI_setFocucProcess(StockTypeUI stockTypeUI) {
		this.stockTypeUI=stockTypeUI;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}
	@Override
	public void execute(ComponentEvent e) {
		if (e.getID()==1004) {
			stockTypeUI.setStockTypeModel(null);
		}else if (e.getID()==1005) {
			stockType=new StockType();
			stockType.setCode(stockTypeUI.getTfCode().getText());
			stockTypeUI.setStockTypeModel(stockType.getStockTypeItem(stockType));
		}
	}
}
