package multithreadingFundamentalsImplementsRunnable.priority;

public class PriorityDemo {

	public static void main(String[] args) {
		Priority mt1 = new Priority("High Priority");
		Priority mt2 = new Priority("Low Priority");
		// set the priorities
		mt1.getThrd().setPriority(Thread.NORM_PRIORITY + 2);
		mt2.getThrd().setPriority(Thread.NORM_PRIORITY - 2);
		// start the threads
		mt1.getThrd().start();
		mt2.getThrd().start();
		try {
			mt1.getThrd().join();
			mt2.getThrd().join();
		} catch (InterruptedException exc) {
			System.out.println("Main thread interrupted.");
		}
		System.out.println("\nHigh priority thread getCount()ed to " + mt1.getCount());
		System.out.println("Low priority thread getCount()ed to " + mt2.getCount());
	}
}
