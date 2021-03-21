import java.util.ArrayList;
import java.util.List;

public class Database {
	// Citizen Database
	
	List<Citizen> citizens = new ArrayList<Citizen>();
	
	public Database(Hospital hospital) {
		citizens.add(new Citizen(55235024758L, "Ahmet", "Ak", 1, false));
		citizens.add(new Citizen(17016936698L, "Sude", "Zeki", 2, false));
		citizens.add(new Citizen(79260426714L, "Yahya Burak", "Federal", 1, true));
		citizens.add(new Citizen(47948481072L, "Hayri", "Potur", 1, false));
		citizens.add(new Citizen(82726241776L, "Beyza", "Kazanç", 2, false));
		citizens.add(new Citizen(46386401642L, "Ali", "Yay", 1, false));
		citizens.add(new Citizen(81796725858L, "Hikmet", "Tavuk", 1, false));
		citizens.add(new Citizen(28552253484L, "Razý", "Açýkgöz", 1, false));
		citizens.add(new Citizen(93262321716L, "Melihat", "Boyacý", 2, false));
	}
	
	public Citizen getCitizen(Long id, String name, String surname) {
		for(Citizen c : citizens) {
			if(c.getID() == id && c.getName().toLowerCase().equals(name.toLowerCase()) && c.getSurname().toLowerCase().equals(surname.toLowerCase())) {
				return c;
			}
		}		
		return null;
	}
}
