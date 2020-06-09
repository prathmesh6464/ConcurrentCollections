package com.bridz.concurrent_collections.copy_on_arraylist;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListProgram extends Thread {

	static CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList();

	public void run() {
		try {
			Thread.sleep(200);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		copyOnWriteArrayList.add("hii");
	}

	public static void main(String[] args) {

		copyOnWriteArrayList.add("how r u");
		copyOnWriteArrayList.add("i am fine");

		CopyOnWriteArrayListProgram concurrentCollections = new CopyOnWriteArrayListProgram();
		concurrentCollections.start();

				copyOnWriteArrayList.forEach(data -> {
					System.out.println(data);
					try {
						Thread.sleep(3000);
					} catch (Exception exception) {
						exception.printStackTrace();
					}
				});

	}

}
