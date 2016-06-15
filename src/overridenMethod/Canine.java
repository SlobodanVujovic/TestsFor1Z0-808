package overridenMethod;

public class Canine {
	public double getAverageWeight(){
		return 50;
	}
	public static void main(String[] args) {
		Canine canine1 = new Canine();
		Wolf wolf = new Wolf();
		Canine canine2 = new Wolf();
		System.out.println(canine1.getAverageWeight());
		System.out.println(wolf.getAverageWeight());
		System.out.println(canine2.getAverageWeight());
	}
}
