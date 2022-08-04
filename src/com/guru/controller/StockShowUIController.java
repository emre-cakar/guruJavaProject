package com.guru.controller;

import com.guru.command.StockShowUI_CopySelectedStock;
import com.guru.command.StockShowUI_DeleteCommand;
import com.guru.command.StockShowUI_SaveExcel;
import com.guru.command.StockShowUI_SavePDF;
import com.guru.command.StockShowUI_SendMail;
import com.guru.command.StockShowUI_StockSaveCommand;
import com.guru.command.StockShowUI_TfSearchFocusProcess;
import com.guru.command.StockShowUI_TfSearchKeyProcess;
import com.guru.command.StockShowUI_UpdateDataTable;
import com.guru.help.GeneralListener;
import com.guru.view.StockShowUI;

public class StockShowUIController {
	private final StockShowUI stockShowUI;
	
	public StockShowUIController(StockShowUI stockShowUI) {
		this.stockShowUI=stockShowUI;
	}
	public void execute() {
		setListener();
	}
	public void setListener() {
		stockShowUI.getMiStock().addActionListener(new GeneralListener(new StockShowUI_StockSaveCommand(stockShowUI)));
		stockShowUI.getMiCopy().addActionListener(new GeneralListener(new StockShowUI_CopySelectedStock(stockShowUI)));
		stockShowUI.getMiDelete().addActionListener(new GeneralListener(new StockShowUI_DeleteCommand(stockShowUI)));
		stockShowUI.getMiToExcel().addActionListener(new GeneralListener(new StockShowUI_SaveExcel(stockShowUI)));
		stockShowUI.getMiToPDF().addActionListener(new GeneralListener(new StockShowUI_SavePDF(stockShowUI)));
		stockShowUI.getMiToMail().addActionListener(new GeneralListener(new StockShowUI_SendMail(stockShowUI)));
		stockShowUI.getBtnExcel().addActionListener(new GeneralListener(new StockShowUI_SaveExcel(stockShowUI)));
		stockShowUI.getBtnMail().addActionListener(new GeneralListener(new StockShowUI_SendMail(stockShowUI)));
		stockShowUI.getBtnPDF().addActionListener(new GeneralListener(new StockShowUI_SavePDF(stockShowUI)));
		stockShowUI.getBtnUpdateTableData().addActionListener(new GeneralListener(new StockShowUI_UpdateDataTable(stockShowUI)));
		
		stockShowUI.getTfSearch().addFocusListener(new GeneralListener(new StockShowUI_TfSearchFocusProcess(stockShowUI)));
		stockShowUI.getTfSearch().addKeyListener(new GeneralListener(new StockShowUI_TfSearchKeyProcess(stockShowUI)));
	}

}
