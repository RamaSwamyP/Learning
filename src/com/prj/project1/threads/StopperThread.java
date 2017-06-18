package com.prj.project1.threads;

import java.io.File;

import com.prj.project1.main.Constants;

public class StopperThread implements Runnable {
	private AppManager program1;

	public StopperThread(AppManager obj) {
		this.program1 = obj;
	}

	public void run() {
		File taFolder = new File(Constants.flagDirPath);
		do {
			if (taFolder.list().length <= 0) {
				program1.stop();
				break;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (true);
	}
}
