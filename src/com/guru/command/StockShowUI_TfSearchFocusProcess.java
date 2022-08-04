package com.guru.command;

import java.awt.event.ComponentEvent;

import com.guru.view.StockShowUI;

public class StockShowUI_TfSearchFocusProcess implements Command {
	private StockShowUI stockShowUI;
	
	public StockShowUI_TfSearchFocusProcess (StockShowUI stockShowUI) {
		this.stockShowUI=stockShowUI;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
	}
	public void execute(ComponentEvent e) {
		if (e.getID()==1004) {
			stockShowUI.getTfSearch().setText("");
		}else if (e.getID()==1005) {
			if (stockShowUI.getTfSearch().getText().isEmpty()) {
				stockShowUI.getTfSearch().setText("Ara...");
			}
		}
	}
	

}
