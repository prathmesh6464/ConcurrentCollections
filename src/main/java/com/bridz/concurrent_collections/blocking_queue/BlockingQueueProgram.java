package com.bridz.concurrent_collections.blocking_queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueProgram {

	public static void main(String[] args) throws Exception {

		BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(1024);

		BlockingQueueProducer queueProducer = new BlockingQueueProducer(blockingQueue);
		BlockingQueueConsumer queueConsumer = new BlockingQueueConsumer(blockingQueue);

		new Thread(queueProducer).start();
		new Thread(queueConsumer).start();
	}

}

class BlockingQueueProducer implements Runnable {

	protected BlockingQueue<String> blockingQueue;

	public BlockingQueueProducer(BlockingQueue<String> queue) {
		this.blockingQueue = queue;
	}

	public void run() {
		try {
			Thread.sleep(1000);
			blockingQueue.put("Prathamesh");
			Thread.sleep(1000);
			blockingQueue.put("Sandip");
			Thread.sleep(2000);
			blockingQueue.put("Jagruti");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class BlockingQueueConsumer implements Runnable {
	protected BlockingQueue<String> blockingQueue;

	public BlockingQueueConsumer(BlockingQueue<String> queue) {
		this.blockingQueue = queue;
	}

	public void run() {
		try {
			System.out.println(blockingQueue.take());
			System.out.println(blockingQueue.take());
			System.out.println(blockingQueue.take());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}