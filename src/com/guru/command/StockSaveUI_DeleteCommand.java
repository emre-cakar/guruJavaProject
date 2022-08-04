package com.guru.command;

import java.beans.PropertyVetoException;

import com.guru.help.Help;
import com.guru.model.Stock;
import com.guru.view.StockSaveUI;

public class StockSaveUI_DeleteCommand implements Command{
	private final StockSaveUI stockSaveUI;
	
	public StockSaveUI_DeleteCommand(StockSaveUI stockSaveUI) {
		this.stockSaveUI=stockSaveUI;
	}
	
	public void execute() {
		Stock stock=stockSaveUI.prepareStock();
		if(stock.delete(stock.getCode())) {
			Help.showMsg("Kayıt silinmiştir.");
			try {
				stockSaveUI.setClosed(true);
			} catch (PropertyVetoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			Help.showMsg("Silme işlemi sırasında bir hata meydana gelmiştir.");
		}
	}

}
