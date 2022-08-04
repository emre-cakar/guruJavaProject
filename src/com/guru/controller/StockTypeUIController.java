package com.guru.controller;

import com.guru.command.StockTypeUI_DeleteCommand;
import com.guru.command.StockTypeUI_GetBeforeStockType;
import com.guru.command.StockTypeUI_GetFirstStockType;
import com.guru.command.StockTypeUI_GetLastStockType;
import com.guru.command.StockTypeUI_GetNextStockType;
import com.guru.command.StockTypeUI_SaveStockTypeCommand;
import com.guru.command.StockTypeUI_setFocucProcess;
import com.guru.help.GeneralListener;
import com.guru.view.StockTypeUI;

public class StockTypeUIController  {
	private final StockTypeUI stockTypeUI;
	
	public StockTypeUIController(StockTypeUI stockTypeUI) {
		this.stockTypeUI=stockTypeUI;
	}
	public void execute() {
		setListener();
	}
	public void setListener() {
		stockTypeUI.getBtnFirst().addActionListener(new GeneralListener(new StockTypeUI_GetFirstStockType(stockTypeUI)));
		stockTypeUI.getBtnBefore().addActionListener(new GeneralListener(new StockTypeUI_GetBeforeStockType(stockTypeUI)));
		stockTypeUI.getBtnNext().addActionListener(new GeneralListener(new StockTypeUI_GetNextStockType(stockTypeUI)));
		stockTypeUI.getBtnLast().addActionListener(new GeneralListener(new StockTypeUI_GetLastStockType(stockTypeUI)));

		stockTypeUI.getBtnSave().addActionListener(new GeneralListener(new StockTypeUI_SaveStockTypeCommand(stockTypeUI)));
		stockTypeUI.getBtnDelete().addActionListener(new GeneralListener(new StockTypeUI_DeleteCommand(stockTypeUI)));
		
		stockTypeUI.getTfCode().addFocusListener(new GeneralListener(new StockTypeUI_setFocucProcess(stockTypeUI)));
	}

}
