package com.guru;

import com.guru.controller.MainFrameUIController;
import com.guru.view.MainFrameUI;

public class Main {

	public static void main(String[] args) {
		MainFrameUIController mfc=new MainFrameUIController(new MainFrameUI());
		mfc.execute();
	}

}
