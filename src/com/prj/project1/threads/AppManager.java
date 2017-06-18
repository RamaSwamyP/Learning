package com.prj.project1.threads;

public class AppManager {
	private volatile boolean stopFlag;
	
	public void start() {
		System.out.println("Start signal received");
		stopFlag = false;
	}
	
	public void stop() {
		System.out.println("Stop signal received");
		stopFlag = true;
	}
	
	public boolean shouldStop() {
		return stopFlag;
	}
}
