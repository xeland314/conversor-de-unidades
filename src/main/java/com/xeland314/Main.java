package com.xeland314;

import java.awt.EventQueue;
import com.xeland314.app.App;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
