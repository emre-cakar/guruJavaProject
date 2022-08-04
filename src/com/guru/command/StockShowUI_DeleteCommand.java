package com.guru.command;

import java.awt.Component;

import javax.swing.JDesktopPane;

import com.guru.view.MainFrameUI;
import com.guru.view.StockShowUI;

public class StockShowUI_DeleteCommand implements Command{
	private StockShowUI stockShowUI;
	
	public  StockShowUI_DeleteCommand(StockShowUI stockShowUI) {
		this.stockShowUI=stockShowUI;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		stockShowUI.deleteStock();
		MainFrameUI mf = stockShowUI.getMf();
		JDesktopPane dp = mf.getDp();
		Component[] components = dp.getComponents();
		for (Component component : components) {
			if (component instanceof StockShowUI) {
				((StockShowUI) component).updateDataTable();
			}
		}
	}
	
	

}
