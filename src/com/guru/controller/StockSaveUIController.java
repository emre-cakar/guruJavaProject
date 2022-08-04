package com.guru.controller;

import com.guru.command.StockSaveUI_CancelCommand;
import com.guru.command.StockSaveUI_DeleteCommand;
import com.guru.command.StockSaveUI_GetBeforeStock;
import com.guru.command.StockSaveUI_GetFirstStockSave;
import com.guru.command.StockSaveUI_GetLastStockSave;
import com.guru.command.StockSaveUI_GetNextStock;
import com.guru.command.StockSaveUI_SaveCommand;
import com.guru.command.StockSaveUI_tfCodeFocusProcess;
import com.guru.help.GeneralListener;
import com.guru.view.StockSaveUI;

public class StockSaveUIController {
	private final StockSaveUI stockSaveUI;
		
	public StockSaveUIController(StockSaveUI stockSaveUI) {
		this.stockSaveUI=stockSaveUI;
	}
	
	public void execute() {
		setListener();
	}
	
	public void setListener() {
		stockSaveUI.getBtnSave().addActionListener(new GeneralListener(new StockSaveUI_SaveCommand(stockSaveUI)));
		stockSaveUI.getBtnDelete().addActionListener(new GeneralListener(new StockSaveUI_DeleteCommand(stockSaveUI)));
		stockSaveUI.getBtnCancel().addActionListener(new GeneralListener(new StockSaveUI_CancelCommand(stockSaveUI)));

		stockSaveUI.getBtnFirst().addActionListener(new GeneralListener(new StockSaveUI_GetFirstStockSave(stockSaveUI)));
		stockSaveUI.getBtnBefore().addActionListener(new GeneralListener(new StockSaveUI_GetBeforeStock(stockSaveUI)));
		stockSaveUI.getBtnNext().addActionListener(new GeneralListener(new StockSaveUI_GetNextStock(stockSaveUI)));
		stockSaveUI.getBtnLast().addActionListener(new GeneralListener(new StockSaveUI_GetLastStockSave(stockSaveUI)));
		
		stockSaveUI.getTfCode().addFocusListener(new GeneralListener(new StockSaveUI_tfCodeFocusProcess(stockSaveUI)));
	}
	

}
