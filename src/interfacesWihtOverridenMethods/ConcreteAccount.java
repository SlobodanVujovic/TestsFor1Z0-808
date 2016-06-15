package interfacesWihtOverridenMethods;

public class ConcreteAccount implements Account, PremiumAccount {

	public static void main(String[] args) {
		ConcreteAccount ca = new ConcreteAccount();
		System.out.println(ca.getId());
		System.out.println(ca.getNo());

	}

	@Override
	public String getId() {
		return "overriden method";
	}

}
