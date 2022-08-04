package com.guru.command;

import java.beans.PropertyVetoException;

import com.guru.help.Help;
import com.guru.model.StockType;
import com.guru.view.StockTypeUI;

public class StockTypeUI_DeleteCommand implements Command{
	private final StockTypeUI stockTypeUI;
	
	public StockTypeUI_DeleteCommand(StockTypeUI stockTypeUI) {
		this.stockTypeUI=stockTypeUI;
	}
	public void execute() {
		StockType stockType = stockTypeUI.getStockTypeModel();
		if (stockType.getId()>0) {
			if(stockType.deleteStockType(stockType)) {
				Help.showMsg("Kayıt silinmiştir.");
				try {
					stockTypeUI.setClosed(true);
				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				Help.showMsg("Silme işlemi sırasında bir hata meydana gelmiştir.");
			}
		}else {
			Help.showMsg("Önce kayıtlı birini seçiniz.");
		}

	}
	

}
