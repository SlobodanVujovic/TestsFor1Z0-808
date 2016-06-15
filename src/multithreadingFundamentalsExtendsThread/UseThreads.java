package multithreadingFundamentalsExtendsThread;

public class UseThreads {

	public static void main(String[] args) {
		System.out.println("Main thread starting (extends Thread version).");

		MyThread mt = new MyThread("Child #1");

		for (int i = 0; i < 50; i++) {
			System.out.print(".");
			try {
				Thread.sleep(100);
			} catch (InterruptedException exp) {
				System.out.println("Main thread interrupeted.");
			}
		}
		System.out.println("Main thread ending.");
	}
}
