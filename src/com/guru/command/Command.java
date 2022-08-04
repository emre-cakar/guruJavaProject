package com.guru.command;

import java.awt.event.ComponentEvent;

public interface Command {
	void execute();

	default void execute(ComponentEvent e) {

	};

}
