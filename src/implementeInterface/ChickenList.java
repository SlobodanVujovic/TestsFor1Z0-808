package implementeInterface;
import java.util.ArrayList;
import java.util.List;

public class ChickenList implements HenHouse {
	List<Chicken> chickenList = new ArrayList<>();
	public List<Chicken> getChickens(){
		for (int i = 0; i < 5; i++){
			chickenList.add(new Chicken());
		}
		return chickenList;
	}
}
