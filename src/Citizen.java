public class Citizen {
	private final long id;
	private final String name;
	private final String surname;
	private int sex = 1; // 1 = Man - 2 = Woman
	private boolean isPersonal = false;
	
	public Citizen(long id, String name, String surname, int sex, boolean isPersonal) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.sex = sex;
		this.isPersonal = isPersonal;
	}
	
	public long getID() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public int getSex() {
		return sex;
	}
	
	public boolean isPersonal() {
		return isPersonal;
	}
}
