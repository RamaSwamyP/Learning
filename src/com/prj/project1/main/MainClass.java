package com.prj.project1.main;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import com.prj.project1.threads.AppManager;
import com.prj.project1.threads.WorkerThread;

public class MainClass {

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Program needs arguments to be passed");
			System.exit(0);
		}
		String command = args[0];
		File taFolder = new File(Constants.flagDirPath);

		if ("start".equalsIgnoreCase(command)) {
			if (taFolder.list().length > 0) {
				System.out.println("Program is already running");
				System.exit(0);
			}
			startProgram();
		} else if ("stop".equalsIgnoreCase(command)) {
			if (taFolder.list().length <= 0) {
				System.out.println("Program is not running");
				System.exit(0);
			}
			stopProgram();
		}
	}

	public static void startProgram() {
		String taFilePath = Constants.flagDirPath + new Random().nextLong();
		try {
			File taFile = new File(taFilePath);
			taFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		AppManager appManager = new AppManager();
		Thread worker = new Thread(new WorkerThread(appManager));
		worker.start();
	}

	public static void stopProgram() {
		File taFolder = new File(Constants.flagDirPath);
		Arrays.stream(taFolder.listFiles()).forEach(File::delete);
	}
}
