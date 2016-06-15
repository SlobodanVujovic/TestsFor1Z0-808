package interfacesDontInheritFromObjectClass;

public class ConcreteEmployee implements Employee{
	/*
	 * Interfaces do not inherit from Object class. And there is no common "root" interface 
	 * implicitly inherited by all interfaces either (as in the case with classes) for that matter.
	 * 
	 * But how we are able to call the method of Object class on interface instance?
	 * An interface implicitly declared one method for each public method in Object. Thus the 
	 * equals method is implicitly declared as a member in an interface (unless it already inherits
	 * it from a super-interface).
	 */
	public static void main(String[] args) {
		Employee e = null;
		System.out.println(e.equals(null));
	}
}
