package com.guru.command;

import java.awt.Component;
import java.beans.PropertyVetoException;

import javax.swing.JDesktopPane;

import com.guru.help.Help;
import com.guru.model.Stock;
import com.guru.view.MainFrameUI;
import com.guru.view.StockSaveUI;
import com.guru.view.StockShowUI;

public class StockSaveUI_SaveCommand implements Command {
	private final StockSaveUI stockSaveUI;
	private MainFrameUI mf;

	public StockSaveUI_SaveCommand(StockSaveUI stockSaveUI) {
		this.stockSaveUI = stockSaveUI;
	}

	public void execute() {
		Stock stock = stockSaveUI.prepareStock();
		mf = stockSaveUI.getMf();
		JDesktopPane dp = mf.getDp();
		if (stockSaveUI.getTfCode().isEnabled() && stock != null) {
			if (stock.save(stock)) {
				Help.showMsg("Kayıt işlemi tamamlanmıştır.");
				try {
					stockSaveUI.setClosed(true);
				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				Component[] components = dp.getComponents();
				for (Component component : components) {
					if (component instanceof StockShowUI) {
						((StockShowUI) component).updateDataTable();
					}
				}

			} else {
				Help.showMsg("Kayıt sırasında bir hata meydana gelmiştir.");
			}
		} else if (!(stockSaveUI.getTfCode().isEnabled()) && stock != null) {
			if (stock.update(stock)) {
				Help.showMsg("Güncelleme işlemi tamamlanmıştır.");
				try {
					stockSaveUI.setClosed(true);
				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Component[] components = dp.getComponents();
				for (Component component : components) {
					if (component instanceof StockShowUI) {
						((StockShowUI) component).updateDataTable();
					}
				}
			} else {
				Help.showMsg("Günceleme işlemi sırasında bir hata meydana gelmiştir.");
			}
		}
	}
}
