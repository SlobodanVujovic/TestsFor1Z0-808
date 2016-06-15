package interfacesWihtOverridenMethods;

public interface PremiumAccount extends Account{
	public String getId();
	public default int getNo(){
		return 4321; 
	}
}

