package multithreadingFundamentalsImplementsRunnable;

public class UseThreads {

	public static void main(String[] args) {
		System.out.println("Main thread starting.");

		MyThread mt1 = new MyThread("Child #1");
		MyThread mt2 = new MyThread("Child #2");
		MyThread mt3 = new MyThread("Child #3");

		try {
			mt1.getThrd().join();
			System.out.println("Child #1 joined.");
			mt2.getThrd().join();
			System.out.println("Child #2 joined.");
			mt3.getThrd().join();
			System.out.println("Child #3 joined.");
		} catch (InterruptedException exp) {
			System.out.println("Main thread interrupeted.");
		}
		System.out.println("Main thread ending.");
	}
}
