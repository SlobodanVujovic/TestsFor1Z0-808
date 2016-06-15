package b;
import a.*;
public class B extends A {
	B() { }
	public void print(){
		System.out.println("B");
	}
	public static void main(String[] args){
		A a = new B();
		a.print();
	}
}
