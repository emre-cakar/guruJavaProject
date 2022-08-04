package com.guru.command;

import java.awt.event.ComponentEvent;

import com.guru.view.StockSaveUI;

public class StockSaveUI_tfCodeFocusProcess implements Command{
	private final StockSaveUI stockSaveUI;
	
	public StockSaveUI_tfCodeFocusProcess(StockSaveUI stockSaveUI) {
		this.stockSaveUI=stockSaveUI;
	}

	@Override
	public void execute() {
		
	}
	
	@Override
	public void execute(ComponentEvent e) {
		if (e.getID()==1005) {
			stockSaveUI.SetFocusOFTfCode();
		}
	}

}
