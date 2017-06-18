package com.prj.project1.threads;

import com.prj.project1.model.Person;

public class WorkerThread implements Runnable {
	private Person person;
	private AppManager appManager;
	
	public WorkerThread(AppManager appManager) {
		this.appManager = appManager;
	}

	public void run() {
		this.appManager.start();
		System.out.println("Worker thread started");
		this.person = new Person("fname","lname");
		this.person.setAge(25);
		this.person.setHeight(170);
		this.person.setWeight(62);
		Thread stopperThread = new Thread(new StopperThread(this.appManager));
		stopperThread.setDaemon(true);
		stopperThread.start();
		runUntillStopped();
	}

	private void runUntillStopped() {
		while (!this.appManager.shouldStop()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Worker thread stopped");
	}
}
