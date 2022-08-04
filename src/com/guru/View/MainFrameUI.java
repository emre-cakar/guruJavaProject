package com.guru.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainFrameUI extends JFrame{
	private JMenuBar menuBar;
	private JMenu menuStock;
	private JMenuItem menuItemStocks, menuItemStockSave,menuItemStockTypeSave;
	private JDesktopPane dp;
	
	
	public MainFrameUI() {
		initMainFrame();
	}
	
	public void initMainFrame() {
		dp=new JDesktopPane();
		menuBar=initMenuBar();
		
		setJMenuBar(menuBar);
		add(dp, BorderLayout.CENTER);
		setResizable(true);
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(750, 600));
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public JMenuBar initMenuBar() {
		menuBar=new JMenuBar();
		menuStock=new JMenu("Stok");
		
		menuItemStocks=new JMenuItem("Stok Kart Listesi");
		menuItemStockSave=new JMenuItem("Stok Kart");
		menuItemStockTypeSave=new JMenuItem("Stok Kart Tipi");
		menuStock.add(menuItemStocks);
		menuStock.add(menuItemStockSave);
		menuStock.add(menuItemStockTypeSave);
		menuBar.add(menuStock);
		return menuBar;
	}

	
	//Getter
	public JDesktopPane getDp() {
		return dp;
	}
	public JMenuItem getMenuItemStocks() {
		return menuItemStocks;
	}
	public JMenuItem getMenuItemStockSave() {
		return menuItemStockSave;
	}
	public JMenuItem getmenuItemStockTypeSave() {
		return menuItemStockTypeSave;
	}

	public ArrayList<StockShowUI> getStokShowList(){
		ArrayList<StockShowUI> ALStockSaveUI=new ArrayList<StockShowUI>();
        Component[] components = dp.getComponents();
        for (Component component : components) {
            if (component instanceof StockShowUI) {
            	ALStockSaveUI.add((StockShowUI) component);
            }
        }
		return ALStockSaveUI;
	}
	public ArrayList<StockSaveUI> getStokSaveList(){
		ArrayList<StockSaveUI> ALStockShowUI=new ArrayList<StockSaveUI>();
        Component[] components = dp.getComponents();
        for (Component component : components) {
            if (component instanceof StockSaveUI) {
            	ALStockShowUI.add((StockSaveUI) component);
            }
        }
		return ALStockShowUI;
	}

}
