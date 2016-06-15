package interfacesWihtOverridenMethods;

public interface Account {
	public default String getId(){
		return "0000"; 
	}
	public default int getNo(){
		return 1234; 
	}
}
