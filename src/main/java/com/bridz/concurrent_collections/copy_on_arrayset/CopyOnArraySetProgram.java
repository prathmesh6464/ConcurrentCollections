package com.bridz.concurrent_collections.copy_on_arrayset;

import java.util.concurrent.*;

public class CopyOnArraySetProgram extends Thread {

	static CopyOnWriteArraySet<String> copyOnWriteArraySet = new CopyOnWriteArraySet();

	public void run() {
		try {
			Thread.sleep(200);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		copyOnWriteArraySet.add("hii");
	}

	public static void main(String[] args) {

		copyOnWriteArraySet.add("how r u");
		copyOnWriteArraySet.add("i am fine");

		CopyOnArraySetProgram concurrentCollections = new CopyOnArraySetProgram();
		concurrentCollections.start();

		copyOnWriteArraySet.forEach(data -> {
			System.out.println(data);
			try {
				Thread.sleep(3000);
				copyOnWriteArraySet.remove(data);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		});

	}

}
