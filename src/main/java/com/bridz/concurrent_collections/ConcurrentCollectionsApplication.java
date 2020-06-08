package com.bridz.concurrent_collections;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Set;

public class ConcurrentCollectionsApplication extends Thread {

	static ConcurrentHashMap<Integer, String> concurrentHashMap = new ConcurrentHashMap();

	public void run() {
		try {
			Thread.sleep(200);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		concurrentHashMap.put(1, "hii");
	}

	public static void main(String[] args) {
		
		concurrentHashMap.put(2, "how r u");
		concurrentHashMap.put(3, "i am fine");

		ConcurrentCollectionsApplication concurrentCollections = new ConcurrentCollectionsApplication();
		concurrentCollections.start();

		Set entrySet = concurrentHashMap.keySet();
		entrySet.forEach(data -> {
			System.out.println(concurrentHashMap.get(data));
			try {
				Thread.sleep(3000);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		});

	}
}
