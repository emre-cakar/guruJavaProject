package com.guru.controller;



import com.guru.command.MainFrameUI_ShowStockTypeUICommand;
import com.guru.command.MainFrameUI_StockSaveCommand;
import com.guru.command.MainFrame_StockShowUICommand;
import com.guru.help.GeneralListener;
import com.guru.view.MainFrameUI;


public class MainFrameUIController {
	private final MainFrameUI mainFrame;
	
	public MainFrameUIController(MainFrameUI mainFrame) {
		this.mainFrame=mainFrame;
	}
	
	public void execute() {
		setListener();
	};
	
	public void setListener() {
		mainFrame.getMenuItemStocks().addActionListener(new GeneralListener(new MainFrame_StockShowUICommand(mainFrame)));
		mainFrame.getMenuItemStockSave().addActionListener(new GeneralListener(new MainFrameUI_StockSaveCommand(mainFrame)));
		mainFrame.getmenuItemStockTypeSave().addActionListener(new GeneralListener(new MainFrameUI_ShowStockTypeUICommand(mainFrame)));
	}
}
