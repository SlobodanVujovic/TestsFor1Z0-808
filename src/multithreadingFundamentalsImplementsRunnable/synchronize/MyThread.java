package multithreadingFundamentalsImplementsRunnable.synchronize;

public class MyThread implements Runnable {
	Thread thrd;
	static SumArray sa = new SumArray();
	int a[];
	int answer;

	// Construct a new thread.
	MyThread(String name, int nums[]) {
		thrd = new Thread(this, name);
		a = nums;
		thrd.start(); // start the thread
	}

	// Begin execution of new thread.
	@Override
	public void run() {
		int sum;
		System.out.println(thrd.getName() + " starting.");
		synchronized (sa) {
			answer = sa.sumArray(a);
		}
		System.out.println("Sum for " + thrd.getName() + " is " + answer);
		System.out.println(thrd.getName() + " terminating.");
	}
}
