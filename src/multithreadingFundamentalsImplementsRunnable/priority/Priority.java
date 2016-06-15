package multithreadingFundamentalsImplementsRunnable.priority;

public class Priority implements Runnable {
	private int count;
	private Thread thrd;
	private static boolean stop = false;
	private static String currentName;

	public Priority(String name) {
		currentName = name;
		thrd = new Thread(this, name);
		count = 0;
	}

	public Thread getThrd() {
		return thrd;
	}

	public int getCount() {
		return count;
	}

	@Override
	public void run() {
		System.out.println(thrd.getName() + " starting.");
		do {
			count++;
			if (currentName.compareTo(thrd.getName()) != 0) {
				currentName = thrd.getName();
				System.out.println("In " + currentName);
			}
		} while (stop == false && count < 10000000);
		stop = true;
		System.out.println("\n" + thrd.getName() + " terminating.");
	}
}
