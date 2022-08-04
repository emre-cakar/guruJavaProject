package com.guru.help;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.guru.command.Command;

public class GeneralListener implements ActionListener, KeyListener, FocusListener {
	private final Command command;
    public GeneralListener(Command command) {
        this.command = command;
    }

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		command.execute(e);
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		command.execute(e);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		command.execute();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		command.execute();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		command.execute(e);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		command.execute();
	}

}
