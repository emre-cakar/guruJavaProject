package com.guru.command;

import java.beans.PropertyVetoException;

import com.guru.help.Help;
import com.guru.model.StockType;
import com.guru.view.StockTypeUI;

public class StockTypeUI_SaveStockTypeCommand implements Command{
	private final StockTypeUI stockTypeUI;

	public StockTypeUI_SaveStockTypeCommand (StockTypeUI stockTypeUI) {
		this.stockTypeUI = stockTypeUI;
	}

	public void execute() {
		StockType stockType =stockTypeUI.prepareStockType();
		if (stockTypeUI.getTfCode().isEnabled() && stockType != null) {
			if (stockType.saveStockType(stockType)) {
				Help.showMsg("Kayıt işlemi tamamlanmıştır.");
				try {
					stockTypeUI.setClosed(true);
				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				Help.showMsg("Kayıt sırasında bir hata meydana gelmiştir.");
			}
		} else if (!(stockTypeUI.getTfCode().isEnabled()) && stockType != null) {
			if (stockType.updateStockType(stockType)) {
				Help.showMsg("Güncelleme işlemi tamamlanmıştır.");
				try {
					stockTypeUI.setClosed(true);
				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				Help.showMsg("Günceleme işlemi sırasında bir hata meydana gelmiştir.");
			}
		}
	}

}
