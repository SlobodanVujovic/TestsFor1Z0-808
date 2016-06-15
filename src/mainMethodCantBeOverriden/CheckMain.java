package mainMethodCantBeOverriden;

/*
 * Execute from CMD Prompt, and use "1 2 3" as arguments (without ").
 */

public class CheckMain{
	public static void main(int[] ints) {
		System.out.println("Int: " + ints[1]);
	}
	public static void main(Object[] object){
		System.out.println("Object: " + object[1]);
	}
	public static void main(String[] args) {
		System.out.println("String: " + args[1]);
	}
}